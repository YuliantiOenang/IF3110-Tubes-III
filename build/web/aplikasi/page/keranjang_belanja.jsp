<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.if3110.web.DBConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.text.NumberFormat"%>
<%@include file="/include/header.jsp" %>
<%! public static String HOME_URL = "http://localhost:8080/tugas_web2/"; %>
<%
    JSONObject keranjang = (JSONObject) request.getAttribute("keranjang");
%>
<form id="shopping_bag" class="table sbtable">
    <div class="row thead">
        <span class="column">Gambar</span>
        <span class="column">Nama barang / Permintaan</span>
        <span class="column">Qty</span>
        <span class="column">Harga per Unit</span>
        <span class="column">Harga Total</span>
    </div>
    <% if(keranjang != null) {
        JSONArray json_array = keranjang.getJSONArray("data");
        JSONObject barang;
         for(Integer i = 0; i < json_array.length(); i++) {
             barang = json_array.getJSONObject(i);
    %>
    <div class="row tcontent">
        <span class="column"><img src="<% if(barang.getString("image_url") == "" || barang.getString("image_url") == null) out.print(HOME_URL+"assets/image/default.png"); else out.print(HOME_URL+URLDecoder.decode(barang.getString("image_url"),"UTF-8")); %>" alt="<%= barang.getString("nama") %>" width="100" height="100"></span>
        <span class="column">
            <a href="<%= HOME_URL+"barang/"+barang.getString("barang_id") %>"><%= barang.getString("nama") %></a>
            <p><%= barang.getString("deskripsi") %></p><% if(barang.getString("detail_tambahan") != null) out.print("<p><b>Detail tambahan:</b> "+barang.getString("detail_tambahan")+"</p>"); %>
        </span>
        <span class="column"><input type="text" name="qty_<%= barang.getInt("barang_id") %>" value="<%= barang.getInt("qty") %>"></span>
        <span class="column">Rp. <% out.print(NumberFormat.getInstance(Locale.GERMANY).format(Float.valueOf(barang.getString("harga")))); %></span>
        <span class="column">Rp. <% out.print(NumberFormat.getInstance(Locale.GERMANY).format(Float.valueOf(barang.getString("harga")) * barang.getInt("qty"))); %></span>
    </div>
    <% } %>
    <div class="row">
        <span class="column"></span>
        <span class="column"></span>
        <span class="column"></span>
        <span class="column"></span>
        <span class="column">Total: Rp. <% out.println(NumberFormat.getInstance(Locale.GERMANY).format(keranjang.getDouble("total"))); %><p><input type="button" value="Simpan" onClick="saveToShoppingBag()"><input type="button" value="Beli" onClick="checkIsCard()"></p></span>
    </div>
    <% } else { %>
    <p>Tidak ada barang di keranjang</p>
    <% } %>
</form>
<%@include file="/include/footer.jsp" %>