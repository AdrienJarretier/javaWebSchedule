<%-- 
    Document   : removeLesson
    Created on : 3 déc. 2016, 20:15:52
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" >

        <title>Remove lesson</title>
    </head>
    <body>
        <c:import url="nav.jsp" />
        <h1> Are you sure you want to delete this lesson ${param.id} ? </h1>
        
        <div style="color:red">${errorMessage}</div>
        
        <form action='RemoveLessonController' method='POST'>
            <input type ='hidden' value ='${param.id}' name='id'>
            <input type='submit' value='remove'>
        </form>

        <form action='StaffController'>
            <input type='submit' value='cancel'>
        </form>

    </body>
</html>
