<%-- 
    Document   : login
    Created on : 3 déc. 2016, 20:15:52
    Author     : Laurie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Please login</title>
    </head>
    <body>
        <c:import url="nav.jsp" />
        <h1> Welcome ! </h1>
        Please enter your email and password <br>
        
        <div style="color:red">${errorMessage}</div>
                <form method="POST" action='LoginController'>
                    login (email) : <input name='login' type='email'><br>
			password : <input name='password' type='password'><br>
			<input type='submit' name='action' value='login'>
		</form>
                
    </body>
</html>
