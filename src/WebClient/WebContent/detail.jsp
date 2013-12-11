<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="kelas.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detail Barang</title>
</head>
<body>
	<div class="page_container">
		<%@ include file="template/template.jsp" %>
		<link rel="stylesheet" href="css/details.css" type="text/css"> 
		<% 
			Barang b = (Barang) request.getAttribute("barang");
		%>
		<div class = "goodsimagedata"> 
			<div class = "goodsimage">
				<img class="gambardetail" width=470px src='res/<%= b.getGambar() %>'> <br/>
			</div>
			<div class = "data">
				<div id="dataname"><%= b.getNama() %></div><br/>
				<div id="description"><%= b.getDesc() %></div><br/>
				<form novalidate> Permintaan Khusus : <br/> 
					<textarea id="textinput" class="textinput" type="text" name="tambahan"></textarea>
				</form>
					<div id='numinput'>
					Quantity : 
					<input id="quant1" value="0" type="number"></div> 
					<div id='cart'><img onclick='validate(<%= b.getId_inven() %>, 1)' src="res/addtocart.png" /></div>
					<br/>
					<div id='notif1'></div>
					<span id='editspan'></span>
					<script>
					
					if (localStorage.privilege === "Admin"){
						var id = <%=b.getId_inven() %>;
						document.getElementById("editspan").innerHTML = "<input type='button' value='edit' onclick='editbarang("+id+")' />";
					}
					</script>
			</div>
		</div>
	</div>
</body>
	<script src="transaction.js"></script>
</html>