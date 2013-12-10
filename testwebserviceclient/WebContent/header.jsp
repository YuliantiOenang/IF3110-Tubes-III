<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/AJS_style.css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/modal.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/verify.js"></script>
<script type="text/javascript" src="login.js"></script>
<script src='${pageContext.request.contextPath}/ajax.js'></script>
<script type="text/javascript">
var kategori=new Array("Pangan", "Pakaian", "Elektronik", "Rangga", "Olahraga");
function getKategori(){
	var query = "SELECT DISTINCT kategori_barang FROM barang";
	var kategorilist = document.getElementById("kategorilist");
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		var result="";
		for (var i = 0; i < jsonArray.result.length; i++) {
			result += kategori[jsonArray.result[i]-1] + "</br>"; 
		}
		kategorilist.innerHTML = result;
	});
}

function getWelcome(){
	/*var query = "SELECT DISTINCT kategori_barang FROM barang";
	var DIV = document.getElementById("AJS_header");
	sendQuery(query, function() {
		var jsonArray = JSON.parse(xmlhttp.responseText);
		var result="";
		for (var i = 0; i < jsonArray.result.length; i++) {
			result += kategori[jsonArray.result[i]-1] + "</br>"; 
		}
		DIV.innerHTML = "ASDASDAS";
	});*/
}
function getNavbar(){
	
}
</script>
<title>RuserBa</title>
</head>
<body onload='getKategori();getWelcome();getNavbar()'>
<div id="AJS_body_wrapper">
	<div id="AJS_wrapper">
		<div id="AJS_header">
		</div>
		<div id="AJS_menubar">
			<div id="top_nav" class="ddsmoothmenu">
				<ul id="customnavbar">
					<script>
						getNavbar();
					</script>
				</ul>
				<br style="clear: left" />
			</div> <!-- end of ddsmoothmenu -->	
    	</div> <!-- END of AJS_menubar -->
		<a href="#x" class="overlay" id="login_form" ></a>
        <div class="popup">
            <h2>Welcome Guest!</h2>
            <p>Please enter your login and password here</p>
            <form name="login" action="javascript:verLogin();" method="GET">
	            
	                Username : <input type="text" name="username"><br>
	                Password : <input type="password" name="password"><br>
	                <div id="err_login"></div><br>
	            	<input type="submit" value="Log In" />
	        </form>
            <a class="close" href="#close"></a>
        </div>
        
<div id="AJS_main">
	<div id="sidebar" class="float_r">
		<div class="sidebar_box"><span class="bottom"></span>
			<h3>Search Option : </h3>
	        		<form name="search" action="search.jsp" method="get">
						<input type="hidden" name="laman" value="1">
						<input type="text" name="searched" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
						<input type="submit" value="Cari" alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
		        		<p>Kategori : </p>
		        		<select name="s_kategori">
							<option value="1">Pangan</option>
							<option value="2">Pakaian</option>
							<option value="3">Elektronik</option>
							<option value="4">Rumah Tangga</option>
							<option value="5">Olah Raga</option>
						</select><br>
						<p>Harga kurang dari : </p>
						<input type="text" name="s_harga" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
					</form>

	            	<h3>Kategori</h3>   
	                	<div class="content"> 
	                	<ul id="kategorilist" class="sidebar_list">
						</ul>
						</div>
		</div>
	</div>
