
<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title>Masukkan Judul Dokumen</title>
	<link rel="stylesheet" type="text/css" href="res/css/style.css" media="all"/>
</head>
<body>
	
	<div id="container">
		
	<%@ include file="header.jsp" %>
		<c:choose>
		<c:when test="${empty cookie.username.value}">
		<%
			// New location to be redirected
			String site = new String("registrasi.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		%>
		</c:when>
		<c:when test="${empty cookie.creditcard.value}">
		<div id="form-registrasi" class="frame">
			<p id="registration-title">Credit Card Registration</p>
			
			<!-- card number, name on card, expired date dan tombol sumbit -->
			<form id='registercreditcard' action='RegistrasiKartu' method='post' 
				accept-charset='UTF-8' onsubmit = "return cekvalid()">
			
				<div id="card-number" class="form-field">
					<p class="label">Card Number :</p>
					<p>
						<input type='text' name='validasicardnumber' id='validasicardnumber' maxlength="10" value ="tidak valid" readonly/>
						<input name="cardnumber" id="cardnumber" required="required" onkeyup="!!(ceknumber() & ceknamecard() & cekexpiredate())" class="field-box kolom-12" >
					</p>
				</div>
				
				<div id="name-on-card" class="form-field">
					<p class="label">Name On Card :</p>
					<p>
						<input type='text' name='validasinamecard' id='validasinamecard' maxlength="10" value ="tidak valid" readonly/>
						<input type = "text" name="cardname" id="cardname" required="required" onkeyup="ceknamecard()" class="field-box kolom-12"/>
					</p>
				</div>
				
				<div id="expired-date" class="form-field">
					<p class="label">Expired Date :</p>
					<p>
						<input type='text' name='validasiexpiredate' id='validasiexpiredate' maxlength="10" value ="tidak valid" readonly/>
						<input type="date" name='expiredate' id='expiredate' maxlength="50" required="required" oninput="cekexpiredate()" class="field-box kolom-12"/>
					</p>
				</div>				
				<br/>
				<input type='submit' id="submitbutton" name='submitbutton' value='Register' class="btn"/>
				<input type='button' id="skipbutton" name='skipbutton' value='Skip' onclick="location.href='home.jsp'" class="btn"/>
			</form>
		</div>
		</c:when>
		<c:when test="${not empty cookie.creditcard.value}">
		<div id="form-registrasi" class="frame">
			<p id="registration-title">Credit Card</p>
			
			<!-- card number, name on card, expired date dan tombol sumbit -->
			<div id="card-number" class="form-field">
				<p class="label">Card Number :</p>
				<p>
					<input type="cardnumber" id="cardnumber"  class="field-box kolom-12" value="<c:out value="${cookie.creditcard.value}"/>" readonly/>
				</p>
			</div>
			
			<div id="name-on-card" class="form-field">
				<p class="label">Name On Card :</p>
				<p>
					<input type = "text" name="namecard" id="namecard"  value="<c:out value="${cookie.creditcardNama.value}"/>" class="field-box kolom-12" readonly/>
				</p>
			</div>
			
			<div id="expired-date" class="form-field">
				<p class="label">Expired Date :</p>
				<p>
					<input type="date" name='expiredate' id='expiredate' maxlength="50"  value="<c:out value="${cookie.creditcardExpire.value}"/>" class="field-box kolom-12" readonly/>
				</p>
			</div>				
			<br/>
		</div>
		</c:when>
		</c:choose>
	</div>
	

	
	<!-- Javascript -->
	<script src="res/js/common.js" type="text/javascript"></script>	
	<script src="AjaxRegister.js"></script>
	<script src="scriptregistercreditcard.js"></script>
	<script src="popup.js"></script> 
	<script src="Ajaxlogin.js"></script> 

</body>
</html>