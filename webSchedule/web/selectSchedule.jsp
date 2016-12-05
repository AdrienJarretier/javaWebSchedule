<%-- 
    Document   : selectSchedule
    Created on : Dec 5, 2016, 1:13:49 AM
    Author     : Jarretier Adrien "jarretier.adrien@gmail.com"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>select a schedule</title>
    </head>
    <body>
        <c:import url="nav.jsp" />

        <h1>
            <c:choose>

                <c:when test="${!empty teachers}" >
                    Teachers
                </c:when>

                <c:when test="${!empty degrees}" >
                    Degrees
                </c:when>

            </c:choose>
            Schedules
        </h1>

        <form action="SelectSchedule" method="post">

            <c:choose>

                <c:when test="${!empty teachers}" >      
                    <select id="teacher" name="teacher">

                        <c:forEach var="teacher" items="${teachers}">
                            <option value='${teacher.getId()}'> ${teacher.getLastName()} ${teacher.getFirstName()} </option> 
                        </c:forEach>


                    </select>
                </c:when>

                <c:when test="${!empty degrees}" >
                    <select id="degree" name="degree">

                        <c:forEach var="degree" items="${degrees}">
                            <option value='${degree.getId()}'> ${degree.getName()} </option> 
                        </c:forEach>


                    </select>
                </c:when>

            </c:choose>
            <br>
            <br>
            <input type="submit" value="display">

        </form>
    </body>
</html>
