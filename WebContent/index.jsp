<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %> 
<%	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");%>
<div id="content" class="float_l">
<h1>Current Date: <%= df.format(new java.util.Date()) %></h1>
<h1>Mekanisme Pembelian</h1>
	<p>
		---------------------------------------------------------------------<br>
		Tata cara pembelian:<br>
			1. Masukkan nilai quantity pada input box yang diberikan<br>
			2. Klik Tombol Add to cart.<br>
			3. Klik link Shopping Bag pada bagian Header<br>
			4. Pilih Kartu Kredit untuk pembayaran<br>
			5. Apabila ingin mengedit jumlah barang, ubah nilai pada input box dan klik edit shopcart<br>
			6. Klik tombol beli dan barang langsung dikirimkan pada Anda! :D<br>
		---------------------------------------------------------------------<br>
	</p>
<h1>Top Pangan</h1>
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
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 1 ORDER BY n_beli DESC LIMIT 0,3";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
	    out.println("<div class='product_box'>");
		out.println("<h3> "+rs.getString(2)+"</h3><br>");
	    out.println("<a href='detail.jsp?id="+rs.getString(1)+"'><img src='"+ rs.getString(3)+"'/></a>");
		out.println("<p class='product_price'>Harga : Rp "+rs.getString(4) +",-<br>");
		out.println("Stok : "+rs.getString(8) +"<br>");
		out.println("<form name='beli' action='addCart' method='post'>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("<input type='hidden' name='request_tambahan' value='-'>");
		out.println("Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />");
		out.println("<input type='submit' value='Add to cart'>");
		out.println("</form></p></div>");
	  }
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



<h1>Top Pakaian</h1>
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
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 2 ORDER BY n_beli DESC LIMIT 0,3";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
		out.println("<div class='product_box'>");
		out.println("<h3> "+rs.getString(2)+"</h3><br>");
	    out.println("<a href='detail.jsp?id="+rs.getString(1)+"'><img src='"+ rs.getString(3)+"'/></a>");
		out.println("<p class='product_price'>Harga : Rp "+rs.getString(4) +",-<br>");
		out.println("Stok : "+rs.getString(8) +"<br>");
		out.println("<form name='beli' action='addCart' method='post'>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("<input type='hidden' name='request_tambahan' value='-'>");
		out.println("Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />");
		out.println("<input type='submit' value='Add to cart'>");
		out.println("</form></p></div>");
	  }
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

<h1>Top Elektronik</h1>
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
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 3 ORDER BY n_beli DESC LIMIT 0,3";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
		out.println("<div class='product_box'>");
		out.println("<h3> "+rs.getString(2)+"</h3><br>");
	    out.println("<a href='detail.jsp?id="+rs.getString(1)+"'><img src='"+ rs.getString(3)+"'/></a>");
		out.println("<p class='product_price'>Harga : Rp "+rs.getString(4) +",-<br>");
		out.println("Stok : "+rs.getString(8) +"<br>");
		out.println("<form name='beli' action='addCart' method='post'>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("<input type='hidden' name='request_tambahan' value='-'>");
		out.println("Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />");
		out.println("<input type='submit' value='Add to cart'>");
		out.println("</form></p></div>");
	  }
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
<h1>Top Rumah Tangga</h1>
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
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 4 ORDER BY n_beli DESC LIMIT 0,3";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
		out.println("<div class='product_box'>");
		out.println("<h3> "+rs.getString(2)+"</h3><br>");
	    out.println("<a href='detail.jsp?id="+rs.getString(1) +"'><img src='"+ rs.getString(3)+"'/></a>");
		out.println("<p class='product_price'>Harga : Rp "+rs.getString(4) +",-<br>");
		out.println("Stok : "+rs.getString(8) +"<br>");
		out.println("<form name='beli' action='addCart' method='post'>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("<input type='hidden' name='request_tambahan' value='-'>");
		out.println("Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />");
		out.println("<input type='submit' value='Add to cart'>");
		out.println("</form></p></div>");
	  }
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
<h1>Top Olah Raga</h1>
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
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = 5 ORDER BY n_beli DESC LIMIT 0,3";
	  ResultSet rs = s.executeQuery(sql);
	  while (rs.next()) {
		out.println("<div class='product_box'>");
		out.println("<h3> "+rs.getString(2)+"</h3><br>");
	    out.println("<a href='detail.jsp?id="+rs.getString(1) +"'><img src='"+ rs.getString(3)+"'/></a>");
		out.println("<p class='product_price'>Harga : Rp "+rs.getString(4) +",-<br>");
		out.println("Stok : "+rs.getString(8) +"<br>");
		out.println("<form name='beli' action='addChart' method='post'>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("<input type='hidden' name='request_tambahan' value='-'>");
		out.println("Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />");
		out.println("<input type='submit' value='Add to cart'>");
		out.println("</form></p></div>");
	  }
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
</div>
<%@ include file= "./footer.jsp" %>