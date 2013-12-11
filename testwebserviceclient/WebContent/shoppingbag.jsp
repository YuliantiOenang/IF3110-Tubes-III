<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<%
if((sesi== null)|| (sesi.getAttribute("username")==null))
	out.print("<script>window.location='register.jsp';</script>");
%>
<script type="text/javascript" src="beli.js"></script>
<script>
function getBarang(id, item, req){
	var query = "SELECT * FROM barang WHERE id_barang='"+id+"'";
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		for (var i = 0; i <jsonArray.result.length;i++){
			document.write(jsonArray.result[i][2]+" : <input type='text' name = '"+i+"' value='"+item+"'>"+req+"<br>");
			var totalHarga = document.getElementById("temp").innerHTML;
		    totalHarga+= item * jsonArray.result[i][4];
		    document.getElementById("temp").innerHTML = totalHarga;
		}
	});
}
function getKredit(username){
	var query = "SELECT * FROM creditcard WHERE card_owner ='"username+"'";
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		var totalHarga = document.getElementById("temp").innerHTML; 
		document.write("<input type='submit' id='edit' value='Edit!'><br><br></form>");
		document.write("Total Pembelian Anda :<input type='text' id='totalharga' value='"+totalHarga+"' readonly><br>Choose Your Credit Card :<br>");
		document.write("<form name='beli_barang' action='javascript:verBeli();' method='post'>");
		if(jsonArray == null){
			document.write("<input type='hidden' name ='creditid' value='asd'>");
			document.write("<input type='submit' value='Beli!'>");
		} else {
			for (var i = 0; i<jsonArray.result.length ; i++){
				if(counter ==0){
				  document.write("<input type='radio' value='"+jsonArray.result[i][1]+"' name='creditid' checked>"+jsonArray.result[i][1]+"<br>");
				}
				else{
				  document.write("<input type='radio' value='"+jsonArray.result[i][1]+"' name='creditid'>"+jsonArray.result[i][1]+"<br>");  
				}
				counter++;
			}
			document.write("<input type='submit' value='Beli!'><div id='barang_error'></div>");  
		}
		document.write("</form>");
	});
}
</script>
<h3> Your Shopping Cart </h3>
<div id="temp" hidden="true"></div>

<form name="shopping_cart" action="editShopCart" method="post">
<% 
if (sesi.getAttribute("shopping_cart")==null) {
	out.print("You haven't Add anything to Shopping Cart");
} else {
	Vector<String> shopping_cart = (Vector<String>) session.getAttribute("shopping_cart");
	Vector<String> shopping_request = (Vector<String>) session.getAttribute("shopping_request");
	Vector<Integer> item= (Vector<Integer>) session.getAttribute("amount");
	
	int totalHarga=0;
	int counter = 0;
	//Create a Statement object and call its executeUpdate 
	//method to insert a record
	for(int i = 0; i < shopping_cart.size();i++){
	%>
	<script>
		getBarang(<% out.print(shopping_cart.get(i)); %>,<% out.print(item.get(i)); %>, <% out.print(shopping_request.get(i)); %>);
	</script>	  	
	<%
	}
	%>
	<script type="text/javascript">
		getKredit(<% out.print(session.getAttribute("username")); %>);
	</script>
	<%
}
%>
<%@ include file= "./footer.jsp" %>