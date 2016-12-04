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
  
                <form method="POST"> 
			Time start : <input name='time_start'><br>
			Time end : <input name='time_end'><br>
                        Title : <input name='title'><br>
                        Class room : <input name='class_room'><br>
                        Teacher : <input name='teacher'><br>
			<input type='submit' name='action' value='Add'>
		</form>
		
        
        
        
    </body>
</html>
