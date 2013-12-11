<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="kelas.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrasi Inventori</title>
<script src="inventori.js"></script>
<script>
	function check_admin(){
		if (localStorage.privilege !== "Admin"){
			window.location.href = "home";
		}		
	}
</script>
</head>
<body onload="check_admin()">

<div class="page_container">
	<%@ include file="template/template.jsp" %>
	<link rel="stylesheet" href="css/inventori.css" type="text/css"> 
	<% 
		Barang b = (Barang) request.getAttribute("barang");
		String action = (String) request.getAttribute("action");
		
		boolean add = action.equals("add");
	%>
	
	<div class="contents">		
	<form action="inventori" id="invform" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="gid" value='<%= add ? "-1" : (String) request.getAttribute("gid") %>' />
	<input type="hidden" id="actionval" name="action" value='<%= action %>' />
	
	<div class="table">
	<div class="row"><div class="cell25">Nama</div><div class="cell75"><input type="text" name="nama" value='<%= add ? "" : b.getNama() %>' /></div></div>
	<div class="row"><div class="cell25">Harga</div><div class="cell75"><input type="text" name="harga" value='<%= add ? "" : b.getHarga() %>' /></div></div>
	<div class="row"><div class="cell25">Jumlah</div><div class="cell75"><input type="text" name="jumlah" value='<%= add ? "" : b.getJumlah() %>' /></div></div>
	<div class="row"><div class="cell25">Kategori</div><div class="cell75"><select name="kategori">
		<%
			String[] kat = {"Roti", "Minuman", "Kalengan", "Segar", "Peralatan"};
			for (int i = 0; i < kat.length; i++){
				int k = i+1;
				%>
				<option value='<%=k%>' <%= !add && (k == b.getId_cat()) ? "selected" : "" %>><%=kat[i]%></option>
				<%
			}
		%>	
	</select></div></div>
	<div class="row">Deskripsi</div>
	<div class="row"><textarea name="desc"><%= add ? "" : b.getDesc() %></textarea></div>
	<div class="row">Gambar</div>
	<div class="row"><img src='res/<%= add ? "barang/default.jpg" : b.getGambar() %>' id="showgambar" /></div>
	<div class="row"><input type="file" name="gambar" /></div>
	<div class="row right">
	<%
		if(add){
	%>
		<input type="submit" value="add" />	
	<%
		}else{
	%>
		<input type="button" onclick="editsubmit()" value="edit" /> <input type="button" onclick="delsubmit()" value="delete" />
	<%
		}
	%>
	</div>
	</div>
	</form>
</div>
</div>

</body>

</html>