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
	<input type="hidden" id="p<%= produk.getIdBarang() %>_stock" value=<%= produk.getJumlahStok() %> />
	<label for="p<%= produk.getIdBarang() %>_quantity">Jumlah pembelian</label>
	<input type="text" id="p<%= produk.getIdBarang() %>_quantity" />
	<button id="p<%= produk.getIdBarang() %>_button">Beli</button><br />
	<span id="p<%= produk.getIdBarang() %>_message"></span>
	<script type="text/javascript">
		window.addEventListener("load", function()	{
			document.getElementById("p<%= produk.getIdBarang() %>_button").onclick = function()	{
				var jml_stok = document.getElementById("p<%= produk.getIdBarang() %>_stock").value;
				var jml_beli = document.getElementById("p<%= produk.getIdBarang() %>_quantity").value;
				var msg = document.getElementById("p<%= produk.getIdBarang() %>_message");
				if (jml_beli > jml_stok) msg.innerHTML = getErrorSmall("Stok tidak mencukupi.");
				else	{
					setProductQuantity(<%= produk.getIdBarang() %>, jml_beli);
					msg.innerHTML = getOkSmall("Barang berhasil ditambahkan ke shopping bag.");
				}
			};
			document.getElementById("p<%= produk.getIdBarang() %>_quantity").value = getProductQuantity(<%= produk.getIdBarang() %>);
		});
	</script>
</span>
</div>
