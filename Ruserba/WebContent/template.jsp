<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>

</head>
<body>
	<jsp:include page="header.jsp"/>

	
	<h1>${param.title}</h1>

	<!--><jsp:include page="${param.content}.jsp"/><-->
	
	<jsp:include page="footer.jsp"/>
	
	
</body>
</html>