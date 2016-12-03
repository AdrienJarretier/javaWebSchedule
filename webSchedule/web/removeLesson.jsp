<%-- 
    Document   : removeLesson
    Created on : 3 déc. 2016, 20:15:52
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove lesson</title>
    </head>
    <body>
        <h1> Welcome ! </h1>
        Remove lesson with Id : <br>
        
         <div style="color:red">${errorMessage}</div>
                <form method="POST"> <!-- l'action par défaut est l'URL courant, qui va rappeler la servlet -->
			Lesson id : <input name='lesson_id'><br>
			<input type='submit' name='action' value='Remove'>
		</form>
         <br>       
        Remove lesson with Time start and class room : <br>
        
        <div style="color:red">${errorMessage}</div>
                <form method="POST"> <!-- l'action par défaut est l'URL courant, qui va rappeler la servlet -->
			Time start : <input name='time_start'><br>
                        Class room : <input name='class_room'><br>
			<input type='submit' name='action' value='Remove'>
		</form>
        <br>
        Remove lesson with Time start and teacher : <br>
        
        <div style="color:red">${errorMessage}</div>
                <form method="POST"> <!-- l'action par défaut est l'URL courant, qui va rappeler la servlet -->
			Time start : <input name='time_start'><br>
                        Teacher : <input name='teacher'><br>
			<input type='submit' name='action' value='Remove'>
		</form>
        
        
    </body>
</html>
