<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.io.PrintWriter" %>
    
<aside id="sidebar" class="body">
	<p>Selamat datang!</p>
	<div id="s_bar">Silakan pilih barang belanjaan Anda! :)</div>
</aside>
<script src="javascript/transaksi.js"></script>
<script>
function sideBar()
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
		  	var currentpage=1;
			var shopping_bag = [];
			var sum_item = parseInt(xmlhttp.responseText);
			var maxpage= (sum_item/10+1);
			var isi,buyitem;
			initialize_bag();
	    }
	 }
	xmlhttp.open("GET","webservice?url=http://dichbar.ap01.aws.af.cm/sidebar?type=plain&type=plain",true);
	xmlhttp.send();
}
if(localStorage.wbduser){
sideBar();	
}
</script>
