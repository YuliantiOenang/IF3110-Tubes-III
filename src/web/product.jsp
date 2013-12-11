<%@ page import="com.ruserba.web.WebUtil" %>
<%@ page import="com.ruserba.model.Database" %>
<%@ page import="com.ruserba.model.Category" %>
<%@ page import="com.ruserba.model.Product" %>
<%@ page import="com.ruserba.model.SearchAttribute" %>
<%@ page import="java.util.ArrayList" %>

<% request.setAttribute("page_title", "RuSerBa - Informasi Produk"); %>
<% request.setAttribute("js_file", "scripts/product.js"); %>
<jsp:include page="/WEB-INF/jsp/begin.jsp" />

<%
	Database db = WebUtil.getDatabase(getServletContext());
	Product produk = db.getProductData(Integer.parseInt(request.getParameter("product_id")));
%>

<p id="gambar">
<img src="<%= WebUtil.getProductImagePath(produk.getNamaGambar()) %>" alt="gambar_product" />
</p>
<div id="detail_product">
<p>
<h2><%= produk.getNamaBarang() %></h2>
</p>
<p>
<%= produk.getDeskripsi() %>
<br></br>
</p>
<p>
Harga: Rp<%= produk.getHarga() %>,- / <%= produk.getSatuan() %>
</p>
<p>
Sisa stok: <span id="jumlahstok"><%= produk.getJumlahStok() %></span>
</p>
<p>
Jumlah beli: <input id="jumlahproduk" name="text" name="jumlah_product" />
</p>
<p>
Keterangan: 
<br></br>
<textarea name="comment" id="keteranganproduk" rows="5" cols="40"></textarea>
</p>
<p>
<button id="buybutton" type="submit" >Beli</button>
</p>
<p id="errorjumlah"></p>
</div>

<?php
	require_once('end.php');
?>
