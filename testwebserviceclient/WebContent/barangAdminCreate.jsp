<%@ include file= "./header.jsp" %>
<form name="barangAdmin" action="barangAdmin" method="post" enctype="multipart/form-data">
	Nama Barang <input type="text" name="nama_barang"><br>
	Keterangan <input type="textarea" name="keterangan"><br>
	Harga Barang <input type="number" name="harga_barang" min=0><br>
	Gambar Barang <input type="file" name="gambar_barang"><br>
	Stok <input type="number" name="stok" min=0><br>
	<input type="submit" value="Create">
	<input type="hidden" name="action" value="create">
	<input type="hidden" name="kategori_barang" value="<% out.print(request.getParameter("kategori_barang")); %>">
</form>
<%@ include file= "./footer.jsp" %>