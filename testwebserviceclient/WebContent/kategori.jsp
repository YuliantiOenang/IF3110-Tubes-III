<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script src='${pageContext.request.contextPath}/ajax.js'></script>
<script>
	function showBarang(idkat, order, istring) {
		var query = "SELECT * FROM barang WHERE kategori_barang = "+idkat+" ORDER BY "+order+" ASC LIMIT "+istring+", 10";
		sendQuery(query, function() {
			var jsonArray = JSON.parse(xmlhttp.responseText);
			var response="";
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
			document.write(response);
		});
	}
</script>

<div id="content" class="float_l">
 <%
 HttpSession sesion = request.getSession(true);
 if(sesion.getAttribute("username")!=null&&sesion.getAttribute("username").equals("admin")){
	 out.print("<a href='barangAdmin?action=create&kategori_barang="+request.getParameter("id")+"'>Create</a>");
 }
 int laman =  Integer.parseInt(request.getParameter("laman"));
 int idkat = Integer.parseInt(request.getParameter("id"));
 String nama="";
 int i = (laman-1)*10;
 int n_item =30;
 String istring = ""+i;
 String order="";
 if(request.getParameter("order")== null){
	 order = "nama_barang";
 }
 else{
	 order = request.getParameter("order");
 }
 	if(idkat==1){
		nama = "Pangan";
	}
	else if(idkat==3){
		nama = "Elektronik";
	}
	else if(idkat==2){
		nama = "Pakaian";
	}
	else if(idkat==4){
		nama = "Rumah Tangga";
	}
	else if(idkat==5){
		nama = "Olah Raga";
	}
	else {
		nama = "tidak terdaftar";
	}
 %>
 
 <script>showBarang(<%=idkat%>, '<%=order%>', <%=istring%>);</script>
 <%
 
 int nextlaman = laman+1;
 int prelaman = laman-1;
 if (laman == 1) {
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+nextlaman+"'>Berikutnya>>></a></li><br>");
		for (int x=1;x<=n_item/10;x++) {
			out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+x+"'>"+x+"</a></li><br>");
		}
	}
	else if (laman >= n_item/10) {
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+prelaman+"'><<<Sebelumnya</a></li><br>");
		for (int x=1;x<=n_item/10;x++) {
			out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+x+"'>"+x+"</a></li><br>");
		}
	} else {
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+nextlaman+"'>Berikutnya>>></a></li><br>");
		for (int x=1;x<=n_item/10;x++) {
			out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+x+"'>"+x+"</a></li><br>");
		}
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+prelaman+"'><<<Sebelumnya</a></li><br>");
	}
out.print("<p> Sort By : </p>");
out.print("<li> <a href='search.jsp?laman=1&searched=&order=nama_barang&s_harga=&s_kategori="+idkat+"'>Nama Barang</a></li><br>");
out.print("<li> <a href='search.jsp?laman=1&searched=&order=harga_barang&s_harga=&s_kategori="+idkat+"'>Harga Barang</a></li><br>");
 %>
</div>
<%@ include file= "./footer.jsp" %>