<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.if3110.web.DBConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.text.NumberFormat"%>
<%@include file="../../include/header.jsp" %>
<%! public static String HOME_URL = "http://localhost:8080/tugas_web2/"; %>

<div class="kategori">
    <h1><%
        String message = (String) request.getAttribute("nama_kategori");
        out.print(message);
    %></h1>
    <p>
        <a class="sorting" href="?by=nama&amp;sort=asc&amp;page=1">Sorting By Name Ascending</a>
        <a class="sorting" href="?by=nama&amp;sort=desc&amp;page=1">Sorting By Name Descending</a>
        <a class="sorting" href="?by=harga&amp;sort=asc&amp;page=1">Sorting By Price Ascending</a>
        <a class="sorting" href="?by=harga&amp;sort=desc&amp;page=1">Sorting By Price Descending</a>
    </p>
	<p>
            <% Integer size= (Integer) request.getAttribute("page_no"); %>
		<% for(int i = 1; i <= size;i++) {%>
			<% 
				String uri = "?by=nama&amp;sort=desc&amp;page="+i;
			%>
			<a class="sorting" href="<%=uri %>"><%=i %></a>
		<% } %>
	</p>
    <% JSONArray data = (JSONArray) request.getAttribute("data");
       JSONObject barang;
       for(int i = 0; i < data.length(); i++) { 
           barang = data.getJSONObject(i);
    %>
    <div class="box_barang">
        <img class="gambar_barang" src="<% if(barang.getString("image_url") == "" || barang.getString("image_url") == null) out.print(HOME_URL+"assets/image/default.png"); else out.print(HOME_URL+URLDecoder.decode(barang.getString("image_url"),"UTF-8")); %>" alt="<%= barang.getString("nama") %>" height="100" width="100">
        <a href="<%= HOME_URL+"barang/"+barang.getInt("barang_id") %>"><%= barang.getString("nama") %></a>
        <span class="harga">Rp.<% out.print(NumberFormat.getInstance(Locale.GERMANY).format(Float.valueOf(barang.getString("harga")))); %></span>
        <form onSubmit="return addToShoppingChart(this)"><input type="hidden" name="id_barang" value="<%= Integer.toString(barang.getInt("barang_id")) %>"><input type="text" name="qty" onKeyUp="validateQty(this)"><input type="submit" value="+" disabled="disabled"></form>
    </div>
    <% } %>
</div>
<%@include file="../../include/footer.jsp" %>