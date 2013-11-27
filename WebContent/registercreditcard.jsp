<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script type="text/javascript" src="verifycard.js"></script>
<form name="login" action="verifyCardRegist" method="post">
		Card Number: <input type="text" name="cardnum" onkeyup="checkCard(this)"><br>
		Name on Card: <input type="text" name="namecard"><br>
		Expired Date: <input type="text" name="expdate"><br>
		Date Format : YYYY/MM/DD
		<div id="credit_error"></div>
		<input type="submit" id="regcard" value="Register Card">
</form>
<%@ include file= "./footer.jsp" %>