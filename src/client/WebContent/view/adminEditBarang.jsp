<script src="/ruserba/js/cekUnik.js" type="text/javascript"></script>

<hr>
<% 
java.sql.ResultSet RS = (java.sql.ResultSet) request.getAttribute("edit");
while (RS.next())
{
%>

<form action="/ruserba/admin/editbarang?id=<%=request.getAttribute("id")%>" method="POST" enctype="multipart/form-data">
	
	<div class="register_div">
		<h1 class="header">Edit Barang</h1>

		<div class="per_form">
			<label>Nama</label>
			<input type="text" id="nama_barang" onkeyup="cekUnik(this.value)" name="nama_barang" value="<%=RS.getObject(3)%>" autocomplete="off"><span id="message"></span>
		</div>
		<div class="per_form">
			<label>Harga</label>
			<input type="text" name="harga_barang" value="<%=RS.getObject(4)%>">
		</div>
		<div class="per_form">
			<img src="/ruserba/images/barang/<%=RS.getObject(5)%>" width="100" height="100"><br>
			<label>Gambar</label>
			<input type="file" name="file" value="<%=RS.getObject(5)%>">
		</div>
		<button type="submit" id="submitEditBarang" name="submit" class="btn small full">Edit</button>
		<a href="/ruserba/admin" class="btn small full">Kembali</a>
	</div>
</form>
<%
}
%>