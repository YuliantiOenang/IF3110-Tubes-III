<%@page import="java.util.HashMap"%>
<jsp:include page="adminbegin.jsp"></jsp:include>
<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>
<h1 class='small-header'>Tambah Barang</h1> 

<div class="item_edit">
	<form method="post" width=100% action="tambah">
		<div class="per_form">
			<label>Nama</label></br><input type="text" name="nama" id="nama" value="" width=100%>
			
		</div>
		<div class="per_form">
			<label>Harga</label></br><input type="text" name="harga" id="nama" value="" width=100%>
			
		</div>
		<div class="per_form">
			<label>Deskripsi</label></br><input type="text" name="deskripsi" id="nama" value="" width=100%>
			
		</div>
		<div class="per_form">
			<label>Stok</label></br><input type="text" name="stok" id="stok" value="" width=100%>
		</div>
		<div class="per_form">
			<label>Gambar</label></br><input type="file" name="stok" id="stok" value="" width=100%>
		</div>
		<button type="submit" class="btn small">Tambah</button>
	</form>
	
</div>



<script src="${pageContext.request.contextPath}/js/validasiBarang.js"></script>
<script>
	var server = "${pageContext.request.contextPath}";
</script>

	
<jsp:include page="adminend.jsp"></jsp:include>