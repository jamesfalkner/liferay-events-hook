<%@ include file="init.jsp" %>


<script type="text/javascript">
    Highcharts.setOptions({
        global: {
            timezoneOffset: -2 * 60
        }
    });
</script>

<%
try {
	String event = request.getParameter("event");
    String timeSince = request.getParameter("timeSince");
	final long companyId = PortalUtil.getCompanyId(request);

	String className = "com.liferay.events.BeaconData";
	String currentUrl = request.getRequestURL().toString();

    String regionsCol = "regions";

    List<ExpandoTable> allTables = ExpandoTableLocalServiceUtil.getExpandoTables(-1, -1);
	if (Validator.isNotNull(event)) {

		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);

        List<ExpandoRow> allRows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);

        if (timeSince != null) {
            List<ExpandoValue> dateStampOrig = ExpandoValueLocalServiceUtil.getColumnValues(companyId, className, event, "date", -1, -1);

            List<ExpandoValue> dateStamps = new ArrayList<ExpandoValue>();

            Long timeSinceLong = Long.parseLong(timeSince);
            Date timeSinceDate = new Date(timeSinceLong - (timeSinceLong > (5 * 60000) ? (5 * 60000) : 0));

            for (ExpandoValue tst : dateStampOrig) {
                if (tst.getDate().after(timeSinceDate)) {
                    dateStamps.add(tst);
                }
            }

            System.out.println("using this for raw: " + dateStamps);

            if (dateStamps.isEmpty()) {
                %> [] <%
                return;
            }
            Collections.sort(dateStamps, new Comparator<ExpandoValue>() {
                @Override
                public int compare(ExpandoValue ev1, ExpandoValue ev2) {
                    try {
                        Date d1 = ev1.getDate();
                        Date d2 = ev2.getDate();
                        return d1.compareTo(d2);
                    } catch (Exception ex) {
                        return 0;
                    }
                }
            });

            long firstDate = dateStamps.get(0).getDate().getTime();
            long lastDate = dateStamps.get(dateStamps.size() - 1).getDate().getTime();
            long lastBucket = (lastDate - firstDate) / (5 * 1000);

            System.out.println("firstDate : " + dateStamps.get(0).getDate() +
                    " lastDate: " + dateStamps.get(dateStamps.size() - 1).getDate() +
                    " lastBucket: " + lastBucket);

            // [RegionName, [TimeBucket, [id, id, id, id]]]
            Map<String, Map<Long, Set<String>>> regionPings = new HashMap<String, Map<Long, Set<String>>>();
            for (ExpandoValue obj : dateStamps) {

                Date rowDate = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "date", obj.getClassPK()).getDate();
                String rowId = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "id", obj.getClassPK()).getString();
                String rowRegions = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "regions", obj.getClassPK()).getString();
                Long timeBucket = (rowDate.getTime() - firstDate) / (5*1000);
                JSONArray regs = JSONFactoryUtil.createJSONArray(rowRegions);

                for (int i = 0; i < regs.length(); i++) {
                    String reg = regs.getString(i).trim();
                    if (Validator.isNull(reg)) continue;
                    Map<Long, Set<String>> pings = regionPings.get(reg);
                    if (pings != null) {
                        for (long fut = 0 ; fut < (12 * 5); fut++) {
                            Set<String> pingStrs = pings.get(timeBucket + fut);
                            if (pingStrs != null) {
                                pingStrs.add(rowId);
                            } else {
                                pingStrs = new HashSet<String>();
                                pingStrs.add(rowId);
                                pings.put(timeBucket + fut, pingStrs);
                            }
                        }
                    } else {
                        for (long fut = 0 ; fut < (12 * 5); fut++) {
                            pings = new HashMap<Long, Set<String>>();
                            Set<String> newPingStrs = new HashSet<String>();
                            newPingStrs.add(rowId);
                            pings.put(timeBucket + fut, newPingStrs);
                            regionPings.put(reg, pings);
                        }
                    }
                }
            }

            System.out.println("json'ing map: " + regionPings);
            // [RegionName, [TimeBucket, [id, id, id, id]]]

            JSONArray result = JSONFactoryUtil.createJSONArray();
            for (String regStr : regionPings.keySet()) {
                JSONArray points = JSONFactoryUtil.createJSONArray();
                Map<Long, Set<String>> pings = regionPings.get(regStr);
                for (Long bucket : pings.keySet()) {
                    JSONArray singlePoint = JSONFactoryUtil.createJSONArray();
                    long stamp = firstDate + (bucket * 5000);
                    singlePoint.put(stamp);
                    singlePoint.put(pings.get(bucket).size());
                    points.put(singlePoint);
                }
                JSONObject regRes = JSONFactoryUtil.createJSONObject();
                regRes.put("regionName", regStr);
                regRes.put("regionPoints", points);
                result.put(regRes);
            }
            System.out.println("sending result: " + result.toString());
            %> <%= result %> <%
            return;

        }

        List<ExpandoValue> allRegPings = ExpandoValueLocalServiceUtil.getColumnValues(companyId, className, event, regionsCol, -1, -1);
        Set<String> allRegNames = new HashSet<String>();
        for (ExpandoValue ping : allRegPings) {
            JSONArray regs = JSONFactoryUtil.createJSONArray(ping.getString());
            for (int i = 0; i < regs.length(); i++) {
                allRegNames.add(regs.getString(i));
            }
        }
%>
<h1>Liferay Events Mobile App Beacon Data</h1>
<em>Click on an event below to see beacon data for that event.</em>
<hr>


<%
    for (ExpandoTable tbl: allTables) {
        if (!className.equals(tbl.getClassName())) {
            continue;
        }

        String name = tbl.getName();
        String evtUrl = currentUrl + "?event=" + HtmlUtil.escapeURL(name);
%>
<p><a href="<%= evtUrl %>">Beacon Data for <%=name %></a></p>
<%
    }


%>

<h3><%= allRows.size()%> total region pings</h3>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.highcharts.com/highcharts.js"></script>
<script src="//code.highcharts.com/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<script type="text/javascript">

    var chart;

    var nowAtStart = new Date();

    var lastTimeFetched = 0;
    var requestData = function() {
        $.ajax({
            url: '/html/mdata-private/liferay-beacons-service-view-realtime.jsp?event=<%= HtmlUtil.escapeURL(event) %>&timeSince=' + lastTimeFetched,
            dataType: 'json',
            
            success: function(seriesArr) {
                var now = new Date();

                console.log("now: " + now.getTime() + " success! SERIESARR has " + seriesArr.length + " series objects");

                seriesArr.forEach(function(seriesObj) {
                    console.log("seriesObj " + seriesObj.regionName + " has " + seriesObj.regionPoints.length + " points");
                    var series = chart.get(seriesObj.regionName);
                    console.log("adding points to series: " + series.name +": " + JSON.stringify(seriesObj.regionPoints));
                    seriesObj.regionPoints.forEach(function(point) {
                        if (point[0] >= lastTimeFetched && point[0] <= now.getTime()) {
                            console.log("added point " + JSON.stringify(point) + " at x val: " + new Date(point[0]));
                            var shi = false;
                            console.log("length: " + series.data.length + " shi is: " + shi);
                            if (series.data.length > 20) {
                                shi = true;
                            }
                            series.addPoint(point, true, shi);
                        }
                    });
                });

                lastTimeFetched = new Date().getTime();
                // call it again after 5 seconds
                setTimeout(function() {
                    requestData();
                }, 5000);
            },
            cache: false
        });
    };

    var startDataRequests = function(e) {
        lastTimeFetched = nowAtStart.getTime() - (50 * 1000);
        requestData();
    };


    $(document).ready(function() {

    chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'line',
                events: {
                    load: startDataRequests
                },
                zoomType: 'x',
                spacingRight: 20
            },
            title: {
                text: 'Liferay Events Live Region Pings',
                x: -20 //center
            },
            xAxis: {
                tickPixelInterval: 150,
                type: 'datetime',
                title: {
                    text: "Time of Day"
                }
            },
            yAxis: {
                title: {
                    text: 'Number of pings'
                }
            },
            tooltip: {
                valueSuffix: ' pings'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
        plotOptions: {
            area: {
                stacking: 'normal',
                lineColor: '#666666',
                lineWidth: 1,
                marker: {
                    lineWidth: 1,
                    lineColor: '#666666'
                }
            }
        },

        series:  // Map<String, Map<Long, Set<String>>> regionPings
                [
                    <%
                    Iterator<String> it = allRegNames.iterator();
                    while (it.hasNext()) {
                        String regName = it.next();

                        %>
                    {
                        type: 'line',
                        name: 'Region: <%= HtmlUtil.escapeJS(regName) %>',
                        id: '<%=HtmlUtil.escapeJS(regName)%>',
                        data: []
                    }
                    <% if (it.hasNext()) {
                        %> , <%
                        }
                    }
                      %> ]


        });
    });

        </script>


		<%
    }

} catch (Exception ex) {
%>
	Error: <%= ex.getLocalizedMessage() %>"
    <% ex.printStackTrace(); %>
<%
}
%>
