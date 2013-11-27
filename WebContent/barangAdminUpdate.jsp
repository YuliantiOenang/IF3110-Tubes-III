<%@ include file= "./header.jsp" %>
<%@ page import="tubesII.wbd.kay.barang.*" %>
<%
	Barang barang = (Barang)(request.getAttribute("barang"));
%>
<form name="barangAdmin" action="barangAdmin" method="post" enctype="multipart/form-data">
	Nama Barang <input type="text" name="nama_barang" value="<% out.print(barang.nama_barang); %>"><br>
	Keterangan <input type="textarea" name="keterangan" value="<% out.print(barang.keterangan); %>"><br>
	Harga Barang <input type="number" name="harga_barang" min=0 value="<% out.print(barang.harga_barang); %>"><br>
	Gambar Barang <input type="file" name="gambar_barang"><br>
	Stok <input type="number" name="stok" min=0 value="<% out.print(barang.stok); %>"><br>
	<input type="submit" value="Save">
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="id_barang" value="<% out.print(barang.id_barang); %>">
</form>
<%@ include file= "./footer.jsp" %>