<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<%
		if (request.getParameter("result") != null) {
			if (request.getParameter("result").equals("success")) {
	%>
	<script>
		alert("tambah barang sukses!");
	</script>
	<%
		} else {
	%>
	<script>
		alert("tambah barang tidak sukses!");
	</script>
	<%
		}
		}
	%>

	<jsp:include page="layout.jsp"></jsp:include>
	<h1 class="header">Admin</h1>
	<hr/>
	<br/>
	<a href="admin?action=add" class="btn small">Tambah barang</a>
	<a href="admin?action=edit" class="btn small">Edit barang</a>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>