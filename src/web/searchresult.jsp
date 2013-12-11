<%-- 
    Document   : search
    Created on : Nov 27, 2013, 9:23:51 PM
    Author     : A46CB
--%>

<%@ page import="myfunction.function" %>
<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Produk"/> 
</jsp:include> 

<div class="section">

			<div class="wrapper">

				<h1>Search Result</h1>

				<ul>
					<%
						String list_view_html = "";
						String cat = request.getParameter("keyword");
                                                function ff = new function();
						list_view_html = ff.search(cat) + list_view_html;
						//out.print(list_view_html);
					%>	
                                        <%= list_view_html %>								
				</ul>

			</div>

		</div>

<%@include file="footer.jsp" %>