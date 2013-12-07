<%@page import="java.util.HashMap"%>
<%
HashMap<String,String> model = new HashMap<String,String>();
model = (HashMap<String,String>)request.getAttribute("model");
%>
<jsp:include page="contentBegin.jsp"></jsp:include>
<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>
<h1 class='small-header'><%=model.get("nama") %></h1>
<div class='item_pict'>
	<img src='${pageContext.request.contextPath}/img/barang/<%=model.get("gambar") %>' onload='fitpict(this)' ></img>
</div>

<div class='item_detail'>
	<h4>product description</h4>
	<p>><%=model.get("keterangan") %></p>
</div>

<div class='item_price'>
		<p>get it for :</p>
		<h4>IDR <%=model.get("harga") %></h4>
	<!-- <form method="post" onSubmit="Stok(); return false;" >  -->
	 <form method="post" onsubmit="cekQuantity(); return false;"  action = " <% out.print(request.getContextPath()+"/cart/addcart"); %>" id="form-shop"> 
		<label class='qty'>Quantity</label>
		<input type='number' name="quantity" id="quantity" class='qty' value=1></input>
		<input type="hidden" name="id_barang" id="id_barang" value="<%=model.get("id") %>">
		<p>Request Message :</p>
		<textarea class='req_msg' name='req_msg'></textarea>
		<input type='submit' class='cart' value = 'Add to Cart'></input>
	 </form>
</div>

<script src="${pageContext.request.contextPath}/js/validasiBarang.js"></script>
<script>
	var server = "${pageContext.request.contextPath}";
</script>

	
<jsp:include page="contentEnd.jsp"></jsp:include>