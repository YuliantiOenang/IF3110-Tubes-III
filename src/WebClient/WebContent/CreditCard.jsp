<!DOCTYPE html>
<html>	
	<!-- Head -->
	<head><script src="UserAJAX.js"></script></head>	
	
	<!-- Body -->
	<body onload="LoginRedirection()">
		<div class="page_container">
			<!-- JSP Script -->
			<%@ include file="template/template.jsp" %>
			
			<div class="contents">
				<!-- Form Pendaftaran -->
				<h2>Registrasi Kartu Kredit</h2>	
				<form name="registration" >
					Credit Card Name:<input id="cardname" type="text" name="cardname" required>
					<br>Credit Card Number: <input id="cardnum" type="text" name="cardnum" required >
					<br>Expired Date(YYYYMMDD): <input id="expdate" type="text" name="expdate" required>
					<br><br><input type="button" id="submitbutton" onclick = "SubmitCreditCard()" value="Register Credit Card">
					<a href = "home">Register Credit Card Later</a>
				</form>
			</div>
		</div>
	</body>
</html>