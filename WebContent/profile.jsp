<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ include file= "./header.jsp" %>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/progin_13511059" user="root" password=""/>
<sql:query dataSource="${snapshot}" var="result">
	SELECT * from Employees WHERE username = '<%= session.getAttribute("username") %>'; 
</sql:query>

<h3><c:out value="${row.nama_lengkap}"/></h3><br>
			<p>username :<c:out value="${row.username}"/> </p><br>
			<p>email :<c:out value="${row.email}"/> </p><br>
			<p>Mobile :<c:out value="${row.handphone}"/> </p><br>
			<p>Address :<c:out value="${row.address}"/> </p><br>
			<p>Province :<c:out value="${row.province}"/> </p><br>
			<p>State : <c:out value="${row.state}"/></p><br>
			<p>Postal Code :<c:out value="${row.postcode}"/> </p><br>
			<a href="editprofile.php"> Edit Profile </a>
</body>
</html>