<%@ page import="java.sql.*" %>
<%
	String gambar = request.getParameter("img");
	String nama = request.getParameter("name");
	String harga = request.getParameter("prc");
	String kategori = request.getParameter("kat");
	String jumlah = request.getParameter("jml");
	String keterangan = request.getParameter("ket");
	
	String db_url;
	Connection connection;
	
// 	db_url = "jdbc:mysql://localhost/ruserba";
// 	Class.forName("com.mysql.jdbc.Driver").newInstance();
// 	connection = DriverManager.getConnection(db_url, "root", "");
// 	Statement statement = connection.createStatement();
	
// 	ResultSet user = statement.executeQuery("SELECT * FROM barang");
	
// 	int idx = 0;
// 	if (user != null) {
// 		while (user.next()) {
// 			idx++;
// 		}
// 	}
// 	idx++;
	
// 	connection.close();
	
	db_url = "jdbc:mysql://localhost/ruserba";
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	connection = DriverManager.getConnection(db_url, "root", "");
	String sql = "INSERT INTO barang (nama, gambar, kategori, harga, jumlah, keterangan, terjual) VALUES ("
				+ "'" + nama + "', "
				+ "'" + "images/" + gambar + "', "
				+ "'" + kategori + "', "
				+ harga + ", "
				+ jumlah + ", "
				+ "'" + keterangan + "', "
				+ "0"
				+ ")";
	PreparedStatement stm = connection.prepareStatement(sql);
	
	int updateCount = 0;
	updateCount = stm.executeUpdate();
	
	if (updateCount == 0) {
		out.print("0");
	} else {
		out.print("1");
	}
	
	connection.close();
%>