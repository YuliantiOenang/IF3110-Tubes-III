<%-- 
    Document   : home
    Created on : Nov 26, 2013, 7:33:48 AM
    Author     : ize
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="ruserba.database.DatabaseHelper"%>
<h3 class='judul_halaman'>Barang terpopuler</h3>

<%
    String query = "select * from kategori";
    DatabaseHelper.Connect();
    ResultSet result = DatabaseHelper.executeQuery(query);
    while (result.next()) {
%>
<div class='category_container'>
    <span class='category'>
        <img src='assets/icon_recommend.png' height='16'/> <a href='/ruserba/kategori/<%= result.getInt("id_kategori") %>'><%= result.getString("nama_kategori") %></a>
    </span><br/><br/>
    <div class='barang_container'>
        <%
            query = "select * from barang where barang.id_kategori=" + result.getInt("id_kategori") + " order by dibeli desc limit 0, 3";
            ResultSet resultKategori = DatabaseHelper.executeQuery(query);
            while (resultKategori.next()) {
        %>
        <div class='barang'>
            <a href='/ruserba/barang/<%= resultKategori.getInt("id_barang") %>'>
                <img src='/ruserba/assets/barang/<%= resultKategori.getString("gambar") %>' height='100%'/>
            </a><br/>
            <span class='barang_nama'>
                <a href='/ruserba/barang/<%= resultKategori.getInt("id_barang") %>'><%= resultKategori.getString("nama_barang") %></a>
            </span><br/>
            <span class='barang_tersedia'>
                <%
                    int tersedia = resultKategori.getInt("tersedia");
                    if (tersedia == 0) {
                        out.println("Barang tidak tersedia");
                    }
                    else {
                        out.println("Barang tersedia (" + resultKategori.getInt("tersedia") + " unit)");
                    }
                %>
            </span><br/>
            <span class='barang_harga'>Rp <%= resultKategori.getInt("harga_barang") %>,00</span><br/>
        </div>
        <%
            }
            resultKategori.close();
        %>
        <br/><br/>
    </div>
</div>
<hr/>
<%
    }
    result.close();
    DatabaseHelper.Disconnect();
%>