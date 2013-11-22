<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/ruserba.css" />
<title>RuserBa</title>
</head>
<body>
<% 
HttpSession sesi = request.getSession(false);
if((sesi== null)|| (sesi.getAttribute("loggedInUser")==null)) {
%>
Sign Up<br>
Login<br>
<%
}
else{
%>
Register Credit Card<br>
Shopping Bag<br>
Profile<br>
<%
}
%>
Register Credit Card<br>
Shopping Bag<br>
Profile<br>