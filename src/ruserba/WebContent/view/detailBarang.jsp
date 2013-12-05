<%@ page import="javaModel.Barang" %>
<%
	Barang B = (Barang) request.getAttribute("barang");
%>
<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>
<h1 class='small-header'><%= B.nama.get(0) %></h1>
<div class='item_pict'>
	<img src='/ruserba/images/barang/<%= B.gambar.get(0) %>' onload='fitpict(this)' ></img>
</div>

<div class='item_detail'>
	<h4>product description</h4>
	<p><%= B.keterangan.get(0) %></p>
</div>

<div class='item_price'>
		<p>get it for :</p>
		<h4>IDR <%= B.harga.get(0) %></h4>
		<p>stok : <%= B.stok.get(0)%></p>
	<!-- <form method="post" onSubmit="Stok(); return false;" >  -->
	 <form method="post" onsubmit="pertanyaan(<%=B.id.get(0)%>,<%=B.stok.get(0)%>); return false;"  action = "/ruserba/barang/update" id="form-shop"> 
		<label class='qty'>Quantity</label>
		<input type='number' name="quantity" id="quantity_<%=B.id.get(0)%>" class='qty' value=1></input>
		<input type="hidden" name="id_barang" id="keterangan_<%=B.id.get(0)%>">
		<p>Request Message :</p>
		<textarea class='req_msg' name='req_msg'></textarea>
		<input type='submit' class='cart' value = 'Add to Cart'></input>
	 </form>
</div>

<script src="/ruserba/js/validasiBarang.js"></script>
<script>
	var server = "";
</script>

