<%! public static String HOME_URL = "http://localhost/tugas_web2/"; %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ruserba</title>
    <link rel="icon" type="image/png" href="<%= HOME_URL %>assets/favicon.png">
    <link rel="stylesheet" href="<%= HOME_URL %>assets/css/home.css" type="text/css" />
    <link rel="stylesheet" href="<%= HOME_URL %>assets/css/loginpopup.css" type="text/css" />
    <script src="<%= HOME_URL %>assets/ajax_generic.js"></script>
</head>
<body>
    <header>
        <nav><div class="container">
            <span id="login"><a class="menu_cell hyperlink" href="#loginbox">Login</a></span>
            <form id="wbd_search" class="menu_cell" onSubmit="return testA()">
                <input type="text" name="search_input" placeholder="Cari disini">
                <input type="submit" name="submit" value="Cari">
            </form>
            <a id="keranjang_belanja" class="menu_cell hyperlink" href="<%= HOME_URL %>keranjang/">Keranjang Belanja <% if(total_keranjang) != null) { $result = json_decode(total_keranjang, true); out.print("<span id="total_keranjang">"+count($result['data'])+"</span>"); } %></a>
            </div>
        </nav>
        <div class="container">
            <a href="<%= HOME_URL %>"><img id="logo" src="<%= HOME_URL %>assets/logo.png" height="72" alt="Ruko Serba Ada"></a>
        </div>
        <div id="background_cat">
            <img class="background" id='kat1' src="<%= HOME_URL %>assets/img_style/kat1.gif" alt="Kategori 1"/>
            <img class="background" id='kat2' src="<%= HOME_URL %>assets/img_style/kat2.gif" alt="Kategori 1"/>
            <img class="background" id='kat3' src="<%= HOME_URL %>assets/img_style/kat3.gif" alt="Kategori 1"/>
            <img class="background" id='kat4' src="<%= HOME_URL %>assets/img_style/kat4.gif" alt="Kategori 1"/>
            <img class="background" id='kat5' src="<%= HOME_URL %>assets/img_style/kat5.gif" alt="Kategori 1"/>
		</div>
        <div class="kategori_group">
            <a href="<%= HOME_URL %>kat/1/"><img src="<%= HOME_URL %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%= HOME_URL %>kat/2/"><img src="<%= HOME_URL %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%= HOME_URL %>kat/3/"><img src="<%= HOME_URL %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%= HOME_URL %>kat/4/"><img src="<%= HOME_URL %>assets/img_style/klik.gif" alt="Klik"/></a>
            <a href="<%= HOME_URL %>kat/5/"><img src="<%= HOME_URL %>assets/img_style/klik.gif" alt="Klik"/></a>
        </div>
    </header>
    <article class="container">