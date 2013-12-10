<%@page import="java.util.HashMap"%>
<%@page import="model.Model;"%>
<%
HashMap<String,String> model = new HashMap<String,String>();
model = (HashMap<String,String>)request.getAttribute("model");
%>
<jsp:include page="adminbegin.jsp"></jsp:include>
<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>
<h1 class='small-header'><%=model.get("nama") %></h1> 
<div class='item_pict'>
	<img src='${pageContext.request.contextPath}/img/barang/<%=model.get("gambar") %>' onload='fitpict(this)' ></img>
	
</div>

<div class="item_edit">
	<h4>product information</h4>
	<form method="post" width=100% action=edit>
		<input type="text" name="id" id="id" value="<%=model.get("id") %>" width=100% hidden>
		<div class="per_form">
			<label>Nama</label></br><input type="text" name="nama" id="nama" value="<%=model.get("nama") %>" width=100%>
			
		</div>
		<div class="per_form">
		<% int bil = Model.rupiahReverseFormatter(model.get("harga")); %>
			<label>Harga</label></br><input type="text" name="harga" id="nama" value="<%=bil %>" width=100%>
			
		</div>
		<div class="per_form">
			<label>Deskripsi</label></br><input type="text" name="deskripsi" id="nama" value="<%=model.get("keterangan") %>" width=100%>
			
		</div>
		<div class="per_form">
			<label>Stok</label></br><input type="text" name="stok" id="stok" value="<%= model.get("stok")  %>" width=100%>
		</div>
		<button type="submit" class="btn small">Simpan</button><button type="button" class="btn small" onclick="return tes();">Hapus</button>
	</form>
	
</div>


<script src="${pageContext.request.contextPath}/js/validasiBarang.js"></script>
<script>
	var server = "${pageContext.request.contextPath}";
	function tes(){
		var r = confirm("Are you sure want to delete this item?");
		if (r == true)
		  {
			window.location.href = "delete?id=" + <%=model.get("id") %>;
		  }
		else
		  {
		  }
		return false;
	}
	
</script>

	
<jsp:include page="adminend.jsp"></jsp:include>