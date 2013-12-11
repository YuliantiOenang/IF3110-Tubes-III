<%@ page import="com.ruserba.web.WebUtil" %>
<%@ page import="com.ruserba.model.Database" %>
<%@ page import="com.ruserba.model.Category" %>
<%@ page import="com.ruserba.model.Product" %>
<%@ page import="com.ruserba.model.SearchAttribute" %>
<%@ page import="java.util.ArrayList" %>

<% request.setAttribute("page_title", "RuSerBa - Halaman Utama"); %>
<% request.setAttribute("css_file", "styles/browse_product.css"); %>
<jsp:include page="/WEB-INF/jsp/begin.jsp" />

<h1>Produk dengan Pembelian Terbanyak</h1>

<%
	Database db = WebUtil.getDatabase(getServletContext());

	ArrayList<Category> cat_lst = db.getCategory();

	for (int i = 0; i < cat_lst.size(); i++)
	{
		out.write("<h2>" + cat_lst.get(i).getNamaKategori() + "</h2>");

		SearchAttribute attr = new SearchAttribute();

		attr.setNamaBarang("");
		attr.setIdKategori(cat_lst.get(i).getIdKategori());
		attr.setHarga(-1);
		attr.setIdPerbandingan(0);
		attr.setIdPengurutan(Database.ORDERBY_SOLDQTY);
		attr.setIdMetodePengurutan(Database.SORT_DESC);
		attr.setIndeks(0);
		attr.setJumlah(3);

		ArrayList<Product> prod_lst = db.getProductSearchResult(attr);

		out.write("<div class=\"browseproduct\">");
		for (int j = 0; j < prod_lst.size(); j++)
		{
			request.setAttribute("produk", prod_lst.get(j));
			%>
			<jsp:include page="/WEB-INF/jsp/product_browse.jsp" />
			<%
		}
		out.write("</div>");

	}
	
%>

<jsp:include page="/WEB-INF/jsp/end.jsp" />
