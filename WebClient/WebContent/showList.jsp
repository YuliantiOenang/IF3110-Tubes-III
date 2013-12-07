<%@page import="java.util.ArrayList"%>
<%@page import="kelas.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% out.println("Kategori: " + request.getAttribute("kategori")); %></title>
</head>
<body>
	<div class="page_container">
	<%@ include file="template/template.jsp" %> 
		<% 	
			out.println("<h1>Kategori: " + request.getAttribute("kategori") + "</h1>");
		%>
		<div class="sort_by">
			Sort by:
			<form class="inline_form" method="get">
				<input type='hidden' name="cat" value="<%= request.getAttribute("kategori").toString().toLowerCase() %>"/>
				<select name="mode">
				  <option value="harga">Harga</option>
				  <option value="nama_inventori">Nama Inventori</option>
				</select>
				<select name="type">
				  <option value="ASC">Membesar</option>
				  <option value="DESC">Mengecil</option>
				</select>
				<input type="submit" value="Sort"/>
			</form>
		</div>
		<%
			ArrayList<Barang> barangs = (ArrayList<Barang>) request.getAttribute("barangs");
			int awal = (request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start")));
			int no = 0;
			for(Barang b: barangs){
				if(no < awal){
					no++;
					continue;
				}
				%>
					<div class="list_barang">
						<div class="gambar">
							<img src="res/<%= b.getGambar() %>" width="150px" height="150px">
						</div>
						<div class="list_desc">
							<strong>Nama:</strong> <a href="detail?gid=<%= b.getId_inven() %>"><%= b.getNama() %></a><br/>
							<strong>Harga:</strong> <%= b.getHarga() %><br/><br/>
							<form class="cart_buy">
								<input type='text' id='quant<%= no %>' value='0' size=7 >
								<img class="cart_button" src="res/addtocart.png" width=125 onclick="validate(<%= b.getId_inven() %>, <%= no %>)">
							</form>
							
							<div class="notif" id='notif<%=no%>'></div>
						</div>
					</div>
				<%
				if(no - awal == 9){
					break;
				}
				no++;
			}
			%>
			<div class="pagination"> Halaman: 
			<%
			for(int i=0;i<Math.ceil(barangs.size()/10f);i++){
				if(i * 10 == awal){
					out.println("[" + (i+1) + "]");
				} else {
					%>	
					<a href="showList?cat=<%= request.getParameter("cat") %><%= (request.getParameter("mode") == null ? "" : ("&mode=" + request.getParameter("mode"))) %><%= (request.getParameter("type") == null ? "" : ("&type=" + request.getParameter("type"))) %>&start=<%= i*10 %>"><%= (i+1) %></a>
					<%
				}
			}
			%>
			</div>
			<%
		%>
	</div>
</body>
	<script src="transaction.js"></script>
</html>