<%@ page import="com.ruserba.web.WebUtil" %>
<%@ page import="com.ruserba.model.Database" %>
<%@ page import="com.ruserba.model.Category" %>
<%@ page import="com.ruserba.model.Product" %>
<%@ page import="com.ruserba.model.SearchAttribute" %>
<%@ page import="java.util.ArrayList" %>

<% request.setAttribute("page_title", "RuSerBa - Hasil Pencarian"); %>
<% request.setAttribute("css_file", "styles/browse_product.css"); %>
<jsp:include page="/WEB-INF/jsp/begin.jsp" />

<%
	Database db = WebUtil.getDatabase(getServletContext());

	String product_name = request.getParameter("product_name");
	if (product_name == null) product_name = "";

	String category_id_str = request.getParameter("category_id");
	int category_id;
	if (category_id_str == null) category_id = 0;
	else category_id = Integer.parseInt(category_id_str);

	String price_str = request.getParameter("price");
	int price;
	if (price_str == null || price_str.equals("")) price = -1;
	else price = Integer.parseInt(price_str);

	String price_comparison_str = request.getParameter("price_comparison");
	int price_comparison;
	if (price_comparison_str == null) price_comparison = 0;
	else price_comparison = Integer.parseInt(price_comparison_str);

	String sort_category_id_str = request.getParameter("sort_category_id");
	int sort_category_id;
	if (sort_category_id_str == null) sort_category_id = 1;
	else sort_category_id = Integer.parseInt(sort_category_id_str);

	String sort_method_str = request.getParameter("sort_method");
	int sort_method;
	if (sort_method_str == null) sort_method = 1;
	else sort_method = Integer.parseInt(sort_method_str);
%>

<h1>Hasil Pencarian</h1>

<div id="categorysortdiv">
<form action="search.jsp" method="GET">
	<label for="sort_category_select">Urutkan berdasarkan</label>
	<input type="hidden" name="product_name" value="<%= product_name %>" />
	<input type="hidden" name="category_id" value="<%= category_id %>" />
	<input type="hidden" name="price" value="<%= price %>" />
	<input type="hidden" name="price_comparison" value="<%= price_comparison %>" />
	<select name="sort_category_id" id="sort_category_select">
		<option value="1" <% if (sort_category_id == 1) out.write("selected"); %>>Nama produk</option>
		<option value="2" <% if (sort_category_id == 2) out.write("selected"); %>>Harga produk</option>
	</select>
	<select name="sort_method">
		<option value="1" <% if (sort_method == 1) out.write("selected"); %>>Ascending</option>
		<option value="2" <% if (sort_method == 2) out.write("selected"); %>>Descending</option>
	</select>
	<input type="submit" value="Go" />
</form>
</div>

<%
	SearchAttribute attr = new SearchAttribute();

	attr.setNamaBarang(product_name);
	attr.setIdKategori(category_id);
	attr.setHarga(price);
	attr.setIdPerbandingan(price_comparison);
	attr.setIdPengurutan(sort_category_id);
	attr.setIdMetodePengurutan(sort_method);
	attr.setIndeks(0);
	attr.setJumlah(-1);

	ArrayList<Product> prod_lst = db.getProductSearchResult(attr);

	out.write("<div class=\"browseproduct\">");
	for (int j = 0; j < prod_lst.size(); j++)
	{
		request.setAttribute("produk", prod_lst.get(j));
		%>
		<jsp:include page="/WEB-INF/jsp/product_category.jsp" />
		<%
	}
	out.write("</div>");
%>

<jsp:include page="/WEB-INF/jsp/end.jsp" />
