<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<%
if((sesi== null)|| (sesi.getAttribute("username")==null))
	out.print("<script>window.location='register.jsp';</script>");
%>
<script type="text/javascript" src="beli.js"></script>
<h3> Your Shopping Cart </h3>
<form name="shopping_cart" action="editShopCart" method="post">
<% 
if(sesi.getAttribute("shopping_cart")==null) {
%>
You haven't Add anything to Shopping Cart
<%
}
else{
	Vector<String> shopping_cart = (Vector<String>) session.getAttribute("shopping_cart");
	Vector<String> shopping_request = (Vector<String>) session.getAttribute("shopping_request");
	Vector<Integer> item= (Vector<Integer>) session.getAttribute("amount");
	
	try {
		  //Load the JDBC driver
				String uname = "root";
				String pass = "";
				String url = "jdbc:mysql://localhost/progin_13511059";
				Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		        Connection con = DriverManager.getConnection (url, uname, pass);
				int totalHarga=0;
			  	int counter = 0;
		  //Create a Statement object and call its executeUpdate 
		  //method to insert a record
		  for(int i = 0; i < shopping_cart.size();i++){
			  Statement s = con.createStatement();
			  String sqlBarang = "SELECT * FROM `progin_13511059`.barang WHERE id_barang='"+shopping_cart.get(i)+"'";
			  ResultSet rs = s.executeQuery(sqlBarang);
			  while (rs.next()) {
				    out.println(rs.getString(2)+" : <input type='text' name = '"+i+"' value='"+item.get(i)+"'>"+shopping_request.get(i)+"<br>");
				    totalHarga+= item.get(i) * Integer.parseInt(rs.getString(4));
				  }
			  rs.close();
			  s.close();
		  }
		  out.print("<input type='submit' id='edit' value='Edit!'><br><br></form>");
		  out.print("Total Pembelian Anda :<input type='text' id='totalharga' value='"+totalHarga+"' readonly><br>Choose Your Credit Card :<br>");
		  Statement s2 = con.createStatement();
		  String sqlCredit = "SELECT * FROM `progin_13511059`.creditcard WHERE card_owner ='"+session.getAttribute("username")+"'";
		  ResultSet rs2 = s2.executeQuery(sqlCredit);
		  out.print("<form name='beli_barang' action='javascript:verBeli();' method='post'>");
		  if(!rs2.next()){
			  out.print("<input type='hidden' name ='creditid' value='asd'>");
			  out.print("<input type='submit' value='Beli!'>");
		  }
		  else{
			  while(rs2.next()){
				  if(counter ==0){
					  out.print("<input type='radio' value='"+rs2.getString(1)+"' name='creditid' checked>"+rs2.getString(1)+"<br>");
				  }
				  else{
					  out.print("<input type='radio' value='"+rs2.getString(1)+"' name='creditid'>"+rs2.getString(1)+"<br>");  
				  }
				  counter++;
			  }
			  out.print("<input type='submit' value='Beli!'><div id='barang_error'></div>");  
		  }
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
}
%>
</form>
<%@ include file= "./footer.jsp" %>