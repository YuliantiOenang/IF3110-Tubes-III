<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>RuSerBa</title>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
</head>
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<%@ include file="header.jsp" %>
	<article id="featured" class="body">
	<form method="post" action="webservice?url=http://dichbar.ap01.aws.af.cm/editbarang&type=html">
		<h2>Edit</h2>
		<div id="editbarangform">
		</div>
		<script>
			initpage();
		</script>
		<input type="submit" value="Edit">
	</form>
	</article><!-- /#featured -->
	<%@ include file="footer.jsp" %>
	</div>
</body>

<script>

function geteditbarangform()
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
	    	document.getElementById("editbarangform").innerHTML = xmlhttp.responseText;	
	    	//alert(xmlhttp.responseText);
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/editbarangservlet?id=<%=request.getParameter("id") %>&type=html",true);
	xmlhttp.send();
}

function initpage()
{
	var i;
	for (i = 0; i < 10; i++)
	{
		geteditbarangform();
	}
}

initpage();

</script>

</html>