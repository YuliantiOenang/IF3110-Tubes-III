<%-- 
    Document   : cart
    Created on : Dec 7, 2013, 11:16:59 AM
    Author     : Ahmad Fauzan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="ruserba.database.DatabaseHelper"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src='/ruserba/scripts/cart.js'></script>
        <script src='/ruserba/scripts/pay.js'></script>
        <h3 class="judul_halaman">Keranjang Belanja</h3>
        <br/>
        <br/>
        <br/>
        <div id='detailkeranjang'>
            <%
                int total = 0;
                if (session.getAttribute("cart") == null || ((HashMap<String, Integer>) session.getAttribute("cart")).size() == 0) {
            %>
            Tidak ada barang dalam keranjang.
            <%	} else {

            %>
            <%
                HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
                for (Entry<String, Integer> entry : cart.entrySet()) {
                    String query = "select * from barang left join kategori on barang.id_kategori=kategori.id_kategori where id_barang="
                            + entry.getKey();
                    DatabaseHelper.Connect();
                    ResultSet barang = DatabaseHelper.executeQuery(query);
                    barang.next();
            %>
            <div class="halaman_category_container">
                <div class="barang_container">
                    <div class="barang">';
                        <a href="/ruserba/barang/<%= barang.getString("id_barang")%>">
                            <img src="/ruserba/assets/barang/<%= barang.getString("gambar")%>" height="100%"/>
                        </a>
                    </div>
                    <div class="barang">
                        <span class="barang_nama">
                            <a href="/ruserba/barang/<%= barang.getString("id_barang")%>">
                                <%= barang.getString("name_barang")%>
                            </a>
                            <br/>
                            Kategori: 
                            <a href="/ruserba/kategori/'.$barang['id_kategori'].'">
                                <%= barang.getString("nama_kategori")%>
                            </a>
                        </span>
                        <br/>
                        <% if (barang.getInt("tersedia") == 0) {%>
                        <span class="barang_tersedia">';
                            Tidak tersedia
                        </span>
                        <br>
                        <%} else {%>
                        <span class="barang_tersedia">
                            Tersedia <%= barang.getInt("tersedia")%> 	unit';
                        </span>
                        <br>
                        <% }%>
                        <br/>
                        <span class="barang_harga">
                            Rp <span id="harga_<%= barang.getString("id_barang")%>"><%= barang.getString("harga_barang")%></span>,00';
                        </span>
                        <br/>
                    </div>
                    Jumlah
                    <input type="number" class="inputjumlah" name="<%= barang.getString("id_barang")%>" value="'.$amount.'" min="0" max="<%= barang.getString("tersedia")%>" />';
                    <br/>
                    <%
                        int subtotal = entry.getValue() * barang.getInt("harga_barang");
                    %>
                    <h5>Subtotal: Rp <span id="subtotal_<%= barang.getString("id_barang")%>"><%= subtotal%></span>,00</h5>';
                </div>
            </div>
            <hr>
            <% total += subtotal;
                    }
                }
            %>
        </div>
        <div id='totalkeranjang'>
            <h3>Total:</h3>
            <h2>
                Rp <span id='angkatotal'>
                    <%= total%>
                </span>,00
            </h2>
            <br />
            <%
                if (total > 0) {
            %>
            <a class='button' name='bayar' href='javascript:void(0)'><div>Bayar</div></a>
            <% }%>
        </div>
    </body>
</html>
