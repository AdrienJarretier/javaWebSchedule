<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- 
    Document   : staff
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
        <title>All lessons</title>
    </head>
    <body>
        <h1>Welcome Mr. ${sessionScope.userEntity.getLastName()}</h1>
        Here are all lessons : 
        
        <c:choose>
            <%-- Si la liste est vide --%>
            <c:when test="${empty customers}">
                <%-- On pourrait aussi écrire ${customers.isEmpty()} (cf. java.util.List) --%>
                State ${param.state} has no customers.			
            </c:when>
            <c:otherwise> <%-- La liste n'est pas vide %-_>
		<%-- Pour chaque client dans la liste --%>
        
            <c:forEach var="lesson" varStatus="status" items="${lessons}">
                <c:if test="${status.first}">
                    <table border="1">
                        <tr><th>Id</th><th>Time_start</th><th>Time_end</th><th>Title</th><th>Class_room</th><th>Teacher</th></tr>
                </c:if>
                <%-- On met une ligne dans la table --%>
		<%-- Les noms de propriétés correspondent aux "propriétés" java exportées par CustomerEntity (ex: getName() ) --%>
                <tr><td>${lesson.getId()}</td><td>${lesson.getTime_start}</td><td>${lesson.time_end}</td><td>${lesson.title}</td><td>${lesson.class_room_id}</td><td>${lesson.teacher_id}</td></tr>
            </c:forEach>
                
            
        </table>
        <form method="POST"> <!-- l'action par défaut est l'URL courant, qui va rappeler la servlet -->
            <input type='submit' name='action' value='Logout'>
            <input type='submit' name='action' value='Add lesson'>
        </form>
	
        <c:import url="nav.jsp" />
    </body>
</html>
