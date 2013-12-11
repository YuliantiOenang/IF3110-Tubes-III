<%-- 
    Document   : products
    Created on : Nov 27, 2013, 4:18:12 PM
    Author     : A46CB
--%>

<%@ page import="myfunction.function" %>
<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Produk"/> 
</jsp:include> 

<div class="section products page">

			<div class="wrapper">

				<h1>Daftar Produk <%= request.getParameter("category") %></h1>

				<ul class="products">
					<%
						String list_view_html = "";
						String cat = request.getParameter("category");
                                                function ff = new function();
						list_view_html = ff.getAllProducts(cat) + list_view_html;
						//out.print(list_view_html);
					%>	
                                        <%= list_view_html %>								
				</ul>

			</div>

		</div>

<%@include file="footer.jsp" %>