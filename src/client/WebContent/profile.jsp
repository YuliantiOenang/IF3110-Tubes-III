<jsp:include page="contentBegin.jsp"></jsp:include>
<%@ page import="model.*" %>
<%@page import="java.util.HashMap"%>
<div class="center">
<div class="register_div">
	<h1 class='header'>Profil</h1>
	
<%
HashMap<String,String> model = new HashMap<String,String>();
model = (HashMap<String,String>)request.getAttribute("model");
%>
	
	<div class="per_form">
		<label>Nama Lengkap:</label><p><%= model.get("nama") %></p>
	</div>
	<div class="per_form">
		<label>Username:</label><p><%= model.get("username") %></p>
	</div>
	<div class="per_form">
		<label>Email:</label><p><%= model.get("email") %></p>
	</div>
	<div class="per_form">
		<label>Alamat:</label><p><%= model.get("alamat") %></p>
	</div>
	<div class="per_form">
		<label>Provinsi:</label><p><%= model.get("provinsi") %></p>
	</div>
	<div class="per_form">
		<label>Kota:</label><p><%= model.get("kota") %></p>
	</div>
	<div class="per_form">
		<label>Kode Pos:</label><p><%= model.get("kodepos") %></p>
	</div>
	<div class="per_form">
		<label>Telepon:</label><p><%= model.get("telepon") %></p>
	</div>
	<div class="per_form">
					<label>Transaksi:</label><p><%out.print(request.getAttribute("order_count")); %></p>
	</div>
	<a href="${pageContext.request.contextPath}/profile/edit" class="btn">Edit Profile</a> <!-- <?php echo $this->makeUrl('profile/edit') ?> -->
</div>

</div>

<jsp:include page="contentEnd.jsp"></jsp:include>