<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script src='${pageContext.request.contextPath}/ajax.js'></script>
<script type="text/javascript"></script>
<script>
function getDetail(id){
	var query = "SELECT * FROM barang where id_barang='"+id+"'";
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		document.getElementById("nama").innerHTML = jsonArray.result[0][1];
		document.getElementById("detail").innerHTML = jsonArray.result[0][6];
	});
}
function getImgSrc(id){
	var query = "SELECT * FROM barang where id_barang='"+id+"'";
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		document.write("<img src='"+jsonArray.result[0][2]+"' width='300px' height='300px'/><br>");
	});
}
</script>
<body>
	<script>
		getDetail(<%= request.getParameter("id") %>);
	</script>
	<h1 id="nama"></h1>
	<script>
		getImgSrc(<%= request.getParameter("id") %>);
	</script>
	<br><h2>Deskripsi :</h2>
	<p id="detail"></p><br>
	Request tambahan 	: <br>
	<form name='beli' action='addCart' method='post'>
	<input type="text"  height="100" width="500" name='request_tambahan'><br>
	<input type='hidden' name='id_barang' value='<%= request.getParameter("id") %>'>
	Quantity : <input type='text' name='qt' style='width: 20px; text-align: right' /><br>
	<input type='submit' value='Add to cart'></form>
</body>

<%@ include file= "./footer.jsp" %>