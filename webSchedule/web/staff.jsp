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
        <link rel="stylesheet" type="text/css" href="style.css" >

        <title>Lessons</title>
    </head>
    <body>
        <c:import url="nav.jsp" />
        
        
        <h1>Welcome Mr. ${sessionScope.userEntity.getLastName()}</h1>
        
        <c:choose>
            <c:when test="${sessionScope.userEntity.getIsAdmin()}" >
                Here are all lessons : <br>
            </c:when>

            <c:otherwise>
                Here are your lessons : <br>
            </c:otherwise>
        </c:choose>
        

        <c:choose>

            <c:when test="${empty lessons}">
                No lessons to display
                
                <br>
                <td><a href="ButtonAddController">Add Lesson</a></td>
                <br>
                
            </c:when>
                
            <c:otherwise> 

                <table border="1">
                    <tr>
                        <th>Time_start</th>
                        <th>Time_end</th>
                        <th>Title</th>
                        <th>Class_room</th>
                        <th>Attending</th>
                        <c:if test="${sessionScope.userEntity.getIsAdmin()}" > 
                            <th>Teacher</th>
                        </c:if>
                        <th>Edit lesson</th>
                        <th>Remove lesson</th>
                    </tr>

                    <c:forEach var="lesson" items="${lessons}">

                        <tr>
                            <td>${lesson.getTimeStart()}</td>
                            <td>${lesson.getTimeEnd()}</td>
                            <td>${lesson.getTitle()}</td>
                            <td>${lesson.getClass_room().getBuilding()} ${lesson.getClass_room().getRoom_number()}</td>
                            
                            <td>
                            <c:forEach var="degree" items="${lesson.getParticipants()}">
                                ${degree.getName()}
                            </c:forEach>
                                </td>
                            
                            <c:if test="${sessionScope.userEntity.getIsAdmin()}" > 
                                <td>${lesson.getTeacher().getLastName()}</td>
                            </c:if>
                           <td><a href="ButtonEditController?id=${lesson.getId()}">Edit</a></td>
                           <td><a href="removeLesson.jsp?id=${lesson.getId()}">Remove</a></td>
                        </tr>
                        
                    </c:forEach>
                    
                </table>
                <br>
                <td><a href="ButtonAddController">Add Lesson</a></td>
                <br>
            </c:otherwise>
                
        </c:choose>
         <form action='Logout'>
            <input type='submit' value='Logout'>
        </form>       
    </body>
</html>
