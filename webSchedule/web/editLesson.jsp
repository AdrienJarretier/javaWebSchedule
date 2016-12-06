<%-- 
    Document   : editLesson
    Created on : 3 déc. 2016, 20:15:52
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" >

        <title>Edit lesson</title>
    </head>
    <body>
        <c:import url="nav.jsp" />
        <h1> Welcome ! </h1>
        Edit lesson : <br>
        <div style="color:red">${errorMessage}</div>


        <form method="POST" action='EditLessonController'> 
            <input name='id' type='hidden' value='${lesson.getId()}'><br>
            Start : <input id='date_timepicker_start' name='time_start' type='text'
                           value='<fmt:formatDate value="${lesson.getTimeStart()}" pattern="YYYY-MM-dd HH:mm:ss" />'      
                           >
            <br>
            End : <input id='date_timepicker_end' name='time_end' type='text' value='<fmt:formatDate value="${lesson.getTimeEnd()}" pattern="YYYY-MM-dd HH:mm:ss" />'><br>

            Title : <input name='title' type='text' value='${lesson.getTitle()}'><br>

            Class room : <select name = 'room' type='text' >
                <c:forEach var="room" items="${rooms}" >
                    <option value='${room.getId()}' ${ (lesson.getClass_room().getId() == room.getId() ? "selected" : "") }> ${room.getBuilding()} ${room.getRoom_number()} ( ${room.getCapacity()} seats) </option> 
                </c:forEach>

            </select>

            <c:if test="${sessionScope.userEntity.getIsAdmin()}">
                Teacher : <select name = 'teacher' type='text' value='${lesson.getTeacher()}'>
                    <c:forEach var="teacher" items="${teacherNames}">
                        <option value='${teacher.getId()}' ${ (lesson.getTeacher().getId() == teacher.getId() ? "selected" : "") }> ${teacher.getLastName()} ${teacher.getFirstName()} </option> 
                    </c:forEach>

                </select>
            </c:if>

            <br>
            <fieldset>
                <legend>Degree</legend>

                <c:forEach var="degree" items="${degrees}">
                    <input type='checkbox' name = 'degree' value='${degree.getId()}' ${ (lesson.getParticipants().contains(degree) ? "checked" : "") }> 
                    ${degree.getName()} (${degree.getStudent_count()} students) <br>
                    </input>
                </c:forEach>
            </fieldset>


            <input type='submit' name='action' value='Edit'>
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
