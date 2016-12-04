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

        <div style="color:red">${errorMessage}</div>
        <form method="POST"> 
            Time start : <input name='time_start' type='text' value='ok'><br>
            Time end : <input name='time_end'><br>
            Title : <input name='title'><br>
            Class room : <select name = 'room'>
                <option value='id'> texte </option>
            </select>
            <c:if test="${sessionScope.userEntity.getIsAdmin()}">
                Teacher : <select name = 'teacher'>
                <c:forEach var="teacherName" items="${teacherNames}">
                     <option value='teacherName'> ${teacherNames.get} </option> 
                </c:forEach>
                  
                </select>
            </c:if>
            <input type='submit' name='action' value='Edit'>
        </form>



    </body>
</html>
