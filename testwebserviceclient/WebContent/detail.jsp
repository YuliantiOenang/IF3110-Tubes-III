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
		document.getElementById("id_barang").innerHTML = jsonArray.result[0][1];
		document.getElementById("img").innerHTML = jsonArray.result[0][3];
	});
}
</script>
<body>
	<h1 id="nama"></h1>
	<img id="img" width='300px' height='300px'/><br>
	<br><h2>Deskripsi :</h2>
	<p id="detail"></p><br>
	Request tambahan 	: <br>
	<form action='addCart' method='post' id='usrform'>
	<textarea rows='4' cols='50'  name='request_tambahan' form='usrform'></textarea><br>
	<input type='hidden' name='id_barang'>
	Quantity : <input type='text' name='qt' style='width: 20px; text-align: right' /><br>
	<input type='submit' value='Add to cart'></form>
	<script>
		getDetail(<%= request.getParameter("id") %>);
	</script>
</body>

<%@ include file= "./footer.jsp" %>