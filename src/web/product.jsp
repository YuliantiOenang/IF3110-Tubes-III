<%-- 
    Document   : product
    Created on : Nov 27, 2013, 4:56:10 PM
    Author     : A46CB
--%>

<%@ page import="myfunction.function" %>
<%@ page import="myfunction.product" %>
<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Produk"/> 
</jsp:include> 

<% int id = Integer.parseInt(request.getParameter("id")); 
    product produk = new product();
    function func = new function();
    produk = func.getProduct(id);
%>
<div class="section products page">

			<div class="wrapper">
                            <% 
                                    if (session.getAttribute("user") != null) {
                                        String therole = (String) session.getAttribute("role");
                                                if(therole.equals("admin")) {
                                            %>
                                            <a href="delete?id=<%= id %>">Delete this product</a>   
                                            <% }} %>
<hr />
				<div class="breadcrumb"><a href="products.jsp?category=<%= produk.kategori %>" ><%= produk.kategori %></a> &gt; <%= produk.nama %></div>

				<div class="product-picture">
					<span>
						<img src="<%= produk.image %>" alt="<%= produk.nama %>">
					</span>
				</div>

				<div class="product-details">

					<h1> <%= produk.nama %></h1>
					<h2><span class="price">Harga : Rp <%= produk.harga %></span></h2>
					<h2>Stok : <%= produk.stok %></h2>
					<h2>Keterangan : </h2><p><%= produk.keterangan %></p>


				</div>


			</div>

		</div>

<%@include file="footer.jsp" %>
