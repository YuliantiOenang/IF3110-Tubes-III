<%@ page import="javaModel.Barang" %>
<script src="/ruserba/js/deleteBarang.js" type="text/javascript"></script>
<h1 class="header">Administrator</h1><br>
<a href="/ruserba/admin/addbarang" class="btn">+ Tambah Barang</a> 
Kategori : 
<%
	java.sql.ResultSet RS = (java.sql.ResultSet) request.getAttribute("listKategori");
	while (RS.next())
	{
%>
	<a href = "/ruserba/admin/index?kateg=<%=RS.getObject(1)%>" class="btn small"> <%=RS.getObject(2)%></a>
<%
	}
	
	Barang B = (Barang) request.getAttribute("barang");
	if (B!=null)
	{
%>

<br><br>		
<%
		int i;
		int size = B.nama.size();
		for (i=0;i<size;i++)
		{
%>
		<div class="itembox">
			<div class="pict" id="item<%= B.id.get(i) %>">
				<div title="Ready Stock" class="itembox_img">
					<img onload="fitbarang(this)" src="/ruserba/images/barang/<%= B.gambar.get(i) %>">
				</div>
				<div class="minicart_menu">
					<a href="/ruserba/admin/editbarang?id=<%=B.id.get(i)%>" class="btn small" >Edit</a> 
					<a href="#<%=B.id.get(i)%>" onclick="deleteBarangConfirm(<%=B.id.get(i)%>)" class="btn small" >Delete</a>
				</div>
				<div class="item_name"><a href="/ruserba/barang/detail?id=<%= B.id.get(i) %>"><%= B.nama.get(i) %></a><br>IDR <%= B.harga.get(i) %></div>
			</div>
		</div>
<% 
		}
	}
%>