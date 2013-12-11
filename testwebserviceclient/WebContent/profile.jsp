<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script type="text/javascript">
function getProfileContent() {
	//KALO UDAH BISA LOGIN, GANTI ADMIN JADI USERNAME DARI SESSIONNYA
	var query = "SELECT * FROM user WHERE username ='admin'";
	var container = document.getElementById("profileContent");
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		var result="";
		for (var i = 0; i < jsonArray.result.length; i++) {
			 result+="<h3> "+jsonArray.result[i][1]+"</h3><br>";
			 result+="<p>username : "+jsonArray.result[i][0]+"</p><br>";
			 result+="<p>email : "+ jsonArray.result[i][3]+"</p><br>";
			 result+="<p>Mobile : "+ jsonArray.result[i][4]+"</p><br>";
			 result+="<p>Address : "+ jsonArray.result[i][5]+"</p><br>";
			 result+="<p>Province : "+ jsonArray.result[i][6]+"</p><br>";
			 result+="<p>State : "+ jsonArray.result[i][7]+"</p><br>";
			 result+="<p>Postal Code : "+ jsonArray.result[i][8]+"</p><br>";
			 result+="<p>Jumlah Transaksi : "+ jsonArray.result[i][9]+"</p><br>";
			 result+="<a href='editprofile.jsp'> Edit Profile </a>"; 
		}
		container.innerHTML = result;
	});
}
</script>
<div id="profileContent">
<script>
window.onload= getProfileContent();
</script>
</div>
<%
//KALO UDAH BISA LOGIN INI DIBUKA
//if((sesi== null)|| (sesi.getAttribute("username")==null))
//	out.print("<script>window.location='register.jsp';</script>");
%>
<%@ include file= "./footer.jsp" %>