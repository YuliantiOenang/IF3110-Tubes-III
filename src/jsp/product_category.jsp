<%@ page import="com.ruserba.web.WebUtil" %>

<jsp:useBean id="produk" class="com.ruserba.model.Product" scope="request">
</jsp:useBean>

<div>
<span class="browseproductspan">
	<img src="<%= WebUtil.getProductImagePath(produk.getNamaGambarThumb()) %>" alt="<%= produk.getNamaBarang() %>" />
</span>
<span class="browseproductspan">
	<a href="<%= WebUtil.getProductPage(produk.getIdBarang()) %>"><%= produk.getNamaBarang() %></a><br />Rp <%= produk.getHarga() %>,00 / <%= produk.getSatuan() %>
</span>
<span class="browseproductspan">
	<label for="<%= WebUtil.getProductPage(produk.getIdBarang()) %>_quantity">Jumlah pembelian</label>
	<input type="text" id="<%= WebUtil.getProductPage(produk.getIdBarang()) %>_quantity" />
	<button id="<%= WebUtil.getProductPage(produk.getIdBarang()) %>_button">Beli</button><br />
	<span id="<%= WebUtil.getProductPage(produk.getIdBarang()) %>_message"></span>
</span>
</div>
