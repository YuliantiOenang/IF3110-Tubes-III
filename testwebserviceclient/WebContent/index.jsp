<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %> 
<%	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");%>
<div id="content" class="float_l">
<h1>Current Date: <%= df.format(new java.util.Date()) %></h1>
<h1>Mekanisme Pembelian</h1>
	<p>
		---------------------------------------------------------------------<br>
		Tata cara pembelian:<br>
			1. Masukkan nilai quantity pada input box yang diberikan<br>
			2. Klik Tombol Add to cart.<br>
			3. Klik link Shopping Bag pada bagian Header<br>
			4. Pilih Kartu Kredit untuk pembayaran<br>
			5. Apabila ingin mengedit jumlah barang, ubah nilai pada input box dan klik edit shopcart<br>
			6. Klik tombol beli dan barang langsung dikirimkan pada Anda! :D<br>
		---------------------------------------------------------------------<br>
	</p>
<h1>Top Pangan</h1>
<div id = kat1>
<script>
	getTopItem(1);
</script>
</div>

<h1>Top Pakaian</h1>
<div id = kat2>
<script>
	getTopItem(2);
</script>
</div>
<h1>Top Elektronik</h1>
<div id = kat3>
<script>
	getTopItem(3);
</script>
</div>
<h1>Top Rumah Tangga</h1>
<div id = kat4>
<script>
	getTopItem(4);
</script>
</div>
<h1>Top Olah Raga</h1>
<div id = kat5>
<script>
	getTopItem(5);
</script>
</div>
<script>
function getTopItem(idkat){
	var divname = document.getElementById("kat"+idkat);
	divname.innerHTML = "Masuk semua anjing";
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			divname.innerHTML = xmlhttp.responseText;

			if(err_login.innerHTML==""){
				//Handle SESSION & LOCAL STORAGE
				window.location="index.jsp";
			}
		}
	};
	xmlhttp.open("GET","getTopIem?idkat="+idkat,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send();
}
</script>
</div>
<%@ include file= "./footer.jsp" %>