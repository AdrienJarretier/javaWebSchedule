<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- 
    Document   : staff
    Created on : 3 déc. 2016, 20:24:53
    Author     : Laurie
--%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All lessons</title>
    </head>
    <body>
        <c:import url="nav.jsp" />
        <h1>Welcome Mr. ${sessionScope.userEntity.getLastName()}</h1>
        Here are all lessons : 

        <c:choose>

            <c:when test="${empty lessons}">
                No lessons to display			
            </c:when>
                
            <c:otherwise> 

                <table border="1">
                    <tr><th>Id</th><th>Time_start</th><th>Time_end</th><th>Title</th><th>Class_room</th><th>Teacher</th></tr>

                    <c:forEach var="lesson" items="${lessons}">

                        <tr><td>${lesson.getId()}</td><td>${lesson.getTimeStart()}</td><td>${lesson.getTimeEnd()}</td><td>${lesson.getTitle()}</td><td>${lesson.getClass_room_id()}</td><td>${lesson.getTeacher_id()}</td></tr>
                        
                    </c:forEach>

                    <!--                        <form method="POST"> 
                                                <input type='submit' name='action' value='Logout'>
                                                <input type='submit' name='action' value='Add lesson'>
                                            </form>-->

                </table>
                
            </c:otherwise>
                
        </c:choose>
                
    </body>
</html>
