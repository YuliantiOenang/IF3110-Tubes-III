package tubes2wbd;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class soap {
	public String registeruser(String username, 

						String password,
						String nama,
						String nohp,
						String alamat,
						String provinsi,
						String kota,
						String kodepos,
						String email) {
		String output = "";
				
			try {
				DbConnector dbconnector = new DbConnector();
				Connection conn = dbconnector.mySqlConnection();
		        // Execute SQL query
		        Statement stmt;
				stmt = conn.createStatement();
				
				String sql = "INSERT INTO anggota(username,password,nama,nomorhp,alamat,provinsi,kota,kodepos,email,foto) "
		        		+ "values ('"+username+"','"+password+"','"+nama+"','"+nohp+"','"+alamat+"','"+provinsi+"','"+kota+"','"+kodepos+"','"+email+"','user.png')";
		        stmt.executeUpdate(sql);
		        //if(rs.next()){
		        output += "<html>	<head><script>if(typeof(Storage)!==\"undefined\"){"
			        	+ " localStorage.wbduser=\""+username+"\"; localStorage.wbdlogintime=new Date().getTime(); "
			        	+ "window.location=\"registercardform.jsp\";}else{document.write(\"Maaf, browser kamu tidak support localStorage sehingga informasi username tidak dapat disimpan...\");"
			        	+ "document.write(\"<a href='index.jsp'>Kembali ke halaman utama</a>\");}</script></head><body></body></html>";
		        	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		return output;
	}
	
	public String additem(String nama,
							String img,
							String harga,
							String kategori,
							String jumlah,
							String deskripsi
			) {
		String output = "";
		
		Statement stmt = null;
	    try {
	    	DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection();
			stmt = conn.createStatement();
			String sql;
            sql = "insert into barang (nama, gambar, harga, kategori, jumlah, keterangan, terjual) "
            		+ "VALUES ('"+nama+"','"+img+"',"
            		+ harga + ",'"+kategori+"',"+jumlah+",'"
            		+ deskripsi +"',0"+")";
			stmt.executeUpdate(sql);
			output +="<html><body> Selamat, Item "+nama+" telah berhasil ditambahkan"
            		+ "<br><br><a href='adminbarang.jsp'>Kembali ke halaman admin</a></body></html>";
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
}
