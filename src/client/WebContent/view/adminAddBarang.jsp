<%@page import="javaModel.Kategori" %>
<%@page import="javaModel.Helper" %>
<script src="/ruserba/js/cekUnik.js" type="text/javascript"></script>

<form action="/ruserba/admin/addbarang" method="POST" enctype="multipart/form-data">
<div class='register_div'>
	<h1 class="header">Tambah Barang</h1>
	<div class="per_form">
		<label>Nama</label>
		<input type="text" id="nama_barang" onkeyup="cekUnik(this.value)" name="nama_barang" autocomplete="off"> <span id="message"></span>
	</div>
	<div class="per_form">
		<label>Kategori</label>
		 
		<select name="kategori">
			<option value="1">--Pilih Kategori--</option>
			<%
			//java.sql.ResultSet RS = (java.sql.ResultSet) request.getAttribute("listK");
			//while (RS.next())
			//{
			    Kategori K = Helper.findAllKategori();
			    for (int i = 0; i < K.id.size(); i++) {
			%>
				<option value="<%=K.id.get(i)%>"> <%=K.nama_kategori.get(i)%></option>
			<%
				}
			%>
			
		</select>
	</div>
	<div class="per_form">
		<label>Harga</label>
		<input type="text" name="harga_barang">
	</div>
	<div class="per_form">
		<label>Stok</label>
		<input type="text" name="stok">
	</div>
	<div class="per_form">
		<label>Keterangan</label>
		<input type="text" name="keterangan">
	</div>
	<div class="per_form">
		<label>Gambar</label>
		<input type="file" name="file">
	</div>
	<button type="submit" id="submitEditBarang" name="submit" class="btn small full">Tambah Barang</button>
</div>
</form>