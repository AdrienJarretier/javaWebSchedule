<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- 
    Document   : teacher
    Created on : 3 déc. 2016, 20:24:53
    Author     : Laurie
--%>


<%--
    La servlet fait : session.setAttribute("customer", customer)
    La JSP récupère cette valeur dans ${customer}
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher's lessons</title>
    </head>
    <body>
        <h1>Welcome Mr. ${teacher.name}</h1>
        Here are your lessons : 
        <table border="1">
            <tr><th>Id</th><th>Time_start</th><th>Time_end</th><th>Title</th><th>Class_room</th></tr>
            <c:forEach var="lesson" items="${lessons}">
                <tr><td>${lesson.id}</td><td>${lesson.time_start}</td><td>${lesson.time_end}</td><td>${lesson.title}</td><td>${lesson.class_room_id}</td></tr>
            </c:forEach>		
        </table>
        <form method="POST"> <!-- l'action par défaut est l'URL courant, qui va rappeler la servlet -->
            <input type='submit' name='action' value='Logout'>
            <input type='submit' name='action' value='Add lesson'>
        </form>
	
    </body>
</html>
