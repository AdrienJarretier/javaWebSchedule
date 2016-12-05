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
        <title>Add lesson</title>
    </head>
    <body>
        <h1> Welcome ! </h1>
        Please enter the lesson : <br>

        <form method="POST" action='AddLessonController'> 
            Dates must be of this type : year-month-day h:min:s <br>
            Time start : <input name='time_start' type='text'><br>
            Time end : <input name='time_end' type='text' ><br>
            Title : <input name='title' type='text' ><br>

            Class room : <select name = 'room' type='text' value='${lesson.getClass_room()}'>
                <c:forEach var="rooms" items="${rooms}">
                    <option value='${rooms.getId()}'> 
                        ${rooms.getBuilding()} ${rooms.getRoom_number()} ( ${rooms.getCapacity()} places) 
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
</html>
