<%@ page import="com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.util.portlet.PortletProps" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>


<%
    String gApiKey = PortletProps.get("liferay.events.goo.gl.api.key");
    if (gApiKey == null) {
         gApiKey = "UNKNOWN";
    }

    String answerBaseUrl = GetterUtil.getString(portletPreferences.getValue("answerBaseUrl", ""));

%>
<script src="//code.jquery.com/jquery-1.11.3.js"></script>
<script src="//code.highcharts.com/highcharts.js"></script>
<script src="//code.highcharts.com/highcharts-more.js"></script>
<script src="//code.highcharts.com/modules/solid-gauge.js"></script>
<script src="//code.highcharts.com/modules/exporting.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.6/d3.min.js" charset="utf-8"></script>
<script src="/html/js/d3.layout.cloud.js"></script>
<script src="https://apis.google.com/js/client.js"></script>


<div class="row-fluid">
    <div class="span4">
        <select style="width: auto;" name="parent_selection" id="parent_selection">
            <option value="">-- <%= LanguageUtil.get(locale, "events") %> --</option>

            <%
                for (String evt : EventPollQuestionLocalServiceUtil.getAllEvents()) {
            %>
            <option value="<%= evt %>"><%= evt %>
            </option>
            <%
                }
            %>
        </select>

        <div>
            <select style="width: auto;" name="child_selection" id="child_selection">
            </select>

        </div>
    </div>
    <div class="span8">
        <div id="count" style="text-align: center; display: none">
            <span id="countNumber" style="color: #005a98; font-size: 10em;">
                --
            </span>&nbsp;<span id="countLabel" style="color: #005a98; font-size: 5em;">
                <%= LanguageUtil.get(locale, "responses") %>
            </span>

        </div>
        <br><br><br>

        <div style="text-align: center; display: none; border: 1px solid gray; line-height: 4em" id="shorturlContainer">
            <span id="shorturl"
                  style="font-family: monospace; color: black; font-size: 4em; text-align: center;"></span>
        </div>

    </div>
</div>

<hr>
<div id="container" style="margin: 0 auto"></div>

<div class="row-fluid">
    <div class="span6">
        <div id="container1" style="margin: 0 auto"></div>

    </div>
    <div class="span6">
        <div id="container2" style="margin: 0 auto"></div>
    </div>
</div>

<script language="javascript" type="text/javascript">

    var poller, questionPoller, pollChart, pollChart2;
    var colors = Highcharts.getOptions().colors;
    var eventQuestions = {};
    var currentEvent = "";

    function showResults(questionId) {
        $("#container").html('');
        $("#container1").html('');
        $("#container2").html('');

        clearTimeout(poller);

        var q = null;

        var eventId = $("#parent_selection").val();
        eventQuestions[eventId].forEach(function (eq) {
            if (eq.questionId == questionId) {
                q = eq;
            }
        });

        if (!q) {
            return;
        }

        if (q.showResponseCount) {
            $('#count').css('display', 'block');
        } else {
            $('#count').css('display', 'none');
        }

        function shortenUrl() {

            var request = gapi.client.urlshortener.url.insert({
                resource: {
                    longUrl: '<%= answerBaseUrl%>' + '?questionId=' + q.questionId
                }
            });
            request.execute(function (response) {
                var shortUrl = response.id;
                $('#shorturl').text(shortUrl);
                $('#shorturlContainer').css('display', 'block');
            });
        }

        gapi.client.setApiKey('<%=gApiKey%>');
        gapi.client.load("urlshortener", "v1", shortenUrl);

        switch (q.questionType) {
            case 'single':
            case 'multiple':
                switch (q.chartType) {
                    case 'pie':
                        pie(q);
                        break;
                    case 'bar':
                    default:
                        bar(q);
                }
                break;
            case 'ranking':
                stacked(q);
                break;
            case 'rating':
                gauge(q);
                break;
            case 'text':
                wordcloud(q);
                break;
            default:
        }
    }

    function populateQuestions(eventId) {
        AUI().use('array-extras', function (A) {

            Liferay.Service(
                    '/liferay-events-hook.eventpollquestion/get-questions',
                    {
                        eventId: eventId,
                        enabled: true
                    },
                    function (obj) {
                        if (obj.exception) {
                            alert(obj.message);
                            return;
                        }
                        if (!Array.isArray(obj)) {
                            return;
                        }

                        var html = "";
                        var owners = [];

                        if (currentEvent == eventId && eventQuestions[eventId] && eventQuestions[eventId].length == obj.length) {
                            // see if they're the same
                            var same = true;
                            var existingIds = eventQuestions[eventId].map(function (eq) {
                                return eq.questionId;
                            });
                            obj.forEach(function (q) {
                                if (existingIds.indexOf(obj.questionId) >= 0) {
                                    same = false;
                                }
                            });
                            if (same) {
                                // nothing's added or removed, so don't do nothin
                                return;
                            }

                        }
                        eventQuestions[eventId] = [];


                        obj.forEach(function (question) {
                            eventQuestions[eventId].push(question);
                            var owner = question.sponsorName;
                            if (owners.indexOf(owner) == -1) {
                                owners.push(owner);
                            }
                        });

                        $('#child_selection').html('').append('<option value="none">-- <%= LanguageUtil.get(locale, "selection") %> --</option>');

                        owners.forEach(function (owner) {
                            obj.forEach(function (question) {
                                if (question.sponsorName != owner) {
                                    return;
                                }
                                $('#child_selection').append('<option value="' + question.questionId + '">' + owner + ': ' + question.shortTitle + '</option>');
                            });
                        });

                        currentEvent = eventId;
                    });
        });
    }

    function stacked(q) {
        var categories = JSON.parse(q.choices);

        pollChart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'column' // change this to column if want to show the column chart
            },
            title: {
                text: q.question
            },
            subtitle: {
                text: q.eventId
            },
            xAxis: {
                categories: q.anonymousResults ? categories.map(function (choice, idx) {
                    return ('<%= LanguageUtil.get(locale, "choice") %> ' + (idx + 1))
                }) : categories
            },
            yAxis: {
                title: {
                    text: '<%= LanguageUtil.get(locale, "score") %>'
                }
            },
            legend: {
                align: 'right',
                x: -30,
                verticalAlign: 'top',
                y: 90,
                floating: true,
                backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                borderColor: '#CCC',
                borderWidth: 1,
                shadow: true
            },
            tooltip: {
                enabled: false
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true,
                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                        style: {
                            textShadow: '0 0 3px black'
                        },
                        formatter: function () {
                            if (q.showResponseCount) {
                                return this.y;
                            }
                            var total = 0;
                            this.series.data.forEach(function (el) {
                                total += el.y;
                            });
                            return Math.round((this.y / total) * 100) + ' %';
                        }
                    }
                }
            },
            series: categories.map(function (cat, idx) {
                return {
                    name: '<%= LanguageUtil.get(locale, "rank") %> ' + (idx + 1),
                    pointWidth: 90,
                    data: categories.map(function (cat) {
                        return 0;
                    }),
                    dataLabels: {
                        enabled: true
                    }
                }
            }),
            exporting: {
                enabled: false
            }
        });

        clearTimeout(poller);

        getRankingData(q);

    }

    function wordcloud(q) {

        function wordCloud(selector) {

            var fill = d3.scale.category20();

            //Construct the word cloud's SVG element
            var svg = d3.select(selector).append("svg")
                    .attr("width", 1200)
                    .attr("height", 800)
                    .append("g")
                    .attr("transform", "translate(500,500)");


            //Draw the word cloud
            function draw(words) {
                var cloud = svg.selectAll("g text")
                        .data(words, function (d) {
                            return d.text;
                        });

                //Entering words
                cloud.enter()
                        .append("text")
                        .style("font-family", "Impact")
                        .style("fill", function (d, i) {
                            return fill(i);
                        })
                        .attr("text-anchor", "middle")
                        .attr('font-size', 1)
                        .text(function (d) {
                            return d.text;
                        });

                //Entering and existing words
                cloud
                        .transition()
                        .duration(600)
                        .style("font-size", function (d) {
                            return d.size + "px";
                        })
                        .attr("transform", function (d) {
                            return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
                        })
                        .style("fill-opacity", 1);

                //Exiting words
                cloud.exit()
                        .transition()
                        .duration(200)
                        .style('fill-opacity', 1e-6)
                        .attr('font-size', 1)
                        .remove();
            }


            //Use the module pattern to encapsulate the visualisation code. We'll
            // expose only the parts that need to be public.
            return {

                //Recompute the word cloud for a new set of words. This method will
                // asycnhronously call draw when the layout has been computed.
                //The outside world will need to call this function, so make it part
                // of the wordCloud return value.
                update: function (words) {
                    d3.layout.cloud().size([500, 500])
                            .words(words)
                            .padding(5)
                            .rotate(function () {
                                return ~~(Math.random() * 2) * 90;
                            })
                            .font("Impact")
                            .fontSize(function (d) {
                                return (Math.min(d.size, 90))
                            })
                            .on("end", draw)
                            .start();
                }
            }

        }

        function getFrequencies(str) {
            var cleanString = str.replace(/[\.,-\/#!$%\^&\*;:{}=\-_`~()]/g, ""),
                    words = cleanString.split(' '),
                    frequencies = {},
                    word, frequency, i;

            for (i = 0; i < words.length; i++) {
                word = words[i];
                if (word.length < 4) {
                    continue;
                }
                frequencies[word] = frequencies[word] || 0;
                frequencies[word]++;
            }

            return frequencies;
        }


//Prepare one of the sample sentences by removing punctuation,
// creating an array of words and computing a random size attribute.
        function getWords(cb) {

            Liferay.Service('/liferay-events-hook.eventpollanswer/get-answers', {
                        questionId: q.questionId
                    },
                    function (jsonResult) {

                        var results = jsonResult;
                        if (!Array.isArray(results)) {
                            return;
                        }

                        $('#countNumber').text(results.length);


                        var freqs = getFrequencies(results.join(' '));

                        var words = Object.keys(freqs);

                        var maxfreq = Math.max.apply(null, (words.map(function (word) {
                            return freqs[word]
                        })));

                        var resArr = words.map(function (word) {
                            return {
                                text: word,
                                size: Math.round(10 + ((freqs[word] / maxfreq) * 80))
                            }
                        });

                        cb && cb(resArr);
                    });

        }

//This method tells the word cloud to redraw with a new set of words.
//In reality the new words would probably come from a server request,
// user input or some other source.
        function showNewWords(vis) {
            getWords(function (words) {
                vis.update(words);
            });
            poller = setTimeout(function () {
                showNewWords(vis)
            }, 3000 + Math.random() * 3000)
        }

//Create a new instance of the word cloud visualisation.
        var myWordCloud = wordCloud('#container');

//Start cycling through the demo data
        showNewWords(myWordCloud);


    }

    function gauge(q) {
        var minmax = JSON.parse(q.choices);
        var categories = [];
        for (i = parseInt(minmax[0]); i <= parseInt(minmax[1]); i++) {
            categories.push("" + i);
        }

        pollChart = new Highcharts.Chart({

            chart: {
                renderTo: 'container1',
                type: 'solidgauge',
                alignTicks: false,
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: true
            },
            credits: {
                enabled: false
            },

            title: {
                text: q.question
            },
            subtitle: {
                text: '<%= LanguageUtil.get(locale, "average-ratings") %>'
            },

            pane: {
                center: ['50%', '85%'],
                size: '140%',
                startAngle: -90,
                endAngle: 90,
                background: {
                    backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
                    innerRadius: '60%',
                    outerRadius: '100%',
                    shape: 'arc'
                }
            },
            plotOptions: {
                solidgauge: {
                    dataLabels: {
                        y: 5,
                        borderWidth: 0,
                        useHTML: true
                    }
                }
            },

            yAxis: {
                min: minmax[0],
                max: minmax[1],
                stops: [
                    [0.1, '#1b75bb'],
                    [0.5, '#005a98'],
                    [0.9, '#1a3a6a']
                ],
                lineWidth: 0,
                minorTickInterval: 12,
                tickPixelInterval: 50,
                tickWidth: 0,
                title: {
                    y: -70
                },
                labels: {
                    y: 16
                }
            },
            tooltip: {
                enabled: false
            },

            series: [
                {
                    name: '<%= LanguageUtil.get(locale, "average") %>',
                    data: [0],
                    dataLabels: {
                        format: '<div style="text-align:center"><span style="font-size:30px;color:' +
                        ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y:.1f}</span><br/>' +
                        '<span style="font-size:12px;color:silver"><%= LanguageUtil.get(locale, "average-ratings") %></span></div>'
                    },

                }],
            exporting: {
                enabled: false
            }
        });

        pollChart2 = new Highcharts.Chart({

            chart: {
                renderTo: 'container2',
                type: 'column'
            },
            exporting: {
                enabled: false
            },
            credits: {
                enabled: false
            },
            title: {
                text: '<%= LanguageUtil.get(locale, "ratings") %>'
            },
            xAxis: {
                categories: categories,
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: q.showResponseCount ? '<%= LanguageUtil.get(locale, "count") %>' : '<%= LanguageUtil.get(locale, "percentage") %>'
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0,
                    pointWidth: 30,
                    dataLabels: {
                        enabled: true,
                        style: {
                            fontSize: '15px',
                            fontWeight: 'bold',
                            color: 'gray'
                        },
                        format: q.showResponseCount ? '{point.y}' : '{point.y:.0f} %'
                    }
                }
            },
            series: [{
                name: '<%= LanguageUtil.get(locale, "ratings") %>',
                data: []

            }]

        });


        clearTimeout(poller);

        getRatingData(q);

    }

    function bar(q) {
        var categories = JSON.parse(q.choices);

        var data = categories.map(function (cat, idx) {
            return {
                y: 0,
                color: colors[idx % colors.length]

            }
        });

        pollChart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'bar' // change this to column if want to show the column chart
            },
            credits: {
                enabled: false
            },
            title: {
                text: q.question,
            },
            subtitle: {
                text: q.eventId
            },
            xAxis: {
                categories: q.anonymousResults ? categories.map(function (choice, idx) {
                    return ('<%= LanguageUtil.get(locale, "choice") %> ' + (idx + 1))
                }) : categories,
            },
            yAxis: {
                title: {
                    text: q.showResponseCount ? '<%= LanguageUtil.get(locale, "count") %>' : '<%= LanguageUtil.get(locale, "percentage") %>'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                enabled: false
            },
            series: [{
                name: 'Responses',
                pointWidth: 50,
                data: data,
                dataLabels: {
                    enabled: true,
                    format: q.showResponseCount ? '{point.y}' : '{point.y:.1f} %'

                }

            }
            ],
            exporting: {
                enabled: false
            }
        });

        clearTimeout(poller);

        getChoiceData(q);

    }

    function pie(q) {
        var categories = JSON.parse(q.choices);

        var data = categories.map(function (cat, idx) {
            return {
                y: 0,
                color: colors[idx % colors.length]

            }
        });

        pollChart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'pie', // change this to column if want to show the column chart,
                minSize: '500'
            },
            credits: {
                enabled: false
            },
            title: {
                text: q.question
            },
            subtitle: {
                text: q.eventId
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.0f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<span style="font-size: 23px;">' + (q.anonymousResults ? '<b><%= LanguageUtil.get(locale, "choice") %></b>: {point.percentage:.0f} %' : '<b>{point.name}</b>: {point.percentage:.0f} %') + '</span>',
                        style: {
                            color: 'black',
                            fontSize: '23px',
                            fontFamily: 'Myriad Pro, Arial, sans-serif'
                        }
                    }
                }
            },

            legend: {
                enabled: false
            },
            series: [{
                name: '<%= LanguageUtil.get(locale, "count") %>',
                data: data,
                dataLabels: {
                    enabled: true,
                    style: {
                        color: 'black',
                        fontSize: '23px',
                        fontFamily: 'Myriad Pro, Arial, sans-serif'
                    }

                }
            }
            ],
            exporting: {
                enabled: false
            }
        });

        clearTimeout(poller);

        getChoiceData(q);

    }

    function getChoiceData(q) {


        var categories = JSON.parse(q.choices);

        Liferay.Service(
                '/liferay-events-hook.eventpollanswer/get-answers',
                {
                    questionId: q.questionId
                },
                function (jsonResult) {

                    var results = jsonResult;//JSON.parse(jsonResult);

                    if (!Array.isArray(results)) {
                        return;
                    }

                    $('#countNumber').text(results.length);
                    var data = categories.map(function (cat, idx) {

                        var count = 0;
                        results.forEach(function (singleResult) {
                            if (singleResult.indexOf(cat) >= 0) {
                                count++;
                            }
                        });
                        return {

                            y: q.showResponseCount ? count : ((count / results.length) * 100.0),
                            name: q.anonymousResults ? ('<%= LanguageUtil.get(locale, "choice") %> ' + (idx + 1)) : cat,
                            color: colors[idx % colors.length]
                        }
                    });
                    pollChart.series[0].setData(data);

                });

        poller = setTimeout(function () {
            getChoiceData(q)
        }, 2000 + (Math.random() * 500));
    }

    function getRatingData(q) {

        var minmax = JSON.parse(q.choices);
        var categories = [];
        for (i = parseInt(minmax[0]); i <= parseInt(minmax[1]); i++) {
            categories.push("" + i);
        }

        Liferay.Service(
                '/liferay-events-hook.eventpollanswer/get-answers',
                {
                    questionId: q.questionId
                },
                function (jsonResult) {

                    var results = jsonResult;//JSON.parse(jsonResult);
                    if (!Array.isArray(results)) {
                        return;
                    }

                    $('#countNumber').text(results.length);

                    var freqdata = [];

                    categories.forEach(function (cat) {
                        freqdata.push(0);
                    });


                    var point = pollChart.series[0].points[0];

                    var total = 0;
                    results.forEach(function (singleResult) {
                        var res = parseInt(singleResult);
                        var offset = parseInt(singleResult) - parseInt(minmax[0]);
                        total += res;
                        freqdata[offset] = freqdata[offset] + 1;
                    });

                    var newavg = total / results.length;

                    point.update(newavg);

                    if (!q.showResponseCount) {
                        freqdata = freqdata.map(function (absval) {
                            return (Math.round((absval / results.length) * 100));
                        });
                    }
                    pollChart2.series[0].setData(freqdata);

                });

        poller = setTimeout(function () {
            getRatingData(q)
        }, 2000 + (Math.random() * 500));
    }

    function getRankingData(q) {

        var categories = JSON.parse(q.choices);

        Liferay.Service(
                '/liferay-events-hook.eventpollanswer/get-answers',
                {
                    questionId: q.questionId
                },
                function (jsonResult) {

                    var results = jsonResult;//JSON.parse(jsonResult);
                    if (!Array.isArray(results)) {
                        return;
                    }

                    $('#countNumber').text(results.length);
                    // ranks arr:
//                        [
//                          [
//                              5, 6, 4, 3 -- all first place scores for mobile,analytics, etc
//                          ],
//                          [
//                              2, 4, 1, 2 -- all second place scores for mobile, analytics, etc
//                          ]
//                        ]
                    var ranksArr = []; // size should be equal to total # of ranks (size of cats)
                    var totalsArr = []; // size should be equal to total # of cats

                    categories.forEach(function (cat, idx) {
                        ranksArr.push(categories.map(function (cat) {
                            return 0;
                        }));
                        totalsArr[idx] = 0;
                    });

                    function findRankOffset(cat) {
                        for (var i = 0; i < categories.length; i++) {
                            if (cat == categories[i]) return i;
                        }
                        return -1;
                    }

                    function getWeight(rankidx) {
                        return Math.pow((categories.length - rankidx), 2);
                    }

                    results.forEach(function (singleResultArr, respidx) {
                        JSON.parse(singleResultArr).forEach(function (resultCat, place) {
                            var catidx = findRankOffset(resultCat);
                            var weightedScore = getWeight(place);
                            ranksArr[place][catidx] += weightedScore;
                            totalsArr[place] += weightedScore;
                        });
                    });

                    ranksArr.forEach(function (rankArr, idx) {
                        pollChart.series[idx].setData(rankArr);
                    });


                });

        poller = setTimeout(function () {
            getRankingData(q)
        }, 2000 + (Math.random() * 500));
    }

    //If parent option is changed
    $("#parent_selection").change(function () {
        $("#container").html('');
        $("#container1").html('');
        $("#container2").html('');
        $("#countNumber").text('--');
        clearTimeout(poller);
        clearInterval(questionPoller);
        $('#shorturlContainer').css('display', 'none');
        var selectedEventId = $(this).val(); //get option value from parent
        // parent is like lpsf-de-2015 - the eventId
        $("#child_selection").html('');
        populateQuestions(selectedEventId);
        questionPoller = setInterval(function () {
            populateQuestions(selectedEventId);
        }, 5000);

    });

    $("#child_selection").change(function () {

        setTheme();
        clearTimeout(poller);
        var selectedQuestionId = $(this).val(); //get option value from parent
        showResults(selectedQuestionId);

    });

    function setTheme() {
        Highcharts.theme = {
             // colors: ['#4ABF74', '#e0c73f', '#fb2249'], // red/green/blue
            colors: ['#00B8B9', '#F5A11D', '#1B75BB', '#1a3a6a', '#909295', '#64E572',
                '#474a4b', '#124680', '#005a98'],
            chart: {},
            title: {
                style: {
                    color: '#000',
                    font: 'bold 30px Myriad Pro, Arial, sans-serif'
                }
            },
            subtitle: {
                style: {
                    color: '#666666',
                    font: 'bold 23px Myriad Pro, Arial, sans-serif'
                }
            },

            legend: {
                itemStyle: {
                    font: '14px Myriad Pro, Arial, sans-serif',
                    color: 'black'
                },
                itemHoverStyle: {
                    color: 'gray'
                }
            },
            xAxis: {
                labels: {
                    style: {
                        color: 'black',
                        font: 'bold 20px Myriad Pro, Arial, sans-serif'
                    }
                },
                title: {
                    style: {
                        color: 'black',
                        font: 'bold 20px Myriad Pro, Arial, sans-serif'
                    }
                }
            },
            yAxis: {
                labels: {
                    style: {
                        color: 'black',
                        font: 'bold 14px Myriad Pro, Arial, sans-serif'
                    }
                },
                title: {
                    style: {
                        color: 'black',
                        font: 'bold 20px Myriad Pro, Arial, sans-serif'
                    }
                }

            },
            plotOptions: {
                series: {
                    dataLabels: {
                        style: {
                            color: 'black',
                            font: 'bold 23px Myriad Pro, Arial, sans-serif'
                        }
                    }
                },
                pie: {
                    dataLabels: {
                        style : {
                            color: 'black',
                            font: 'bold 23px Myriad Pro, Arial, sans-serif'
                        }
                    }
                }
            }
        };

        // Apply the theme
        Highcharts.setOptions(Highcharts.theme);
        colors = Highcharts.getOptions().colors;

    }

    $(document).ready(function () {

    });

</script>

