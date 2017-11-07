<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form:form action="loginPage.obj" modelAttribute="login">
<table>
<tr><td>Enter username: </td>
<td><form:input path="loginId"/>
<form:errors path="loginId"/>
</td>
</tr>

<tr><td>Enter password: </td>
<td><form:input path="password"/>
<form:errors path="password"/>
</td>
</tr>

<tr><td>Enter role: </td>
<td><form:input path="role"/>
<form:errors path="role"/>
</td>
</tr>

<tr><td><input type="submit" value="Submit"/>
</table>
</form:form>
</body>
</html>