
<%@ include file= "./header.jsp" %> 
<%	System.out.println("Hello World in Console.");
	out.println("<ul>Hello Koordas Imba!</ul>");
	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");%>
<h1>Current Date: <%= df.format(new java.util.Date()) %></h1>
Login
<form action="Controller" method="post">
Username : <input type="text" name="username"/><br>
Password : <input type="password" name="password"/><br>
<input type="submit" value="Login" />
</form>
</body>
</html>