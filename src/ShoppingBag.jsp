<%
	if (session.getAttribute("username")==null){
		response.sendRedirect("registrasi.jsp");
	}else{

	}
	
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Shopping Bag</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
 <div id="container">
		
	<jsp:include page="header.jsp"/>
	
	<!-- Navbar Section -->
		<p id="bbuy-a"> Your Shopping Bag</p>
	<!-- End of Navbar -->
		
	<jsp:useBean id="cart" scope="session" class="npackage.Cart" />
		
	<div id="dagangan">
	<div class="frame">
		<div class="kolom-6 product">
		
			<%int i=0;%>
		
			<c:forEach var="cartItem" items="${cart.getCartItems()}" varStatus="counter"> 
			
				<form id='item' name="item" method="post" action="CartController"> 
						<%i++;%>
					<p class="nama-produk-b"><c:out value="${counter.count}. "/><c:out value="${cartItem.getNama()}"/> </p>
					<p class="harga">Harga	: <c:out value="${cartItem.harga}"/>
					Jumlah	:
					<input type='hidden' name='itemIndex' value="<%out.print(i);%>">
					<input type='text' id="quantity<%out.print(i);%>" name="quantity" value='<c:out value="${cartItem.jumlah}"/>'>
					<input type='hidden' id="jdb<%out.print(i);%>" name="jdb" value='<c:out value="${cartItem.jumProduk}"/>'>
					<input type='hidden' id="<%out.print("nmb"+i);%>" name="nmb" value='<c:out value="${cartItem.getNama()}"/>'>
					<input type="submit" name="action" value="Update">
					<input type="submit" name="action" value="Delete">
					<br>Kategori	: <c:out value="${cartItem.kategori}"/> 
					<br>Jumlah Harga	: Rp <c:out value="${cartItem.jumHarga}"/> </p>
				</form>
			</c:forEach> 
			
			
			<form name="item" method="post" action="CartController" onsubmit="return isAdaCreditCard('<%
				
			if ((session.getAttribute("cardnumber")!=null) && !(session.getAttribute("cardnumber").equals(""))){			
				out.print("true");
			}else{
				out.print("false");
			}%>')"> 
			
				<p class="nama-produk-b">Total:	Rp <c:out value="${cart.hargaTotal}"/></p>
				<input type="hidden" name="jumlahbarangsb" id="jumlahbarangsb" value="<c:out value='${cart.getItemCount()}'/>">
				<input class="nama-produk-b" type="submit" name="action" value="checkout">
			</form>
  
		</div>
	</div>
	</div>
	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>
	<script>
		
	
	
		function isAdaCreditCard(val){
			if (val=="true"){
				var valid=true;
			
				var str = "";
				
				for (var i=1;i<=document.getElementById("jumlahbarangsb").value;i++){
					if (+document.getElementById('quantity'+i).value>+document.getElementById('jdb'+i).value){
						valid=false;						
						document.getElementById('nmb'+i).value;
						str+=document.getElementById('nmb'+i).value +". Sisa barang tersedia : "+ document.getElementById('jdb'+i).value+"\n";
						
						//alert(document.getElementById('nmb'+i).value +"melebihi sisa barang yang ada\nsisa barang :"+document.getElementById('jdb'+i).value);
					}
				}
				if (valid==true){
					alert ("Thanks for purchasing");
				}else{
					alert("Barang berikut tidak cukup :\n"+str);
					return false;
				}
			}else{
				alert("tidak ada creditcard");
				window.location="creditcard.jsp";
				return false;
			}
		}
	</script>
	</div>
</body>
</html>