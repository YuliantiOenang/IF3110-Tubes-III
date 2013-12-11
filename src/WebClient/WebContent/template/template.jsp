<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="kelas.*"%>

<link rel="stylesheet" href="css/list.css" type="text/css">
<link rel="stylesheet" href="css/homepage.css" type="text/css">   
<link rel="stylesheet" href="css/modal.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Gorditas' rel='stylesheet' type='text/css'>

<%@ include file="../LoginBar.jsp" %>
<a href="home"><img src="res/header.png" height="258px" width="900px"></a><br/>

<div class = "categories">
	<div class = "text_navigation"><a href="showList?cat=roti">Roti</a></div>
	<div class = "text_navigation"><a href="showList?cat=minuman">Minuman</a></div>
	<div class = "text_navigation"><a href="showList?cat=kalengan">Makanan Kalengan</a></div>
	<div class = "text_navigation"><a href="showList?cat=segar">Makanan Segar</a></div>
	<div class = "text_navigation"><a href="showList?cat=peralatan">Peralatan Rumah</a></div>
</div>

<div class="main_navigation">
	<form action="search" method="get">
		<div class='sbox'>
			<div id='sb_name'>Nama:</div><div class='sb_value'><input type="text" name="query_name" size="20" onkeyup="showResult(this.value)"></div>
			<div id='sb_name'>Harga:</div><div class='sb_value'><input type="text" name="query_price" size="20"></div>
			<div id='sb_name'>Kategori:</div><div class='sb_value2'><select name="query_category">	
			  <option value="roti">Roti</option>
			  <option value="minuman">Minuman</option>
			  <option value="kalengan">Makanan Kalengan</option>
			  <option value="segar">Makanan Segar</option>
			  <option value="peralatan">Peralatan Rumah</option>
			</select></div>
			<input class="search_image" type="image" src="res/search.png" width="30px">
		</div>
	</form>
</div>