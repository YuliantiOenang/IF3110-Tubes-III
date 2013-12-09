<%@page import="javaModel.Barang"%>
<script src="/ruserba/js/cekUnik.js" type="text/javascript"></script>

<hr>
<% 
//java.sql.ResultSet RS = (java.sql.ResultSet) request.getAttribute("edit");
//while (RS.next())
//{
    Barang B = ((Barang) request.getAttribute("edit"));
%>

<form action="/ruserba/admin/editbarang?id=<%=request.getAttribute("id")%>" method="POST" enctype="multipart/form-data">
	
	<div class="register_div">
		<h1 class="header">Edit Barang</h1>

		<div class="per_form">
			<label>Nama</label>
			<input type="text" id="nama_barang" onkeyup="cekUnik(this.value)" name="nama_barang" value="<%=B.nama.get(0)%>" autocomplete="off"><span id="message"></span>
		</div>
		<div class="per_form">
			<label>Harga</label>
			<input type="text" name="harga_barang" value="<%=B.harga.get(0)%>">
		</div>
		<div class="per_form">
			<img src="/ruserba/images/barang/<%=B.gambar.get(0)%>" width="100" height="100"><br>
			<label>Gambar</label>
			<input type="file" name="file" value="<%=B.gambar.get(0)%>">
		</div>
		<button type="submit" id="submitEditBarang" name="submit" class="btn small full">Edit</button>
		<a href="/ruserba/admin" class="btn small full">Kembali</a>
	</div>
</form>
<%
//}
%>