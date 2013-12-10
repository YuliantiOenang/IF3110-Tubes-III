<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="koneksi.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saving image...</title>
<span id="saveReport"></span>
<script>
function savingImg()
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    	document.getElementById("saveReport").innerHTML = xmlhttp.responseText;
	    	
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/savingImage&type=html",true);
	xmlhttp.send();
}
</script>
</head>
<body onLoad="setTimeout('delay()', 500)">
<form action="updatedb.jsp" method="GET">
<input type="hidden" name="username" id="username">
<input type="hidden" name="filename" id="filename">
<p>Yakin ingin menyimpan foto? </p><input type="submit" value="Ya"> <a href="profile.jsp">Tidak</a>
</form>
<p id="cn"></p>
</body>
</html>