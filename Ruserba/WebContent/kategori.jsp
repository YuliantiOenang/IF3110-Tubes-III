<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<title>Kategori</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<form action="kategori_result.jsp" method="post">
	
	Nama kategori : <input type="text" name="namakategori" />
	<input type="submit" />

	<jsp:include page="footer.jsp"/>
</form>
</body>
</html>