<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.swing.JFrame" %>
    <%@ page import="javax.swing.JOptionPane" %>
    <%@ page import="javafiles.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin: Tambah Barang</title>
</head>
<body>



	<%
	  String nama = request.getParameter("nama");
	  String harga = request.getParameter("harga");
	  String stok = request.getParameter("stok");
	  String kategori = request.getParameter("kategori");
	  String img_dir = "assets/img/" + request.getParameter("img_dir");
	  String deskripsi = request.getParameter("deskripsi");
	  
	  if (nama != null && harga != null 
	          && stok != null && kategori != null && img_dir != null) {
		  
	      javafiles.BarangManager.Tambah(nama, harga, stok, kategori, img_dir, deskripsi);
	      %>
	      <script>
	          alert("Data berhasil ditambah");
	  	  </script>
	  	  <%
	  }

	%>

	<jsp:include page="header.jsp"/>
	
	<a href="adminlistbarang.jsp">List Barang | </a>
	Tambah Barang | 
	<a href="adminhapus.jsp">Hapus Barang | </a>
	<a href="adminubah.jsp">Ubah Barang | </a>
	
	<br>
	
	<form method="post" action="admintambah.jsp">
		<table>
		<tr>    
		<td>Nama</td><td><input type="text" name="nama"></td>
		</tr>
		<tr>
		<td>Harga</td><td><input type="text" name="harga"></td>
		</tr>
		<tr>
		<td>Stok</td><td> <input type="text" name="stok"></td>
		</tr>
		<tr>
		<td>Kategori</td><td> <input type="text" name="kategori"></td>
		</tr>
		<tr>
		<td>Deskripsi</td><td> <input type="text" name="deskripsi"></td>
		</tr>
		
		<input type="hidden" name="img_dir" value = ${requestScope["filenameservletadd"]} >
		
		</table>
		
		<br>
		<input type="submit" value="submit">
	</form>
	
	<form action="uploadfile" method="post" enctype="multipart/form-data">
               File:  <input type="file" name="file" />
               <input type="submit" value="upload" />
    </form>
   
    <div id="result">
        <h3>${requestScope["message"]}</h3>
        <h3>File yang diupload: ${requestScope["filenameservletadd"]}</h3>
        
    </div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>