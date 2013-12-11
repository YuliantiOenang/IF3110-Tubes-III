<%@ page import="com.ruserba.model.Database" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<html>
<head>
	<title>Hello World!</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		if (msg == null) msg = "No message.";
	%>
	<p><%= msg %></p>
	<%
		Database db = (Database)pageContext.getServletContext().getAttribute("db");
		//System.out.println(db);
		request.setAttribute("product", db.getProductData(3));
	%>
	<jsp:useBean id="product" class="com.ruserba.model.Product" scope="request" />
	<p><jsp:getProperty name="product" property="namaBarang" /></p>
</body>
</html>
