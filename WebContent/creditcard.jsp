<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/validate.js"></script>

<jsp:include page="header.jsp" />
<link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/css/date.css" />

</head>
<body>
<jsp:include page="layout.jsp" />
	<!-- new! -->
		
	<form method="post" id="form_credit" action="card" onsubmit="return validateCard(num.value, name.value)" name="card">
	<div class='register_div'>
		<h1 class='header'>Registrasi Kartu Kredit</h1>
		
		<div class='per_form'>
			<label>Card Number</label><input type="text" name="num" id="num" value="" onkeypress="if (this.value != '') validate('number', this.value, 'valnum')" required>
			<span class='error' id="valnum"></span>
		</div>
		
		<div class='per_form'>
			<label>Name of Card</label><input type="text" name="name" id="name" onkeypress="if (this.value != '') validate('name', this.value, 'valname')" value="" required>
			<span class='error' id="valname"></span>
		</div>
			
		<div class='per_form'>
			<label>Expired Date</label><input type="text" name="expired_date" id="expired_date" required>
			<span class='error' id="error-expired_date"></span>
		</div>
		<input type="hidden" name="return">
		<input type="hidden" name="from" value="<%= request.getAttribute("from") %>">
		<button type="submit" id="btn" class="btn">Register</button>
  	
  		<% if (request.getParameter("from") == null) { %>
		<a href="index" class="btn">Skip</a>
		<% } %>
			
	</div>
</form>

<!-- <script src="<?php echo $this->getBaseUrl() ?>/js/credit.js"></script>
<script>
	var server = "<?php echo $this->getBaseUrl() ?>";
</script>
	 -->
	 <script src="js/date.js"></script>
	<!-- new! -->
<jsp:include page="footer.jsp" />

</body>
</html>