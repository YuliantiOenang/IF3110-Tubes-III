<%-- 
    Document   : kategori
    Created on : Dec 7, 2013, 12:49:28 PM
    Author     : Ahmad Fauzan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="ruserba.database.DatabaseHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src='/ruserba/scripts/sort.js'></script>
        <script src='/ruserba/scripts/addtocart.js'></script>
    </head>
    <body>

        <%
            //mencari banyak data yang ada dalam tabel
            String id_kategori = request.getParameter("id");
            String query = "select nama_kategori from kategori where id_kategori=" + id_kategori;
            DatabaseHelper.Connect();
            ResultSet result = DatabaseHelper.executeQuery(query);
            result.next();
        %>
        <h3 class="judul_halaman">Kategori: 
            <%= result.getString("nama_kategori")%>
        </h3>
        <%
            query = "select * from barang where id_kategori=" + id_kategori;
            ResultSet barangs = DatabaseHelper.executeQuery(query);
            int banyakBarang = barangs.getRow();
            int pages = 1;
            if (request.getParameter("p") != null && request.getParameter("p") != "") {
                pages = Integer.parseInt(request.getParameter("p"));
            }
            int limit = 10;
            int mulai_dari = limit * (pages - 1);
        %>
        <div id="dropdownsort">
            <%
                query = "select * from barang where id_kategori=" + id_kategori + " order by ";
            %>
            Urutkan berdasarkan
            <select id="selectorder">
                <%
                    if (request.getParameter("orderby") == null
                            || (request.getParameter("orderby").equalsIgnoreCase("name"))) {
                %>
                <option selected=true>Nama</option>
                <option>Harga</option>
                <% query += "nama_barang ";%>
                <%
                } else if (request.getParameter("orderby") != null
                        || (request.getParameter("orderby").equalsIgnoreCase("price"))) {
                %>
                <option>Nama</option>
                <option selected=true>Harga</option>
                <% query += "harga_barang ";%>
                <% }%>
            </select>
            <select id="selectsort">
                <% if (request.getParameter("sort") == null
                        || request.getParameter("sort").equalsIgnoreCase("asc")) {%>
                <option selected=true>Membesar</option>
                <option>Mengecil</option>
                <% query += "asc ";%>
                <% } else if (request.getParameter("sort").equalsIgnoreCase("desc")) {%>
                <option>Membesar</option>
                <option selected=true>Mengecil</option>
                <% query += "desc ";%>
                <%}%>
                <% query += "limit " + mulai_dari + "," + limit;%>
            </select>
        </div>
        <br/>
        <br/>
        <%
            barangs = DatabaseHelper.executeQuery(query);
            while (barangs.next()) {
        %>
        <div class="halaman_category_container">
            <div class="barang_container">
                <div class="barang">
                    <a href="/ruserba/barang/<%= barangs.getString("id_barang")%>">
                        <img src="/ruserba/assets/barang/<%= barangs.getString("gambar")%>" height="100%"/>
                    </a>
                </div>
                <div class="barang">
                    <span class="barang_nama">
                        <a href="/ruserba/barang/<%= barangs.getString("id_barang")%>">
                            <%= barangs.getString("nama_barang")%>
                        </a>
                    </span>
                    <br>
                    <%
                        if (barangs.getInt("tersedia") == 0) {
                    %>
                    <span class="barang_tersedia">
                        Barang tidak tersedia
                    </span>
                    <br>
                    <% } else {%>
                    <span class="barang_tersedia">
                        Barang tersedia (<%= barangs.getInt("tersedia")%> 	unit)
                    </span>
                    <br>
                    <% }%>
                    <span class="barang_harga">
                        Rp <%= barangs.getString("harga_barang")%>,00
                    </span>
                    <br>
                </div>
                <% if (barangs.getInt("tersedia") > 0) {%>
                <a class="button beli" name="<%= barangs.getString("id_barang")%>" href="javascript:void(0)"><div>Pesan Barang</div></a>
                <% }%>
            </div>
        </div>
        <hr>
        <% }%>  
        <%
            int banyakHalaman = (int) Math.ceil(banyakBarang / limit);
            if (banyakHalaman > 1) {%>
        <div class="paginasi">
            Halaman:
            <%
                for (int i = 1; i <= banyakHalaman; i++) {
                    if (pages != i) {
            %>
            <a href="/ruserba/kategori/<%= id_kategori%>/<%= i%>">[<%= i%>]</a>  
            <%} else {%>
            [<%= i%>]   
            <%}
                            }%>
        </div>
        <%
            }
        %>  
    </body>
</html>
