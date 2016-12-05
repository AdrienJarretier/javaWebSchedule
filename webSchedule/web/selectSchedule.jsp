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
        <title>select a schedule</title>

        <!--Load the ajax api and the google charts api-->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">

            // load the Visualization API and the timeline package
            google.charts.load('current', {packages: ['timeline']});

            // set a callback to run when the google vis api is loaded
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var jsonDATA = $.ajax({
                    data: {"teacherId":$( "select option:selected" ).val()},
                    url: "AjaxScheduleDatasServlet",
                    dataType: "json"
                }).responseText;
                
                // Create our data table out of JSON data loaded from server.
                var data = new google.visualization.DataTable(jsonDATA);
                
                // instanciate and draw the chart
                var container = document.getElementById('timeline');
                var chart = new google.visualization.Timeline(container);
                chart.draw(data);
                
//                var container = document.getElementById('timeline');
//                var chart = new google.visualization.Timeline(container);
//                var dataTable = new google.visualization.DataTable();
//
//                dataTable.addColumn({type: 'string', id: 'President'});
//                dataTable.addColumn({type: 'date', id: 'Start'});
//                dataTable.addColumn({type: 'date', id: 'End'});
//                dataTable.addRows([
//                    ['Washington', new Date(1789, 3, 30), new Date(1797, 2, 4)],
//                    ['Adams', new Date(1797, 2, 4), new Date(1801, 2, 4)],
//                    ['Jefferson', new Date(1801, 2, 4), new Date(1809, 2, 4)]]);
//
//                chart.draw(dataTable);
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

        <div id="timeline" style="height: 180px;"></div>

    </body>
</html>
