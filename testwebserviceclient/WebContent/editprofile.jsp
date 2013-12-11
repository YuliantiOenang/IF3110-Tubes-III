<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script type="text/javascript" src="verify2.js"></script>
<script type="text/javascript">
function getProfileContent() {
	//KALO UDAH BISA LOGIN, GANTI ADMIN JADI USERNAME DARI SESSIONNYA
	var query = "SELECT * FROM user WHERE username ='admin'";
	var container = document.getElementById("profileContent");
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		var result="";
		for (var i = 0; i < jsonArray.result.length; i++) {
			result+= "<form name='edit' action='javascript:verifRegis();' method='post'>";
			result+= "Change Password: <input type='password' onkeyup='checkPass(this)' name='password' value='"+ jsonArray.result[i][2]+"'><div id='err_pass'></div><br>";
			result+= "Confirm Password: <input type='password' onkeyup='confirmPassword(this)' name='repassword' value='"+ jsonArray.result[i][2]+"'><div id='err_repass'></div><br>";
			result+= "Nama Lengkap: <input type='text' name='fullname' onkeyup='checkFullName(this)' value='"+ jsonArray.result[i][1]+"'><div id='err_fullname'></div><br>";
			result+= "Nomor Hand Phone: <input type='text' name='hpnum' value='"+ jsonArray.result[i][4]+"'><br>";
			result+= "Alamat : <input type='text' name='address' value='"+ jsonArray.result[i][5]+"'><br>";
			result+= "Provinsi : <input type='text' name='province' value='"+ jsonArray.result[i][6]+"'><br>"
			result+= "Kecamatan : <input type='text' name='kecamatan' value='"+ jsonArray.result[i][7]+"'><br>";
			result+= "Kode Pos : <input type='text' name='postalcode' value='"+ jsonArray.result[i][8]+"'><br>";
			result+= "<input type='hidden' name='username' value='"+ jsonArray.result[i][0]+"'>";
			result+= "<input type='hidden' name='Email' value='"+ jsonArray.result[i][3]+"'>";
			result+= "<input type='submit' id='subedit' value='Edit'>";
			result+= "<div id='edit_error'></div>";
			result+= "</form>";
		}
		container.innerHTML = result;
	});
}
</script>
<div id="profileContent">
<script>
	getProfileContent();
</script>
</div>
<%@ include file= "./footer.jsp" %>