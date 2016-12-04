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
        <title>Remove lesson</title>
    </head>
    <body>
        <h1> Are you sure you want to delete this lesson ? </h1>

        <form>
            <input type='submit' name='action' formmethod = 'RemovedLessonController' value='remove'>
            <input type='submit' name='action' formmethod ='staff.jsp' value='cancel'>
        </form>

    </body>
</html>
