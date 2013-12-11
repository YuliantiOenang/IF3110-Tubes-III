<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script>
	function doSearch(query1, query2, laman, name, harga, kategori) {
		var n_item = 0;
		sendQuery(query1, function() {
			var jsonArray = JSON.parse(xmlhttp.responseText);
			n_item = jsonArray.result[0];
		});
		var response = "";
		if (n_item > 0) {
			sendQuery(query2, function() {
				jsonArray = JSON.parse(xmlhttp.responseText);
				for (var i = 0; i < jsonArray.result.length; i++) {
					response += "<div class='product_box'>";
					response += "<h3>"+jsonArray.result[i][1]+"</h3>";
				    response += "<a href='detail.jsp?id="+jsonArray.result[i][0]+"'><img src='"+ jsonArray.result[i][2]+"'/></a>";
				    response += "<p class='product_price'>Harga : Rp "+jsonArray.result[i][3]+",-<br>";
				    response += "Stok : "+jsonArray.result[i][7] +"<br>";
				    response += "<form name='beli' action='addCart' method='post'>";
				    response += "<input type='hidden' name='id_barang' value='"+jsonArray.result[i][0]+"'>";
				    response += "<input type='hidden' name='request_tambahan' value='-'>";
				    response += "Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />";
				    response += "<input type='submit' value='Add to cart'></div>";
				}
			});
		} else {
			response = "Search Return no value";
		}
		document.write(response);
		document.write(doPaging(n_item, laman, name, harga, kategori));
	}
	
	function doPaging(n_item, laman, name, harga, kategori) {
		var response = '';
		var nextLaman = laman+1;
		var prevLaman = laman-1;
		if (n_item > 10) {
			if (laman == 1) {
				response += "<li> <a href='search.jsp?laman="+nextLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>Berikutnya>>></a></li><br>";
				for (var x=0;x<n_item/10;x++) {
					response += "<li> <a href='search.jsp?laman="+(x+1)+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>"+(x+1)+"</a></li><br>";
				}
			}
			else if (laman >= n_item/10) {
				response += "<li> <a href='search.jsp?laman="+prevLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'><<<Sebelumnya</a></li><br>";
				for (var x=0; x< n_item/10;x++) {
					response += "<li> <a href='search.jsp?laman='"+(x+1)+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>"+(x+1)+"</a></li><br>";
				}
			} else {
				response += "<li> <a href='search.jsp?laman="+nextLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>Berikutnya>>></a></li><br>";
				for (var x=0;x< n_item/10;x++) {
					response += "<li> <a href='search.jsp?laman="+(x+1)+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>"+(x+1)+"</a></li><br>";
				}
				response += "<li> <a href='search.jsp?laman="+prevLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'><<<Sebelumnya</a></li><br>";
			}
				//fitur sorting
				
				response += "<p> Sort By : </p>";
				response += "<li> <a href='search.jsp?laman=1&searched="+name+"&order=nama_barang&s_harga=&s_kategori="+kategori+"'>Nama Barang</a></li><br>";
				response += "<li> <a href='search.jsp?laman=1&searched="+name+"&order=harga_barang&s_harga=&s_kategori="+kategori+"'>Harga Barang</a></li><br>";
		}
		alert(response);
		return(response);
	}
</script>
<%
int laman = Integer.parseInt(request.getParameter("laman"));
int i = (laman-1)*10;
int n_item =0;
String order="";
if(request.getParameter("order")== null){
	 order = "nama_barang";
}
else{
	 order = request.getParameter("order");
}
String name = request.getParameter("searched");
String harga = request.getParameter("s_harga");
String kategori = request.getParameter("s_kategori");
String n_item_query="";
String search_query="";

if (!name.equals("")) {
	if(!harga.equals("")){ //ada harga
		if(!kategori.equals("")){
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori;
			search_query = "SELECT * FROM barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}else { //kategori kosong
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga;
			search_query = "SELECT * FROM barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
	}else{ //harga kosong
		if(!kategori.equals("")) {
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like '%"+name+"%' AND kategori_barang = "+kategori;
			search_query = "SELECT * FROM barang WHERE nama_barang like '%"+name+"%' AND kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		} else {
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE nama_barang like '%"+name+"%'";
			search_query = "SELECT * FROM barang WHERE nama_barang like '%"+name+"%' ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
		
	}
}else{// nama kosong
	if(!harga.equals("")){ //ada harga
		if(!kategori.equals("")){ //ada kategori
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori;
			search_query = "SELECT * FROM barang WHERE harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}else { //kategori kosong
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE harga_barang BETWEEN 0 AND "+harga;
			search_query = "SELECT * FROM barang WHERE harga_barang BETWEEN 0 AND "+harga+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
	} else { //gak ada harga
		if(!kategori.equals("")) {
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM barang WHERE kategori_barang = "+kategori;
			search_query = "SELECT * FROM barang WHERE kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
	}
}
%>
<script>
	doSearch('<%=n_item_query%>', '<%=search_query%>', <%=laman%>, '<%=name%>', '<%=harga%>', '<%=kategori%>');
</script>
<div id='content' class='float_l'>
</div>
<%@ include file= "./footer.jsp" %>