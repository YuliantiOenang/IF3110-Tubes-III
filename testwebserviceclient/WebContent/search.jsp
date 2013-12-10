<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<%
int laman = Integer.parseInt(request.getParameter("laman"));
int i = (laman-1)*10;
int n_item =0;
String order="";
if(request.getParameter("order")== null){
	 order = "nama_barang";
}
else{
	 order = request.getParameter("order");
}
String name = request.getParameter("searched");
String harga = request.getParameter("s_harga");
String kategori = request.getParameter("s_kategori");
String n_item_query="";
String search_query="";

if (!name.equals("")) {
	if(!harga.equals("")){ //ada harga
		if(!kategori.equals("")){
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori;
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}else { //kategori kosong
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga;
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' AND harga_barang BETWEEN 0 AND "+harga+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
	}else{ //harga kosong
		if(!kategori.equals("")) {
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' AND kategori_barang = "+kategori;
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' AND kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		} else {
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%'";
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE nama_barang like '%"+name+"%' ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
		
	}
}else{// nama kosong
	if(!harga.equals("")){ //ada harga
		if(!kategori.equals("")){ //ada kategori
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori;
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE harga_barang BETWEEN 0 AND "+harga+" AND kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}else { //kategori kosong
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE harga_barang BETWEEN 0 AND "+harga;
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE harga_barang BETWEEN 0 AND "+harga+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
	} else { //gak ada harga
		if(!kategori.equals("")) {
			n_item_query = "SELECT COUNT(nama_barang) AS n_item FROM `progin_13511059`.barang WHERE kategori_barang = "+kategori;
			search_query = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang = "+kategori+" ORDER BY "+order+" ASC LIMIT "+i+", 10";
		}
	}
}
out.println("<div id='content' class='float_l'>");
try {
	  //Load the JDBC driver
			String uname = "root";
			String pass = "";
			String url = "jdbc:mysql://localhost/progin_13511059";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	        Connection con = DriverManager.getConnection (url, uname, pass);
		
	  //Create a Statement object and call its executeUpdate 
	  //method to insert a record
	  Statement s1 = con.createStatement();
	  Statement s2 = con.createStatement();
	  ResultSet rs1 = s1.executeQuery(n_item_query);
	  ResultSet rs2 = s2.executeQuery(search_query);
	  while(rs1.next()){
		  n_item = Integer.parseInt(rs1.getString(1));  
	  }
	  if(n_item ==0){
		  out.print("Search Return no value");
	  }
	  else{
		  while (rs2.next()) {
			  	out.println("<div class='product_box'>");
			  	out.println("<h3>"+rs2.getString(2)+"</h3><br>");
			    out.println("<a href='detail.jsp?id="+rs2.getString(1)+"'><img src='"+rs2.getString(3)+"'/></a>");
				out.println("<p class='product_price'>Harga : Rp "+ rs2.getString(4)+",-<br>");
				out.println("Stok : "+ rs2.getString(8) +"<br>");
				out.println("<form name='beli' action='addCart' method='post'>");
				out.println("<input type='hidden' name='id_barang' value='"+rs2.getString(1)+"'>");
				out.println("<input type='hidden' name='request_tambahan' value='-'> Quantity <input type='text' name='qt' style='width: 20px; text-align: right' /><input type='submit' value='Add to cart'></form></div>");
			  }  
	  }
	  int nextLaman = laman+1;
	  int prevLaman = laman-1;
	  if (n_item > 10) {
			if (laman == 1) {
				out.print("<li> <a href='search.jsp?laman="+nextLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>Berikutnya>>></a></li><br>");
				for (int x=0;x<n_item/10;x++) {
					out.print("<li> <a href='search.jsp?laman="+(x+1)+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>"+(x+1)+"</a></li><br>");
				}
			}
			else if (laman >= n_item/10) {
				out.print("<li> <a href='search.jsp?laman="+prevLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'><<<Sebelumnya</a></li><br>");
				for (int x=0; x< n_item/10;x++) {
					out.print("<li> <a href='search.jsp?laman='"+(x+1)+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>"+(x+1)+"</a></li><br>");
				}
			} else {
				out.print("<li> <a href='search.jsp?laman="+nextLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>Berikutnya>>></a></li><br>");
				for (int x=0;x< n_item/10;x++) {
					out.print("<li> <a href='search.jsp?laman="+(x+1)+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'>"+(x+1)+"</a></li><br>");
				}
				out.print("<li> <a href='search.jsp?laman="+prevLaman+"&searched="+name+"&s_harga="+harga+"&s_kategori="+kategori+"'><<<Sebelumnya</a></li><br>");
			}
			//fitur sorting
			
			out.print("<p> Sort By : </p>");
			out.print("<li> <a href='search.jsp?laman=1&searched="+name+"&order=nama_barang&s_harga=&s_kategori="+kategori+"'>Nama Barang</a></li><br>");
			out.print("<li> <a href='search.jsp?laman=1&searched="+name+"&order=harga_barang&s_harga=&s_kategori="+kategori+"'>Harga Barang</a></li><br>");
		}
	  rs1.close();
	  rs2.close();
	  s1.close();
	  s2.close();
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