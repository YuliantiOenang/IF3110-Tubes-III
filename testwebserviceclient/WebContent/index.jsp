<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %> 
<%	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");%>
<div id="content" class="float_l">
<script type="text/javascript">
function getTopItem(idkat){
	var query = "SELECT * FROM barang WHERE kategori_barang = "+idkat+" ORDER BY n_beli DESC LIMIT 0,3";
	var container = document.getElementById("kat"+idkat);
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		var result="";
		for (var i = 0; i < jsonArray.result.length; i++) {
			 result+="<div class='product_box'>";
			 result+="<h3> "+jsonArray.result[i][1]+"</h3><br>";
			 result+="<a href='detail.jsp?id="+jsonArray.result[i][0]+"'><img src='"+ jsonArray.result[i][2]+"'/></a>";
			 result+="<p class='product_price'>Harga : Rp "+jsonArray.result[i][3]+",-<br>";
			 result+="Stok : "+jsonArray.result[i][7] +"<br>";
			 result+="<form name='beli' action='addCart' method='post'>";
			 result+="<input type='hidden' name='id_barang' value='"+jsonArray.result[i][0]+"'>";
			 result+="<input type='hidden' name='request_tambahan' value='-'>";
			 result+="Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />";
			 result+="<input type='submit' value='Add to cart'>";
			 result+="</form></p></div>"; 
		}
		container.innerHTML = result;
	});
}
</script>
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
	window.onload=getTopItem(1);
</script>
</div>

<h1>Top Pakaian</h1>
<div id = kat2>
<script>
	window.onload=getTopItem(2);
</script>
</div>
<h1>Top Elektronik</h1>
<div id = kat3>
<script>
	window.onload=getTopItem(3);
</script>
</div>
<h1>Top Rumah Tangga</h1>
<div id = kat4>
<script>
	window.onload=getTopItem(4);
</script>
</div>
<h1>Top Olah Raga</h1>
<div id = kat5>
<script>
	window.onload=getTopItem(5);
</script>
</div>
</div>
<%@ include file= "./footer.jsp" %>