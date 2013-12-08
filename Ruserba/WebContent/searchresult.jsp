<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<script src="assets/js/header.js"></script>
<title>Hasil pencarian kategori</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp"/>



	<%
	String keyword = request.getParameter("keyword");
	String sortby = request.getParameter("sortBy");
	String halaman = request.getParameter("currentPage");
	String kategori = request.getParameter("category");
	
	System.out.println(" | "+ keyword + sortby + halaman + kategori);
	
	String driver = "com.mysql.jdbc.Driver";
	
	
	Class driver_class = Class.forName(driver);
	Driver d = (Driver) driver_class.newInstance();
	DriverManager.registerDriver(d);
	
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/waserda", "java", "java");
	Statement st= con.createStatement();
	
	String value = "'%" + keyword + "%'";
	
	ResultSet rs=st.executeQuery("select * ,(case when nama LIKE "+ value +" then 1 else 0 end)+(case when kategori LIKE "+ value +" then 1 else 0 end)+(case when deskripsi LIKE "+ value +" then 1 else 0 end)+(case when harga LIKE "+ value +" then 1 else 0 end) as priority from data_barang where (kategori LIKE '%" + kategori + "%' and (nama LIKE "+ value +" or kategori LIKE "+ value +" or deskripsi LIKE "+ value +" or harga LIKE "+ value +")) order by "+sortby+" DESC;");
	/* if(rs.next())
	{
		if(rs.getString(2).equals(pwd))
		{
			out.println("welcome"+userid);
		
		}
		else
		{
			out.println("Invalid password try again");
		}
	} */
	
	if (rs.next()){
		int i = 1;
		
		do {
			
			/* out.println("<img src=\"" + rs.getString("img_dir") + "\">" + "<br/>");
			out.println("Nama: " + rs.getString("nama") + "<br/>");	
			out.println("Harga: " + rs.getString("harga") + "<br/>");	
			out.println("Stok: " + rs.getString("stok") + "<br/>");	
			out.println("Kategori: " + rs.getString("kategori") + "<br/>");	 */
			
			out.println("<img src=\"" + rs.getString("img_dir") + "\">" + "<br/>");
			
			out.println("<form method=\"post\" action =\"masukkankekeranjang\"");
			out.println("<br/>Nama: " + rs.getString("nama") +" " + rs.getString("id_barang") + "<br/>");	
			out.println("Harga: " + rs.getString("harga") + "<br/>");	
			out.println("Stok: " + rs.getString("stok") + "<br/>");	
			out.println("Kategori: " + rs.getString("kategori") + "<br/>");	
			out.println("Jumlah pemesanan:  <input id=\"t" + rs.getString("id_barang") + "\"type=\"jumlahbarang\" name= \"t" + rs.getString("id_barang") + "\" value=0>");
			out.println("<input type=\"button\" value =\"Masukkan ke keranjang\" onclick=\"addItemToBag('"+rs.getString("id_barang")+"', '1','"+rs.getString("nama")+"', '"+rs.getString("harga")+"')\">");
			out.println("</form>");
			out.println("<br/>");
			i++;
			System.out.println();
		} while (rs.next());
			
	}
	else {
		out.println("Nama barang yang dicari tidak ada");
	}
	
	con.close();
	
	%>

	<jsp:include page="footer.jsp"/>

</body>
</html>