<%!
   String url = "http://localhost:8080/tugas_web2/";
%>
<%-- 
    Document   : header
    Created on : Nov 25, 2013, 3:50:15 PM
    Author     : Setyo Legowo <setyo.legowo@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ruserba</title>
    <link rel="icon" type="image/png" href="<%=url %>assets/favicon.png">
    <link rel="stylesheet" href="<%=url %>assets/css/home.css" type="text/css">
    <link rel="stylesheet" href="<%=url %>assets/css/loginpopup.css" type="text/css">
    <script src="<%=url %>assets/ajax_generic.js"></script>
</head>
<body>
    <header>
        <nav><div class="container">
            <span id="login"><a class="menu_cell hyperlink" href="#loginbox">Login</a></span>
            <form id="wbd_search" class="menu_cell" onSubmit="return testA()">
                <input type="text" name="search_input" placeholder="Cari disini">
                <input type="submit" name="submit" value="Cari">
            </form>
            <a id="keranjang_belanja" class="menu_cell hyperlink" href="<%=url %>keranjang/">Keranjang Belanja</a>
            </div>
        </nav>
        <div class="container">
            <a href="<%=url %>"><img id="logo" src="<%=url %>assets/logo.png" height="72" alt="Ruko Serba Ada"></a>
        </div>
        <div id="background_cat">
            <img class="background" id='kat1' src="<%=url %>assets/img_style/kat1.gif" alt="Kategori 1"/>
            <img class="background" id='kat2' src="<%=url %>assets/img_style/kat2.gif" alt="Kategori 1"/>
            <img class="background" id='kat3' src="<%=url %>assets/img_style/kat3.gif" alt="Kategori 1"/>
            <img class="background" id='kat4' src="<%=url %>assets/img_style/kat4.gif" alt="Kategori 1"/>
            <img class="background" id='kat5' src="<%=url %>assets/img_style/kat5.gif" alt="Kategori 1"/>
		</div>
        <div class="kategori_group">
            <a href="<%=url %>kat/1/"><img src="<%=url %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%=url %>kat/2/"><img src="<%=url %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%=url %>kat/3/"><img src="<%=url %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%=url %>kat/4/"><img src="<%=url %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%=url %>kat/5/"><img src="<%=url %>assets/img_style/klik.gif" alt="Klik"/></a>
        </div>
    </header>
    
    <article class="container">
