<%@ include file="init.jsp" %>

<h1>Liferay Events Mobile App Beacon Data</h1>
<em>Click on an event below to see beacon data for that event.</em>
<hr>

<%
    try {
        String event = request.getParameter("event");
        String deleteAll = request.getParameter("deleteAll");
        String generate = request.getParameter("generate");
        final long companyId = PortalUtil.getCompanyId(request);

        String className = "com.liferay.events.BeaconData";
        int stringColumnType = 15;
        int dateColumnType = 3;
        String currentUrl = request.getRequestURL().toString();

        String idCol = "id";
        String beaconsCol = "beacons";
        String regionsCol = "regions";
        String dateCol = "date";

        List<ExpandoTable> allTables = ExpandoTableLocalServiceUtil.getExpandoTables(-1, -1);
        for (ExpandoTable tbl: allTables) {
            if (!className.equals(tbl.getClassName())) {
                continue;
            }

            String name = tbl.getName();
            String evtUrl = currentUrl + "?event=" + HtmlUtil.escapeURL(name);
%>
<button onclick="if (confirm('Generate Fake Data??')) location.href='<%=currentUrl%>?generate=true'">Generate fake event beacon data</button>

<p><a href="<%= evtUrl %>">Beacon Data for <%=name %></a></p>
<%
    }

    if (generate != null) {

        List<String> allCurrentEvents = new ArrayList<String>();
        for (ExpandoTable tbl: allTables) {
            if (!className.equals(tbl.getClassName())) {
                continue;
            }

            String name = tbl.getName();
            allCurrentEvents.add(name);
        }

        for (String fakeEvent : allCurrentEvents) {

            ExpandoTable tbl = ExpandoTableLocalServiceUtil.getTable(companyId, className, fakeEvent);

            ExpandoValueLocalServiceUtil.deleteTableValues(tbl.getTableId());

            List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, fakeEvent, -1, -1);
            for (ExpandoRow row : rows) {
                ExpandoRowLocalServiceUtil.deleteRow(row.getRowId());
            }
            ExpandoTableLocalServiceUtil.deleteTable(tbl.getTableId());

        }

        String[] fakeEvents = new String[] {"Benelux Solutions Forum", "France Symposium", "North America Symposium", "DevCon Frankfurt"};

        for (String fakeEvent: fakeEvents) {


            ExpandoTable fakeTable = ExpandoTableLocalServiceUtil.addTable(companyId, className, fakeEvent);
            ExpandoColumnLocalServiceUtil.addColumn(fakeTable.getTableId(), dateCol, dateColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(fakeTable.getTableId(), beaconsCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(fakeTable.getTableId(), regionsCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(fakeTable.getTableId(), idCol, stringColumnType);



            Date now = new Date();
            String[] proximities = new String[] {"near", "far", "immediate"};
            String[] regions = new String[] {"Venue", "Registration", "Partners", "Grand Ballroom", "Bar"};
            String[] beacons = new String[] {"Componence", "GFI", "Smile", "iProfs", "SQLI", "CGI", "ORANGE", "Mystery Guest"};

            for (int i = 0; i < 70; i++) {
                int people = (int)Math.floor(Math.random() * 100);
                if (i > 23 && i < 30) people = (int)((double)people * 4);
                if (i > 50 && i < 60) people = (int)((double)people * 3);
                if (i > 40 && i < 42) people = (int)((double)people * 2);
                if (i > 60 && i < 64) people = (int)((double)people * 3);
                for (int p = 0; p < people; p++) {
                    int numRegions = (int)Math.floor(Math.random() * (regions.length + 1));
                    if (i == 23 || i == 70) {
                        numRegions += 5;
                    }
                    int numBeacons = (int)Math.floor(Math.random() * (beacons.length + 1));
                    String id = Double.toString(Math.random());
                    long newTime = now.getTime() + (i * (5 * 60 * 1000));
                    Date newDate = new Date(newTime);
                    long classPK = (event+id+newDate.getTime()).hashCode();
                    JSONArray regArr = JSONFactoryUtil.createJSONArray();
                    JSONArray beacArr = JSONFactoryUtil.createJSONArray();
                    for (int r = 0; r < numRegions; r++) {
                        regArr.put(regions[(int)(Math.random() * regions.length)]);
                    }
                    if (i < 15) {
                        for (int e = 0; e < 30; e++) {
                            regArr.put(regions[3]);
                        }
                    }
                    if (i > 40 && i < 55) {
                        for (int e = 0; e < 250; e++) {
                            regArr.put(regions[2]);
                        }
                    }

                    for (int r = 0; r < numBeacons; r++) {
                        JSONObject obj = JSONFactoryUtil.createJSONObject();
                        obj.put("beacon_name", beacons[(int)(Math.random() * beacons.length)]);
                        obj.put("proximity", proximities[(int)(Math.random() * proximities.length)]);
                        beacArr.put(obj);
                    }
                    ExpandoValueLocalServiceUtil.addValue(companyId, className, fakeEvent, dateCol, classPK, newDate);
                    ExpandoValueLocalServiceUtil.addValue(companyId, className, fakeEvent, idCol, classPK, id);
                    ExpandoValueLocalServiceUtil.addValue(companyId, className, fakeEvent, beaconsCol, classPK, beacArr.toString());
                    ExpandoValueLocalServiceUtil.addValue(companyId, className, fakeEvent, regionsCol, classPK, regArr.toString());
                }
            }
        }

        response.sendRedirect(currentUrl);
    }

    if (Validator.isNotNull(event)) {

        ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);

        if (deleteAll != null) {
            ExpandoValueLocalServiceUtil.deleteTableValues(table.getTableId());

            List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);
            for (ExpandoRow row : rows) {
                ExpandoRowLocalServiceUtil.deleteRow(row.getRowId());
            }
            ExpandoTableLocalServiceUtil.deleteTable(table.getTableId());
            response.sendRedirect(currentUrl);
        }

        List<ExpandoRow> allRows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);

%>
<h3><%= allRows.size()%> total region pings</h3>
<button onclick="if (confirm('Delete All beacon Results? You won\'t be able to get them back!')) location.href='<%=currentUrl%>?deleteAll=true&event=<%= HtmlUtil.escapeURL(event)%>'">Delete All <%= event %> beacon data</button>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.highcharts.com/highcharts.js"></script>
<script src="//code.highcharts.com/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<%

    List<ExpandoValue> dateStampOrig = ExpandoValueLocalServiceUtil.getColumnValues(companyId, className, event, "date", -1, -1);

    List<ExpandoValue> dateStamps = new ArrayList<ExpandoValue>();
    dateStamps.addAll(dateStampOrig);

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
    long lastBucket = (lastDate - firstDate) / (5 * 60 * 1000);
    System.out.println("lastBucket: " + lastBucket);
    // [RegionName, [TimeBucket, [id, id, id, id]]]
    Map<String, Map<Long, Set<String>>> regionPings = new HashMap<String, Map<Long, Set<String>>>();
    // [BeaconName, [proximity, [TimeBucket, [id, id, id]]]]
    Map<String, Map<String, Map<Long, Set<String>>>> beaconPings = new HashMap<String, Map<String, Map<Long, Set<String>>>>();


    for (ExpandoRow row : allRows) {

        Date rowDate = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "date", row.getClassPK()).getDate();
        String rowId = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "id", row.getClassPK()).getString();
        String rowRegions = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "regions", row.getClassPK()).getString();
        String rowBeacons = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "beacons", row.getClassPK()).getString();
        Long timeBucket = (rowDate.getTime() - firstDate) / (5*60*1000);
        JSONArray regs = JSONFactoryUtil.createJSONArray(rowRegions);
        JSONArray beacs = JSONFactoryUtil.createJSONArray(rowBeacons);
        for (int i = 0; i < regs.length(); i++) {
            String reg = regs.getString(i).trim();
            if (Validator.isNull(reg)) continue;
            Map<Long, Set<String>> pings = regionPings.get(reg);
            if (pings != null) {
                Set<String> pingStrs = pings.get(timeBucket);
                if (pingStrs != null) {
                    pingStrs.add(rowId);
                } else {
                    pingStrs = new HashSet<String>();
                    pingStrs.add(rowId);
                    pings.put(timeBucket, pingStrs);
                }
            } else {
                pings = new HashMap<Long, Set<String>>();
                Set<String> newPingStrs = new HashSet<String>();
                newPingStrs.add(rowId);
                pings.put(timeBucket, newPingStrs);
                regionPings.put(reg, pings);
            }
        }
        // [BeaconName, [proximity, [TimeBucket, [id, id, id]]]]

        for (int i = 0; i < beacs.length(); i++) {
            JSONObject beacPings = beacs.getJSONObject(i);
            String beacName = beacPings.getString("beacon_name");
            String beacProx = beacPings.getString("proximity");
            Map<String, Map<Long, Set<String>>> beacMap = beaconPings.get(beacName);
            if (beacMap != null) {
                Map<Long, Set<String>> beacTimes = beacMap.get(beacProx);
                if (beacTimes != null) {
                    Set<String> beacProxs = beacTimes.get(timeBucket);
                    if (beacProxs != null) {
                        beacProxs.add(rowId);
                    } else {
                        beacProxs = new HashSet<String>();
                        beacProxs.add(rowId);
                        beacTimes.put(timeBucket, beacProxs);

                    }
                } else {
                    beacTimes = new HashMap<Long, Set<String>>();
                    Set<String> newSet = new HashSet<String>();
                    newSet.add(rowId);
                    beacTimes.put(timeBucket, newSet);
                    beacMap.put(beacProx, beacTimes);
                }
            } else {
                beacMap = new HashMap<String, Map<Long, Set<String>>>();
                Map<Long, Set<String>> newBeacs = new HashMap<Long, Set<String>>();
                Set<String> newSet = new HashSet<String>();
                newSet.add(rowId);
                newBeacs.put(timeBucket, newSet);
                beacMap.put(beacProx, newBeacs);
                beaconPings.put(beacName, beacMap);
            }
        }
    }
    System.out.println("Beacon prox map: " + beaconPings);

    for (String beaconName : beaconPings.keySet()) {

%> <div id="beaconcontainer-<%=beaconName.hashCode()%>" style="min-width: 310px; height: 400px; margin: 0 auto"></div> <%

    }
%>




<script type="text/javascript">
    Highcharts.setOptions({
        global: {
            timezoneOffset: 4 * 60
        }
    });
    $(function () {
        $('#container').highcharts({
            chart: {
                zoomType: 'x',
                spacingRight: 20
            },
            title: {
                text: 'Liferay Events Region Pings',
                x: -20 //center
            },
            subtitle: {
                text: 'Browse the times!',
                x: -20
            },
            xAxis: {
                type: 'datetime',
                maxZoom: 60 * 60 * 1000, // 1 hour
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
            series:  // Map<String, Map<Long, Set<String>>> regionPings
                    [
                        <%

                        Iterator<String> it = regionPings.keySet().iterator();
                        while (it.hasNext()) {
                            String regName = it.next();

                            %>
                        {
                            type: 'line',
                            name: 'Region: <%= HtmlUtil.escapeJS(regName) %>',
                            pointInterval: 5 * 60 * 1000,
                            pointStart: <%= firstDate %>,
                            data: [
                                <%
                                Map<Long, Set<String>> pings = regionPings.get(regName);
                                for (long i = 0; i <= lastBucket; i++) {
                                    Set<String> pingRaw = pings.get(i);
                                    if (pingRaw != null) {
                                        %> <%= pingRaw.size() %> <%
                            } else {
                                %> 0 <%
                            }
                            if (i < lastBucket) {
                                %> , <%
                            }
                        }
                        %> ]
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
    // [BeaconName, [proximity, [TimeBucket, [id, id, id]]]]

    for (String beaconName : beaconPings.keySet()) {

%>


<script type="text/javascript">
    $(function () {
        $('#beaconcontainer-<%=beaconName.hashCode()%>').highcharts({
            chart: {
                type: 'area',
                zoomType: 'x',
                spacingRight: 20
            },
            title: {
                text: 'Liferay Events Beacon Pings: <%= beaconName %>',
                x: -20 //center
            },
            subtitle: {
                text: 'Browse the times!',
                x: -20
            },
            xAxis: {
                type: 'datetime',
                maxZoom: 60 * 60 * 1000, // 1 hour
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
            series:
                    [
                        <%
            // [BeaconName, [proximity, [TimeBucket, [id, id, id]]]]
                        Map<String, Map<Long, Set<String>>> pings = beaconPings.get(beaconName);

                        it = pings.keySet().iterator();
                        while (it.hasNext()) {
                            String proxName = it.next();

                            %>
                        {
                            name: 'Beacon: <%= HtmlUtil.escapeJS(proxName) %>',
                            pointInterval: 5 * 60 * 1000,
                            pointStart: <%= firstDate %>,
                            data: [
                                <%
                                Map<Long, Set<String>> graphPings = pings.get(proxName);
                                for (long i = 0; i <= lastBucket; i++) {
                                    Set<String> pingRaw = graphPings.get(i);
                                    if (pingRaw != null) {
                                        %> <%= pingRaw.size() %> <%
                            } else {
                                %> 0 <%
                            }
                            if (i < lastBucket) {
                                %> , <%
                            }
                        }
                        %> ]
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


    }

} catch (Exception ex) {
%>
Error: <%= ex.getLocalizedMessage() %>"
<%
    }
%>
