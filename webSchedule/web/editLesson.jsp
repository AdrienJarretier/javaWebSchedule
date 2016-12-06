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
            Time start : <input name='time_start' type='text'
                                value='<fmt:formatDate value="${lesson.getTimeStart()}" pattern="YYYY-MM-dd HH:mm:ss" />'      
                                >
            <br>
            Time end : <input name='time_end' type='text' value='<fmt:formatDate value="${lesson.getTimeEnd()}" pattern="YYYY-MM-dd HH:mm:ss" />'><br>

            Title : <input name='title' type='text' value='${lesson.getTitle()}'><br>

            Class room : <select name = 'room' type='text' value='${lesson.getClass_room()}'>
                <c:forEach var="rooms" items="${rooms}">
                    <option value='${rooms.getId()}'> ${rooms.getBuilding()} ${rooms.getRoom_number()} ( ${rooms.getCapacity()} seats) </option> 
                </c:forEach>

            </select>

            <c:if test="${sessionScope.userEntity.getIsAdmin()}">
                Teacher : <select name = 'teacher' type='text' value='${lesson.getTeacher()}'>
                    <c:forEach var="teacher" items="${teacherNames}">
                        <option value='${teacher.getId()}'> ${teacher.getLastName()} ${teacher.getFirstName()} </option> 
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


            <input type='submit' name='action' value='Edit'>
        </form>

        <form action='StaffController'>
            <input type='submit' value='cancel'>
        </form>

    </body>
</html>
