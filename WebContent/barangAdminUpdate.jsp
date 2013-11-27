<%@ include file= "./header.jsp" %>
<%@ page import="tubesII.wbd.kay.barang.*" %>
<%
	Barang barang = (Barang)(request.getAttribute("barang"));
%>
<form name="barangAdmin" action="barangAdmin" method="post">
	Nama Barang <input type="text" name="nama_barang" value=<% out.print(request.getParameter("nama_barang")); %>><br>
	Keterangan <input type="textarea" name="keterangan" value=<% out.print(request.getParameter("keterangan")); %>><br>
	Harga Barang <input type="number" name="harga_barang" min=0 value=<% out.print(request.getParameter("harga_barang")); %>><br>
	Gambar Barang <input type="text" name="gambar_barang" value=<% out.print(request.getParameter("gambar_barang")); %>><br>
	Stok <input type="number" name="stok" min=0 value=<% out.print(request.getParameter("stok")); %>><br>
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="id_barang" value=<% out.print(request.getParameter("id_barang")); %>>
</form>
</body>
</html>