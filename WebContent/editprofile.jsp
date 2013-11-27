<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script type="text/javascript" src="verify2.js"></script>
<form name="edit" action="javascript:verifRegis();" method="post">
<%
try {
	  //Load the JDBC driver
			String uname = "root";
			String pass = "";
			String url = "jdbc:mysql://localhost/progin_13511059";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	        Connection con = DriverManager.getConnection (url, uname, pass);
		
		  
	  //Create a Statement object and call its executeUpdate 
	  //method to insert a record
	  Statement s = con.createStatement();
	  String sql = "SELECT * FROM user WHERE username ='"+session.getAttribute("username")+"'";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
	  %>
		Change Password: <input type='password' onkeyup='checkPass(this)' name='password' value='<%=rs.getString(3)%>'><div id='err_pass'></div><br>
	    Confirm Password: <input type='password' onkeyup='confirmPassword(this)' name='repassword' value='<%=rs.getString(3)%>'><div id='err_repass'></div><br>
		Nama Lengkap: <input type='text' name='fullname' onkeyup='checkFullName(this)' value='<%=rs.getString(2)%>'><div id='err_fullname'></div><br>
		Nomor Hand Phone: <input type='text' name='hpnum' value='<%=rs.getString(5)%>'><br>
		Alamat : <input type='text' name='address' value='<%=rs.getString(6)%>'><br>
		Provinsi : <input type='text' name='province' value='<%=rs.getString(7)%>'><br>
		Kecamatan : <input type='text' name='kecamatan' value='<%=rs.getString(8)%>'><br>
		Kode Pos : <input type='text' name='postalcode' value='<%=rs.getString(9)%>'><br>
		<input type="hidden" name="username" value='<%=rs.getString(1)%>'>
		<input type="hidden" name="Email" value='<%=rs.getString(4)%>'>
		<input type='submit' id='subedit' value='Edit'>
		<div id='edit_error'></div>
	  <%}
	  rs.close();
	  s.close();
	  con.close();
	}
	catch (ClassNotFoundException e1) {
	  // JDBC driver class not found, print error message to the console
	  System.out.println(e1.toString());
	}
	catch (SQLException e2) {
	  // Exception when executing java.sql related commands, print error message to the console
	  System.out.println(e2.toString());
	}
	catch (Exception e3) {
	  // other unexpected exception, print error message to the console
	  System.out.println(e3.toString());
	}
%>
</form>
<%@ include file= "./footer.jsp" %>