<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
   <%@ page import="javafiles.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin: List Barang</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	List Barang | 
	<a href="admintambah.jsp">Tambah Barang | </a>
	<a href="adminhapus.jsp">Hapus Barang | </a>
	<a href="adminubah.jsp">Ubah Barang | </a>
	
	<table>
			<tr>
			<th>Nama</th>
			<th>Harga</th>
			<th>Stok</th>
			<th>Kategori</th>
			<th>img_dir</th>
			</tr> 
			<%

			  List list = javafiles.BarangManager.lihatDaftar();
			  int id = 0;
			
			  Iterator<String> it = list.iterator();
			
			  while (it.hasNext()) {
			      id = Integer.parseInt(it.next());
			      out.print("<tr>");
			      for (int i = 0; i < 5; i++) {
			          out.print("<td>");
			          out.print(it.next());
			          out.print("</td>");
			  }
			  out.print("<td>");
			  out.print("</td>");
			  out.print("</tr>");
			 }
			%>
		</table>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>