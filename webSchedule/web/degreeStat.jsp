<%-- 
    Document   : degreeStat
    Created on : 6 déc. 2016, 19:00:08
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="style.css" >

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">

            google.charts.load("current", {packages: ["corechart"]});
            


            function draw(result) {
                console.log("success : ");
                console.log(result);

                var tab = [];
                tab.push(['Degree', 'count']);

                

                for (var i = 0; i < result.length; ++i) {

                    var degree = result[i];
                    console.log("degree :");
                    console.log(degree);
                    tab.push(
                            [
                                degree.name,
                                degree.student_count
                            ]);
                }


                var data = google.visualization.arrayToDataTable(
                        tab
                        );


                var options = {
                    pieHole: 0.4,
                };

                var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                chart.draw(data, options);
            }

            function showError(xhr, status, message) {

                console.log("error");

            }

            function drawChartCount() {

                $.ajax({
                    data: {
                        "param" : "count" 
                    },
                    url: "AjaxDegreeDataServlet",
                    dataType: "json",
                    success: draw,
                    error: showError
                });
            }
            
            function drawChartHour() {

                $.ajax({
                    data: {
                        "param" : "hour" 
                    },
                    url: "AjaxDegreeDataServlet",
                    dataType: "json",
                    success: draw,
                    error: showError
                });
            }

            $(document).ready(// executed when page is done loading

                    function () {

                        $("#buttonCount").click(drawChartCount);
                        $("#buttonHour").click(drawChartHour);
                        
                    }

            );
        </script>

        <title>Degree stat</title>
    </head>
    <body>
    <c:import url="nav.jsp" />
    
    <div id="donutchart" style="width: 900px; height: 500px;"></div>
    
     <button id="buttonCount" type="button">Student count per degree</button> 
     <button id="buttonHour" type="button">Hour per degree</button> 
</body>
</html>
