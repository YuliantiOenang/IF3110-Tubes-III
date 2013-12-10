<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="layout.jsp"></jsp:include>
	<form action="admin" method="post" enctype="multipart/form-data">
		<div class="register_div">
			<h1 class="header">Add new item</h1>
			<input type="hidden" name="action" value="add" />
			<div class="per_form">
				<label>Name: </label><input type="text" id="name" name="name" />
				<span class="error" id="fullname"></span>
			</div>
			<div class="per_form">
				<label>Category: </label> <select name="category">
					<%
						int i;
						String[] categories = { "Ladies Dress", "Ladies Shoes", "Men Shirt", "Men Shoes", "Men Hat" };
						for (i = 0; i < 5; i++) {
					%>
					<option value="<%=i + 1%>"><%=categories[i]%></option>
					<%
						}
					%>
				</select>
				<span class="error" id="fullname"></span>
			</div>
			<div class="per_form">
				<label>Price: </label><input type="number" id="price" name="price" />
				<span class="error" id="fullname"></span>
			</div>
		</div>
		<div class="register_div">
			<div class="per_form">
				<label>Description: </label> <input type="text" id="description" name="description" />
				<span class="error" id="fullname"></span>
			</div>
			<div class="per_form">
				<label>Amount: </label><input type="number" id="amount"
					name="amount" />
				<span class="error" id="fullname"></span>
			</div>
			<div class="per_form">
				<label>Image: </label><input type="file" id="photo" name="photo" />
				<span class="error" id="fullname"></span>
			</div>
			<p class='keterangan'>Lorem ipsum dolor sit amet lorem ipsum
				dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet
				lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum
				dolor sit amet lorem ipsum dolor sit amet</p>
			<button type="submit" id="btn" onclick="" class="btn">Tambah</button>
		</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>