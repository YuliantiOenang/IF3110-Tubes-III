import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;
import javax.jws.WebMethod;

import org.postgresql.Driver;

@WebService
public class Hello {
    private String message = new String("Hello, ");

    public void Hello() {
    }

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
    
    @WebMethod
    public void addUser(String id, String email, String password, String fullname, String alamat, String provinsi, String kota, int kodepos, int hp){
		
		// Variabel akses
		Connection conn = null;
		Statement stmt = null;	
		
		Driver drive = new Driver();
		
		// Coba buka koneksi
		try{
			conn = drive.connect("jdbc:postgresql://ec2-107-22-234-129.compute-1.amazonaws.com:5432/dd5q059l0v49cm?user=igsiblnhyllajh&password=aFEyJCyJ4bES-kRZV_bKZrCI6f&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", null);
			
			// Konstruksi query
			String query = "INSERT INTO userr(id,email,password,full_name,alamat,provinsi,kotakabupaten,kodepos,nomor_handphone) VALUES ('" + id + "','" + email + "','" + password + "','" + fullname + "','" + alamat + "','" + provinsi + "','" + kota + "'," + kodepos + "," + hp + ")" ;
			System.out.println(query);
			
			stmt = conn.createStatement();
			
			stmt.executeUpdate(query);					
		}catch(SQLException se){
			se.printStackTrace();	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}