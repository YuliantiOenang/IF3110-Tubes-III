<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h1 class="header">Upload Photo</h1>
	<form method="post" action="admin" enctype="multipart/form-data">
		<input type="hidden" name="action" value="pic" />
		<input type="hidden" name="id" value="<%= request.getAttribute("id")%>" />
		<input type="file" name="photo" />
		<button type="submit" id="btn" onclick="" class="btn">Upload</button>
	</form>
</body>
</html>