<%-- 
    Document   : search
    Created on : Nov 26, 2013, 10:03:55 PM
    Author     : ize
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="ruserba.database.DatabaseHelper"%>
<%@page import="java.sql.ResultSet"%>
<script src='/ruserba/js/addtocart.js'></script>
<%
    String q = URLDecoder.decode(request.getParameter("q"), "UTF-8");
    String query = "select * from barang left join kategori on barang.id_kategori=kategori.id_kategori where nama_barang like '%" + q + "%' or nama_kategori like '%" + q + "%' or harga_barang='" + q + "'";
    DatabaseHelper.Connect();
    ResultSet result = DatabaseHelper.executeQuery(query);
    int total = 0;
    while (result.next()) {
        ++total;
    }
    int limit = 10;
    int pageNum = 1;
    if (request.getParameter("p") != null) {
        pageNum = Integer.parseInt(request.getParameter("p"));
    }
    int mulai = limit * (pageNum - 1);
    query = "select * from barang left join kategori on barang.id_kategori=kategori.id_kategori where nama_barang like '%" + q + "%' or nama_kategori like '%" + q + "%' or harga_barang='" + q + "' order by nama_barang limit " + mulai + ", " + limit;
    int jumlah = 0;
    result = DatabaseHelper.executeQuery(query);
    while (result.next()) {
        ++jumlah;
    }
%>
<h3 class='judul_halaman'>Hasil pencarian untuk: <%= q %> (<%= mulai + 1 %>-<%= mulai + jumlah %> dari <%= total %> hasil)</h3>
<%
    result = DatabaseHelper.executeQuery(query);
    while (result.next()) {
%>
<div class='halaman_category_container'>
    <div class='barang_container'>
        <div class='barang'>
            <a href='/ruserba/barang/<%= result.getInt("id_barang") %>'>
                <img src='/ruserba/assets/barang/<%= result.getString("gambar") %>' height='100%'/>
            </a>
        </div>
        <div class='barang'>
            <span class='barang_nama'>
                <a href='/ruserba/barang/<%= result.getInt("id_barang") %>'><%= result.getString("nama_barang") %></a><br/>
                Kategori: <a href='/ruserba/kategori/<%= result.getInt("id_kategori") %>'><%= result.getString("nama_kategori") %></a>
            </span><br/>
            <span class='barang_tersedia'>
                <%
                    int tersedia = result.getInt("tersedia");
                    if (tersedia == 0) {
                        out.println("Barang tidak tersedia");
                    }
                    else {
                        out.println("Barang tersedia (" + result.getInt("tersedia") + " unit)");
                    }
                %>
            </span><br/>
            <span class='barang_harga'>Rp <%= result.getInt("harga_barang") %>,00</span><br/>
        </div>
        <%
            if (tersedia > 0) {
        %>
        <a class='button beli' name='<%= result.getString("id_barang") %>' href='javascript:void(0)'><div>Pesan Barang</div></a>
        <%
            }
        %>
    </div>
</div><hr/>
<%
    }
    int banyakHalaman = (int) Math.ceil((double) total / (double) limit);
    out.println(total);
    if (banyakHalaman > 1) {
%>
<div class='paginasi'>
    Halaman: 
    <%
        for (int i = 1; i <= banyakHalaman; i++) {
            if (pageNum != i) {
    %>
    <a href='/ruserba/search/<%= q %>/<%= i %>'>[<%= i %>]</a>
    <%
            }
            else {
    %>
    [<%= i %>]
    <%
            }
        }
    %>
</div>
<%
    }
    result.close();
    DatabaseHelper.Disconnect();
%>