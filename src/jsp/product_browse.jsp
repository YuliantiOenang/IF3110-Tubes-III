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
		Total penjualan: <%= produk.getJumlahPembelian() %> unit
	</span>
</div>
