<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="koneksi.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saving image...</title>
<%
	if(request.getParameter("username")!=null){
		try{
			// Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");
        	// Open a connection
	        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Execute SQL query
          	Statement stmt = conn.createStatement();
          	String sql = "update anggota set foto='"+request.getParameter("filename")+"' where username='"+request.getParameter("username")+"'";
    		stmt.executeUpdate(sql);
    		out.print("<script>function delay(){document.write(\"<p>Foto berhasil di upload!</p><a href='profile.jsp'>Kembali ke halaman profile</a>\");}</script>");
          	stmt.close();
          	conn.close();
       	}catch(SQLException se){
          	//Handle errors for JDBC
          	out.println(se.toString());
       	}catch(Exception e){
        	//Handle errors for Class.forName
          	out.println(e.toString());
       	}//end try
	}else{
		out.print("<script>var username = localStorage.wbduser;document.getElementById(\"username\").value=username;document.getElementById(\"filename\").value=\""+request.getParameter("filename")+"\";</script>");
	}
%>
</head>
<body onLoad="setTimeout('delay()', 500)">
<form action="updatedb.jsp" method="GET">
<input type="hidden" name="username" id="username">
<input type="hidden" name="filename" id="filename">
<p>Yakin ingin menyimpan foto? </p><input type="submit" value="Ya"> <a href="profile.jsp">Tidak</a>
</form>
<p id="cn"></p>
</body>
</html>