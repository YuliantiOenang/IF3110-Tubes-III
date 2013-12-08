<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.io.PrintWriter" %>
    
<aside id="sidebar" class="body">
	<p>Selamat datang!</p>
	<div id="s_bar">Silakan pilih barang belanjaan Anda! :)</div>
</aside>
<script src="javascript/transaksi.js"></script>
<script>
if(localStorage.wbduser){
	<% 
		Connection conn = null;
	    Statement stmt = null;
	    PrintWriter outs = response.getWriter();
	    int i=0;
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/wbd1"
					,"root","");
			stmt = conn.createStatement();
			
			String sql;
			sql = "select count(*) from barang";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				i = rs.getInt("count(*)") - 1;
			}
			
			
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
	var currentpage=1;
	var shopping_bag = [];
	var sum_item = <% out.print(i); %>;
	var maxpage= (sum_item/10+1);
	var isi,buyitem;
	initialize_bag();
}
</script>
