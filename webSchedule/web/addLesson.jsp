<%-- 
    Document   : addLesson
    Created on : 3 déc. 2016, 20:15:52
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" >

        <title>Add lesson</title>
    </head>
    <body>
        <c:import url="nav.jsp" />
        <h1> Welcome ! </h1>
        Please enter the lesson : <br>

        <form method="POST" action='AddLessonController'> 
            Dates must be of this type : year-month-day h:min:s <br>
            Start : <input id='date_timepicker_start' name='time_start' type='text'><br>
            End : <input id='date_timepicker_end' name='time_end' type='text' ><br>
            Title : <input name='title' type='text' ><br>

            Class room : <select name = 'room' type='text' value='${lesson.getClass_room()}'>
                <c:forEach var="rooms" items="${rooms}">
                    <option value='${rooms.getId()}'> 
                        ${rooms.getBuilding()} ${rooms.getRoom_number()} ( ${rooms.getCapacity()} seats) 
                    </option> 
                </c:forEach>
            </select>


            <c:if test="${sessionScope.userEntity.getIsAdmin()}">
                Teacher : <select name = 'teacher' type='text' value='${lesson.getTeacher()}'>
                    <c:forEach var="teacher" items="${teacherNames}">
                        <option value='${teacher.getId()}'> 
                            ${teacher.getLastName()} ${teacher.getFirstName()} 
                        </option> 
                    </c:forEach>
                </select>
            </c:if>  

            <br>
            <fieldset>
                <legend>Degree</legend>

                <c:forEach var="degrees" items="${degrees}">
                    <input type='checkbox' name = 'degree' value='${degrees.getId()}'> 
                    ${degrees.getName()} (${degrees.getStudent_count()} students) <br>
                    </input>
                </c:forEach>
            </fieldset>


            <input type='submit' value='add'>
        </form>

        <form action='StaffController'>
            <input type='submit' value='cancel'>
        </form>

    </body>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="dtp/jquery.datetimepicker.css">
    <script src="dtp/jquery.datetimepicker.full.min.js"></script>

    <script type="text/javascript">

        const THEME = 'dark';

        var ALLOWED_TIMES = [];

        for (var i = 7; i <= 19; ++i) {
            ALLOWED_TIMES.push(i + ':00');
            for (var j = 15; j < 60; j += 15) {
                ALLOWED_TIMES.push(i + ':' + j);
            }
        }

        jQuery(function () {
            jQuery('#date_timepicker_start').datetimepicker({
                format: 'Y-m-d H:i',
                onShow: function (ct) {
                    this.setOptions({
                        maxDate: jQuery('#date_timepicker_end').val() ? jQuery('#date_timepicker_end').val() : false
                    })
                },
                minDate: 0,
                allowTimes: ALLOWED_TIMES,
                theme: THEME
            });
            jQuery('#date_timepicker_end').datetimepicker({
                format: 'Y-m-d H:i',
                onShow: function (ct) {
                    this.setOptions({
                        minDate: jQuery('#date_timepicker_start').val() ? jQuery('#date_timepicker_start').val() : 0
                    })
                },
                allowTimes: ALLOWED_TIMES,
                theme: THEME
            });
        });
    </script>
</html>
