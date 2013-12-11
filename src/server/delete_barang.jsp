<%@ page import="java.sql.*" %>
<%
	String id = request.getParameter("id");
	
	String db_url = "jdbc:mysql://localhost/ruserba";
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection connection = DriverManager.getConnection(db_url, "root", "");
	String sql = "DELETE FROM barang WHERE id='" + id + "'";
	PreparedStatement statement = connection.prepareStatement(sql);
	
	int updateCount = 0;
	updateCount = statement.executeUpdate();
	
	if (updateCount == 0) {
		out.print("0");
	} else {
		out.print("1");
	}
	
	connection.close();
%>