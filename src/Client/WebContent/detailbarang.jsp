<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head><title>Detail Barang</title></head>
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
<%@ include file="header.jsp" %>
<article id="featured" class="body">
	<script>
		initpage();
	</script>
</article>

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
	    	document.getElementById("featured").innerHTML = xmlhttp.responseText;	
	    	//alert(xmlhttp.responseText);
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/detailbarangservlet?id="+<%=request.getParameter("id")%>+"&type=html",true);
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