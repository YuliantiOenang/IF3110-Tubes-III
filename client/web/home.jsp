<%-- 
    Document   : home
    Created on : Nov 26, 2013, 7:33:48 AM
    Author     : ize
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="ruserba.services.RuserbaServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<h3 class='judul_halaman'>Barang terpopuler</h3>

<%
    JSONObject kategori = RuserbaServices.GetKategori();
    for (int j=0; j < kategori.getInt("length"); j++) {
        JSONObject result = kategori.getJSONObject(""+j);
%>
<div class='category_container'>
    <span class='category'>
        <img src='assets/icon_recommend.png' height='16'/> <a href='/ruserba/kategori/<%= result.getInt("id_kategori") %>'><%= result.getString("nama_kategori") %></a>
    </span><br/><br/>
    <div class='barang_container'>
        <%
            JSONObject json = RuserbaServices.GetBarangByKategori(result.getInt("id_kategori"),3,0,"dibeli",1);
            for(int i=0; i < json.getInt("length"); i++) {
                JSONObject barang = json.getJSONObject("" + i);
        %>
        <div class='barang'>
            <a href='/ruserba/barang/<%= barang.getInt("id_barang") %>'>
                <img src='/ruserba/assets/barang/<%= barang.getString("gambar") %>' height='100%'/>
            </a><br/>
            <span class='barang_nama'>
                <a href='/ruserba/barang/<%= barang.getInt("id_barang") %>'><%= barang.getString("nama_barang") %></a>
            </span><br/>
            <span class='barang_tersedia'>
                <%
                    int tersedia = barang.getInt("tersedia");
                    if (tersedia == 0) {
                        out.println("Barang tidak tersedia");
                    }
                    else {
                        out.println("Barang tersedia (" + barang.getInt("tersedia") + " unit)");
                    }
                %>
            </span><br/>
            <span class='barang_harga'>Rp <%= barang.getInt("harga_barang") %>,00</span><br/>
        </div>
        <%
            }
        %>
        <br/><br/>
    </div>
</div>
<hr/>
<%
    }
%>
<h3>Mekanisme Belanja</h3>
<p>Mekanisme pembelian di RuSerBa :
<ol>
        <li> Login sebagai pengguna. Jika belum punya akun silahkan <a href="register">register</a>. </li>
        <li> Pilih barang-barang yang akan dibeli. Barang akan masuk ke shopping bag.</li>
        <li> Masuk ke shopping bag, klik tombol beli.</li>
        <li> Masukan data kartu kredit anda.</li>
        <li> Barang anda akan dikirim ke alamat anda.</li>
</ol><p>