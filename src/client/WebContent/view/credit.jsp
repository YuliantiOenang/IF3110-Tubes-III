<%@page import="javaModel.Credit" %>
<%@page import="java.util.ArrayList" %>

<link rel='stylesheet' type='text/css' href='/ruserba/css/date.css' />
<% Credit C = (Credit) request.getAttribute("credit"); %>
<form id="form_credit" method="POST" onsubmit="credit(); return false;">
	<div class="basiccontent register_div" id="addcreditcardcontent">
		<h1 class="header">Registrasi Kartu Kredit</h1>
		<div class="per_form">
			<label>Card Number*</label>
			<input type="text" name="card_number" value="<%= C.card_number.get(0) %>" id="card_number"><br>
		</div>
		<div class="per_form">
			<label>Name*</label>
			<input type="text" name="name_of_card" id="name_of_card" value="<%= C.name_of_card.get(0) %>"><br>
		</div>
		<div class="per_form">
			<label>Expired Date (YYYY-MM-DD)</label>
			<input type="text" value="<%= C.expired_date.get(0) %>" name="expired_date" id="expired_date"><br>
		</div>
		<button type="submit" class="btn small full">Submit</button>
		<a type="button" href="/ruserba/profile/index?ignore=1" class="btn small full">Skip</a><br>
	</div>
</form>
<script src="/ruserba/js/date.js" type="text/javascript"></script>
<script src="/ruserba/js/credit.js"></script>
<script>
	var server = "";
</script>