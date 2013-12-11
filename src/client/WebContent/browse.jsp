<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.*" %>

<jsp:include page="contentBegin.jsp"></jsp:include>
<script type="text/javascript">
	var run = false;
	function fitbarang(obj) {
		fitimg(obj,180,175,true,true,false);
	}
	function backToPict(id) {
		if (!run) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					if (x==0) run=true;
					document.getElementById('cart'+id).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('cart'+id), " hidden");
					vara++;
					console.log(x+' : cart'+id);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('item'+id), "hidden");
						document.getElementById('item'+id).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : item'+id);
						if (varc==11) run=false;
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
	function goToCart(id) {
		if (!run) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					if (vara==0) run=true;
					document.getElementById('item'+id).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('item'+id), " hidden");
					vara++;
					console.log(x+' : item'+id);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('cart'+id), "hidden");
						document.getElementById('cart'+id).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : cart'+id);
						if (varc==11) run=false;
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
</script>


<div class='header_divider'>
	<h1 class='header'>Search</h1>
</div>
<div class='header_divider'>
	<div class="sorting">
		Urutan : 
		<%
			String query = (String)request.getAttribute("searchquery");
			String sort = (String)request.getAttribute("sorting");
			String nowsort = "sort=nama ASC&";
			if (sort.equals("nama ASC")) nowsort = "sort=nama DESC&";
		%> 
		<a href="?<%= nowsort+query %>" class="btn small">Nama</a> 
		<%
			nowsort = "sort=harga ASC&";
			if (sort.equals("harga ASC")) nowsort = "sort=harga DESC&";
		%>
		<a href="?<%= nowsort+query %>" class="btn small">Harga</a>
	</div>
	<div class="pagination"><%=request.getAttribute("paging") %></div>
</div>

	<%
		
		int i = 0;
		int idx = ((Integer)request.getAttribute("halaman")-1)*10;
		int idxnow = 0;
		boolean vertdiv = false;
		for (HashMap<String, String> value : (Vector<HashMap<String,String>>)request.getAttribute("model")) {
			if ((idxnow>=idx)&&(idxnow<(idx+10)))
			{
				if (i==0 || i%2==0){
					out.print("<div class='vertdiv'>");
					vertdiv = true;
				}
				out.print("<div class='itembox'> <div class='pict' id='item"+value.get("id")+"'> <div title='");
				if (Integer.parseInt(value.get("stok"))>0) out.print("Ready Stock"); else out.print("Out of Stock");
				out.print("' class='itembox_img'>");
				out.print("<img onload='fitbarang(this)' src='"+request.getContextPath()+"/img/barang/"+value.get("gambar")+"'/>");
				out.print("</div>");
				out.print("<div class='minicart_icon'>");
				out.print("<a href=# onclick='goToCart("+value.get("id")+")'><img src='"+request.getContextPath()+"/img/site/cart_black.png'/></a>");
				out.print("</div>");
				out.print("<div class='item_name'><a href='"+request.getContextPath()+"/barang/view?id="+value.get("id")+"'>"+value.get("nama")+"</a><br/>IDR "+value.get("harga")+"</div>");
				out.print("</div>");
				out.print("<div class='minicart hidden' id='cart"+value.get("id")+"'>");
				out.print("<form action = "+request.getContextPath()+"/cart/addcart"+" id='form-shop-"+value.get("id")+"' method='post' onsubmit='cekQuantity("+value.get("id")+"); return false;'>");
				out.print("<label class='qty small'>Quantity</label>");
				out.print("<input type='number' name='quantity' id='quantity_"+value.get("id")+"' class='qty' value=1></input>");
				out.print("<input type='hidden' name='id_barang' id='id_barang_"+value.get("id")+"' value='"+value.get("id")+"'>");
				out.print("<p>Request Message :</p>");
				out.print("<textarea class='req_msg small' name='req_msg'></textarea>");
				out.print("<input type='submit' class='cart small' value = 'Add to Cart'></input>");
				out.print("<p class='back' href=# onclick='backToPict("+value.get("id")+")'>back</p>");
				out.print("</form>");
				out.print("</div>");
				out.print("</div>");
				// VERTICAL DIV CLOSER
				if ((i%2)==1){
					out.print("</div>");
					vertdiv = false;
				}
				i++;
			}
			idxnow++;
		}
		if (vertdiv) out.print("</div>");
	%>

<script src="${pageContext.request.contextPath}/js/validasiBarang.js"></script>
<script>
	var server = "${pageContext.request.contextPath}";
</script>
	
<jsp:include page="contentEnd.jsp"></jsp:include>