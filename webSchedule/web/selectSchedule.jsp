<%-- 
    Document   : selectSchedule
    Created on : Dec 5, 2016, 1:13:49 AM
    Author     : Jarretier Adrien "jarretier.adrien@gmail.com"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css" >

        <title>select a schedule</title>

        <!--Load the ajax api and the google charts api-->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">

            // load the Visualization API and the timeline package
            google.charts.load('current', {packages: ['timeline']});

            // set a callback to run when the google vis api is loaded
//            google.charts.setOnLoadCallback(drawChart);

            function draw(result) {

                console.log("success : ");
                console.log(result);

                // instanciate and draw the chart
                var container = document.getElementById('timeline');
                var chart = new google.visualization.Timeline(container);

                var dataTable = new google.visualization.DataTable();

                dataTable.addColumn({type: 'string', id: 'class_room'});
                dataTable.addColumn({type: 'string', id: 'title'});
//                dataTable.addColumn({type: 'string', role: 'tooltip', 'p': {'html': true}});
                dataTable.addColumn({type: 'date', id: 'start'});
                dataTable.addColumn({type: 'date', id: 'end'});

                for (var i = 0; i < result.length; ++i) {

                    var lesson = result[i];
                    console.log("lesson :");
                    console.log(lesson);
                    var cr = lesson.class_room;
                    dataTable.addRow(
                            [
                                cr.building + ' ' + cr.room_number,
                                lesson.title,
//                                '<strong>' + lesson.title + '</strong><hr>\n\
//                                <strong>' + cr.building + ' ' + cr.room_number + '</strong> : ',
                                new Date(lesson.timeStart),
                                new Date(lesson.timeEnd)
                            ]);
                }

//                var options = {
//                    tooltip: {isHtml: true},
//                };

                chart.draw(dataTable
//                , options
                        );
            }

            function showError(xhr, status, message) {

                console.log("error");

            }

            function drawChart() {

                $.ajax({
                    data: {
                        "name": $("select").attr("name"),
                        "teacherId": $("select option:selected").val()
                    },
                    url: "AjaxScheduleDatasServlet",
                    dataType: "json",
                    success: draw,
                    error: showError
                });
            }

            $(document).ready(// executed when page is done loading

                    function () {

                        $("#timelineSelect").change(drawChart);
                    }

            );

        </script>
    </head>
    <body>
        <c:import url="nav.jsp" />

        <h1>
            <c:choose>

                <c:when test="${!empty teachers}" >
                    Teachers
                </c:when>

                <c:when test="${!empty degrees}" >
                    Degrees
                </c:when>

            </c:choose>
            Schedules
        </h1>

        <form action="SelectSchedule" method="post">

            <c:choose>

                <c:when test="${!empty teachers}" >      
                    <select id="timelineSelect" name="teacher">

                        <option disabled selected> Teachers </option>

                        <c:forEach var="teacher" items="${teachers}">
                            <option value='${teacher.getId()}'> ${teacher.getLastName()} ${teacher.getFirstName()} </option> 
                        </c:forEach>


                    </select>
                </c:when>

                <c:when test="${!empty degrees}" >
                    <select id="timelineSelect" name="degree">

                        <option disabled selected> Degrees </option>

                        <c:forEach var="degree" items="${degrees}">
                            <option value='${degree.getId()}'> ${degree.getName()} </option> 
                        </c:forEach>


                    </select>
                </c:when>

            </c:choose>
            <br>
            <br>
            <!--<input type="submit" value="display">-->

        </form>

        <div id="timeline" style="height: 512px"></div>

    </body>
</html>
