<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.frexesc.model.*, java.util.*"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="header.jsp" />

<script src="js/admin.js"></script>
</head>
<body>

	<jsp:include page="layout.jsp" />
	<h1 class="header">Edit Barang</h1>
	<%
		@SuppressWarnings("unchecked")
		ArrayList<BarangBean> barangs = (ArrayList<BarangBean>) request.getAttribute("barangs");
		@SuppressWarnings("unchecked")
		ArrayList<KategoriBean> kategoris = (ArrayList<KategoriBean>) request.getAttribute("kategoris");
		for (int i = 0; i < kategoris.size(); i++) {
	%>
	<a href="admin?action=edit&category=<%=kategoris.get(i).getId()%>"><%=kategoris.get(i).getName()%></a>
	<%
		}
	%>
	<div class="table">
		<div class="row">
			<div class="c1">id</div>
			<div class="c2">kategori</div>
			<div class="c3">nama</div>
			<div class="c4">harga</div>
			<div class="c5">deskripsi</div>
			<div class="c6">gambar</div>
			<div class="c7">jumlah</div>
			<div class="c8">edit</div>
			<div class="c9">hapus</div>
		</div>
		<%
			String[] categories = { "Ladies Dress", "Ladies Shoes", "Men Shirt", "Men Shoes", "Men Hat" };
			for (int i = 0; i < barangs.size(); i++) {
				BarangBean b = barangs.get(i);
		%>
		<div class="row" id="<%="r" + b.getId()%>">
			<div class="c1" id="<%="id" + b.getId()%>"><%=b.getId()%></div>
			<div class="c2" id="<%="cat" + b.getId()%>"><%=categories[(int) (b.getId_category()) - 1]%></div>
			<div class="c3" id="<%="name" + b.getId()%>"><%=b.getName()%></div>
			<div class="c4" id="<%="pri" + b.getId()%>"><%=b.getPrice()%></div>
			<div class="c5" id="<%="desc" + b.getId()%>"><%=b.getDescription()%></div>
			<div class="c6" id="<%="pic" + b.getId()%>">
				<a href="#"
					onclick="window.open('admin?action=pic&id=<%=b.getId()%>', 'newwindow', 'width=500, height=250'); return false;"><%=b.getPicture()%></a>
			</div>
			<div class="c7" id="<%="total" + b.getId()%>"><%=b.getTotal_item()%></div>
			<div class="c8" id="<%="edit" + b.getId()%>">
				<button onclick="editbarang(<%=b.getId()%>)">edit</button>
			</div>
			<div class="c9">
				<form method="post" action="admin"
					onsubmit='return confirmdelete("<%=b.getName()%>")'>
					<input type="hidden" name="id" value="<%=b.getId()%>" /> <input
						type="hidden" name="action" value="delete" />
					<button>hapus</button>
				</form>
			</div>
		</div>
		<%
			}
		%>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>