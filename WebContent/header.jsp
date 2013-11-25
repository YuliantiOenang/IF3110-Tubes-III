<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="javascript/text" src="verify.js"></script>
<%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/ruserba.css" /> --%>
<title>RuserBa</title>
</head>
<body>
<% 
HttpSession sesi = request.getSession(true);
if((sesi== null)|| (sesi.getAttribute("username")==null)) {
%>
<a href="register.jsp">Sign Up</a><br>
Login<br>
<%
}
else{
%>
<a href="logout.jsp">Log Out</a><br>
Shopping Bag<br>
<a href="profile.jsp">Profile</a><br>
Register Credit Card<br>
<%
}
%>