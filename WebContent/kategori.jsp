<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<div id="content" class="float_l">
 <%
 HttpSession sesion = request.getSession(true);
 if(sesion.getAttribute("username")!=null&&sesion.getAttribute("username").equals("admin")){
	 out.print("<a href='barangAdmin?action=create&kategori_barang="+request.getParameter("id")+"'>Create</a>");
 }
 int laman = Integer.parseInt(request.getParameter("laman"));
 int idkat = Integer.parseInt(request.getParameter("id"));
 System.out.println(idkat);
 String nama="";
 int i = (laman-1)*10;
 int n_item =30;
 String istring = ""+i;
 String order="";
 if(request.getParameter("order")== null){
	 order = "nama_barang";
 }
 else{
	 order = request.getParameter("order");
 }
 	if(idkat==1){
		nama = "Pangan";
	}
	else if(idkat==3){
		nama = "Elektronik";
	}
	else if(idkat==2){
		nama = "Pakaian";
	}
	else if(idkat==4){
		nama = "Rumah Tangga";
	}
	else if(idkat==5){
		nama = "Olah Raga";
	}
	else {
		nama = "tidak terdaftar";
	}
 
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
	  String sql = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = "+idkat+" ORDER BY "+order+" ASC LIMIT "+istring+", 10";
	  ResultSet rs = s.executeQuery(sql);
	  out.println("<h3>"+nama+"</h3>");
	  while (rs.next()) {
	    out.println("<div class='product_box'>");
		out.println("<h3>"+rs.getString(2)+"</h3>");
	    out.println("<a href='detail.jsp?id="+rs.getString(1)+"'><img src='"+ rs.getString(3)+"'/></a>");
		out.println("<p class='product_price'>Harga : Rp "+rs.getString(4)+",-<br>");
		out.println("Stok : "+rs.getString(8) +"<br>");
		out.println("<form name='beli' action='addCart' method='post'>");
		out.println("<input type='hidden' name='id_barang' value='"+rs.getString(1)+"'>");
		out.println("<input type='hidden' name='request_tambahan' value='-'>");
		out.println("Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />");
		out.println("<input type='submit' value='Add to cart'>");
		if(sesion.getAttribute("username")!=null&&sesion.getAttribute("username").equals("admin"))
			out.println("</form><a href='barangAdmin?action=update&id_barang="+rs.getString(1)+"'>Update</a> | <a href='#' onclick='if (confirm(\"Yakin mau membuang barang ini?\")) window.location=\"barangAdmin?action=delete&id_barang="+rs.getString(1)+"\"'>Delete</a></p></div>");
		else
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
 int nextlaman = laman+1;
 int prelaman = laman-1;
 if (laman == 1) {
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+nextlaman+"'>Berikutnya>>></a></li><br>");
		for (int x=1;x<=n_item/10;x++) {
			out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+x+"'>"+x+"</a></li><br>");
		}
	}
	else if (laman >= n_item/10) {
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+prelaman+"'><<<Sebelumnya</a></li><br>");
		for (int x=1;x<=n_item/10;x++) {
			out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+x+"'>"+x+"</a></li><br>");
		}
	} else {
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+nextlaman+"'>Berikutnya>>></a></li><br>");
		for (int x=1;x<=n_item/10;x++) {
			out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+x+"'>"+x+"</a></li><br>");
		}
		out.println("<li> <a href='kategori.jsp?id="+idkat+"&laman="+prelaman+"'><<<Sebelumnya</a></li><br>");
	}
out.print("<p> Sort By : </p>");
out.print("<li> <a href='search.jsp?laman=1&searched=&order=nama_barang&s_harga=&s_kategori="+idkat+"'>Nama Barang</a></li><br>");
out.print("<li> <a href='search.jsp?laman=1&searched=&order=harga_barang&s_harga=&s_kategori="+idkat+"'>Harga Barang</a></li><br>");
 %>
 
</div>
<%@ include file= "./footer.jsp" %>