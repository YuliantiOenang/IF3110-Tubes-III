<%-- 
    Document   : index
    Created on : Nov 26, 2013, 3:54:55 PM
    Author     : A46CB
--%>

<%@ page import="myfunction.function" %>
<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Home"/> 
</jsp:include> 

<div class="section products latest">

			<div class="wrapper">

				<h2>Top Snack</h2>
				<ul class="products">
					<%
						String list_view_html = "";
						String cat = "snack";
                                                function ff = new function();
						list_view_html = ff.get_list_product(cat) + list_view_html;
						//out.print(list_view_html);
					%>	
                                        <%= list_view_html %>
                                        
				</ul>

				<h2>Top Minuman</h2>
				<ul class="products">
					<%
						list_view_html = "";
						cat = "minuman";
                                                
						list_view_html = ff.get_list_product(cat) + list_view_html;
						//out.print(list_view_html);
					%>	
                                        	
                                        <%= list_view_html %>
				</ul>

				<h2>Top Makanan</h2>
				<ul class="products">
					<%
						list_view_html = "";
						cat = "makanan";
                                                
						list_view_html = ff.get_list_product(cat) + list_view_html;
						//out.print(list_view_html);
					%>
                                        	
                                        <%= list_view_html %>
				</ul>
				<h2>Top Properti</h2>
				<ul class="products">
					<%
						list_view_html = "";
						cat = "properti";
                                                
						list_view_html = ff.get_list_product(cat) + list_view_html;
						//out.print(list_view_html);
					%>	
                                        	
                                        <%= list_view_html %>
				</ul>
				<h2>Top Buah</h2>
				<ul class="products">
					<%
						list_view_html = "";
						cat = "buah";
                                                
						list_view_html = ff.get_list_product(cat) + list_view_html;
						//out.print(list_view_html);
					%>		
                                        <%= list_view_html %>							
				</ul>
			

			</div>

		</div>

<%@include file="footer.jsp" %>
