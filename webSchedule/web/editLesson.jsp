<%-- 
    Document   : editLesson
    Created on : 3 déc. 2016, 20:15:52
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit lesson</title>
    </head>
    <body>
        <h1> Welcome ! </h1>
        Edit lesson : <br>

        <form method="POST"> 
            Time start : <input name='time_start' type='text' value=${lesson.getTimeStart()}><br>
            Time end : <input name='time_end' type='text' value=${lesson.getTimeEnd()}><br>
            Title : <input name='title' type='text' value=${lesson.getTitle()}><br>
            Class room : <select name = 'room' type='text' value=${lesson.getClass_room()}>
                <c:forEach var="rooms" items="${rooms}">
                    <option value='${rooms.getId()}'> ${rooms.getBuilding()} ${rooms.getRoom_number()} ( ${teacherNames.getCapacity()} places) </option> 
                </c:forEach>

            </select>

            <c:if test="${sessionScope.userEntity.getIsAdmin()}">
                Teacher : <select name = 'teacher' type='' value=${lesson.getTeacher()}>
                    <c:forEach var="teacherName" items="${teacherNames}">
                        <option value='${teacher.getId()}'> ${teacherNames.getLastName()} ${teacherNames.getFirstName()} </option> 
                    </c:forEach>

                </select>
            </c:if>
            <input type='submit' name='action' value='Edit'>
        </form>



    </body>
</html>
