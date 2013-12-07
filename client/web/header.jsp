<%-- 
    Document   : header
    Created on : Nov 25, 2013, 8:10:48 PM
    Author     : ize
--%>

<%@page import="org.omg.CORBA.INTERNAL"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src='/ruserba/js/session.js'></script>
<script src='/ruserba/js/search.js'></script>
<div id='logo'>
    <a href='/ruserba'><img src='/ruserba/assets/logo.png' /></a>
</div>
<div id='loggedout'>
    <a id='loginbutton' class='button' href='javascript:void(0)'><div>Masuk</div></a>
    <form id='loginform' method='post'>
        Username<input type='text' name='loginuser' /><br /><br />
        Kata sandi<input type='password' name='loginpass' /><br /><br />
        <span id='loginerror'>Username atau kata sandi salah</span>
        <input type='submit' name='loginsubmit' />
        <a id='loginsubmit' class='button' name='loginsubmit' href='javascript:void(0)'><div>Masuk</div></a>
        <br />
    </form>
    <a id='registerbutton' class='button' href='javascript:void(0)'><div>Daftar</div></a>
</div>
<div id='loggedin'>
    <div id='welcome'>Selamat datang, <a id='user'></a>!</div>
    <a id='logoutbutton' class='button' href='javascript:void(0)'><div>Keluar</div></a>
    <br />
    <a id='cartbutton' class='button' href='/ruserba/cart'><div>
        <img src='/ruserba/assets/cart.png' />
        <span id='totalbarang'>
            <%! int total = 0; %>
            <%
                HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
                if (cart != null && cart.isEmpty()) {
                    for (Entry<String, Integer> entry : cart.entrySet()) {
                        total += entry.getValue().intValue();
                    }
                }
            %>
            <%= total %>
        </span> barang
    </div></a>
</div>
<div id='searchbar'>
    <form id='searchform' method='post'>
        <input type='text' name='searchinput' placeholder='Cari' />
        <input type='submit' name='searchsubmit' />
        <a id='searchbutton' href='javascript:void(0)'><img src="/ruserba/assets/search.png" /></a>
    </form>
</div>
