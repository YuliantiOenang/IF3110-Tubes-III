
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kelas.Database;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	
	static final String JDBCDRIVER = "com.mysql.jdbc.DRIVER";
	static final String DBURL = "jdbc:mysql://localhost/toko_imba";

	static final String USER = Database.getUser();
	static final String PASS = Database.getPass();
	
	private static final long serialVersionUID = 1L;
       
	
	// FUNGSI WAJIB IMPLEMENTASI SERVLET
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("type").equals("registration")){
			
			// Ambil parameter request
			String username = request.getParameter("id");
			String email = request.getParameter("email");
			
			// JSON Object untuk response
			String responsetext;
			
			if (CheckUsername(username)){
				responsetext = "1";
			}
			else if (CheckEmail(email)){
				responsetext = "2";
			}
			else{
				String password = request.getParameter("password");
				String fullname = request.getParameter("fullname");
				String alamat = request.getParameter("alamat");
				String provinsi = request.getParameter("provinsi");
				String kota = request.getParameter("kota");
				String kodepos = request.getParameter("kodepos");
				String hp = request.getParameter("hp");
				int kp;
				int hape;
				
				if(!kodepos.equals(""))
						kp = Integer.parseInt(kodepos);
				else
						kp = 0;
				
			if(!hp.equals(""))
					hape = Integer.parseInt(kodepos);
			else
					hape = 0;
				
				AddUser(username, email, password, fullname, alamat, provinsi, kota, kp, hape);
				responsetext = GetData(username);
			}
			
			response.getWriter().write(responsetext);
		}
		else if (request.getParameter("type").equals("profile")){
			
			// Ambil parameter request
			String username = request.getParameter("id");	
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String alamat = request.getParameter("alamat");
			String provinsi = request.getParameter("provinsi");
			String kota = request.getParameter("kota");
			String kodepos = request.getParameter("kodepos");
			String hp = request.getParameter("hp");
			int kp;
			int hape;
				
			if(!kodepos.equals(""))
					kp = Integer.parseInt(kodepos);
			else
					kp = 0;
				
			if(!hp.equals(""))
					hape = Integer.parseInt(hp);
			else
					hape = 0;
				
			EditProfile(username, password, fullname, alamat, provinsi, kota, kp, hape);	
			
			response.getWriter().write("0");
		}
		else if (request.getParameter("type").equals("creditcard")){
			// Ambil parameter request
			int CreditCard = Integer.parseInt(request.getParameter("cardnum"));

			// Response
			String responsetext;
			
			if (CheckCredit(CreditCard)){
				responsetext = "1";
			}
			else{
				String id = request.getParameter("id");
				String cardname = request.getParameter("cardname");
				String expdate = request.getParameter("expdate");
				
			EditCCard(id, cardname, CreditCard, expdate);	
				
				responsetext = "0";
			}
						
			response.getWriter().write(responsetext);
		}
		else if (request.getParameter("type").equals("login")){
			String username = request.getParameter("id");	
			String password = request.getParameter("password");
			String responsetext = "";
			
			if(Login(username, password))
				responsetext = GetData(username);								
			else
				responsetext = "1";
			
			response.getWriter().write(responsetext);
		}
		else{
			response.getWriter().write("Unknown Type"); 		
		}
	}
	
	// FUNGSI EDIT
	// Akan memasukkan user baru di dalam database, namun informasi database masih kosong
	// Akan menghasilkan akun dengan privilege User
	private void AddUser(String id, String email, String password, String fullname, String alamat, String provinsi, String kota, int kodepos, int hp){
			
			// Variabel akses
			Connection conn = null;
			Statement stmt = null;	
			
			// Coba buka koneksi
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DBURL, USER, PASS);
				
				// Konstruksi query
				String query = "INSERT INTO user(id,email,password,full_name,alamat,provinsi,kotakabupaten,kodepos,nomor_handphone) VALUES ('" + id + "','" + email + "','" + password + "','" + fullname + "','" + alamat + "','" + provinsi + "','" + kota + "'," + kodepos + "," + hp + ")" ;
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

	// Akan memasukkan informasi tentang kartu kredit ke database user dengan id username
	private void EditCCard(String id, String creditname, int creditnum, String expired){
			// Variabel akses
			Connection conn = null;
			Statement stmt = null;	
				
			// Coba buka koneksi
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DBURL, USER, PASS);
						
				// Konstruksi query
				String query = "UPDATE user SET creditcardname = '" + creditname + "', creditcardnum = " + creditnum + ", expireddate = '" + expired + "' WHERE id='" + id + "'";
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

	// Melakukan edit profile terhadap user dengan id id
	private void EditProfile(String id, String password, String fullname, String alamat, String provinsi, String kota, int kodepos, int hp){
			// Variabel akses
			Connection conn = null;
			Statement stmt = null;	
				
			// Coba buka koneksi
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DBURL, USER, PASS);
						
				// Konstruksi query
				String query = "UPDATE user SET password = '" + password + "', full_name = '" + fullname + "', alamat = '" + alamat + "', provinsi= '" + provinsi + "', kotakabupaten = '" + kota + "', kodepos = " + kodepos + ", nomor_handphone = " + hp + " WHERE id='" + id + "'";	
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
		
	// FUNGSI PENGECEKAN
	// Mengembalikan true apabila telah terdapat user dengan id Username, false bila tidak
	private boolean CheckUsername(String Username){
			// Variabel akses
					Connection conn = null;
					Statement stmt = null;
					int Result = 0;
					
					// Coba buka koneksi
					try{
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DBURL, USER, PASS);
						
						// Konstruksi query
						String query = "SELECT COUNT(1) as hasil FROM user WHERE id = " + "'" + Username + "'";
						System.out.println(query);
						
						stmt = conn.createStatement();
						
						ResultSet rs = stmt.executeQuery(query);
						rs.next();
						Result = rs.getInt("hasil");
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
					
					if (Result == 1)
							return true;
					else
						return false;
		}	

	// Mengembalikan true apabila telah terdapat user dengan email Email, false bila tidak
	private boolean CheckEmail(String Email){
			// Variabel akses
			Connection conn = null;
			Statement stmt = null;
			int Result = 0;
			
			// Coba buka koneksi
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DBURL, USER, PASS);
				
				// Konstruksi query
				String query = "SELECT COUNT(1) as hasil FROM user WHERE email = " + "'" + Email + "'";
				System.out.println(query);
				
				stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				Result = rs.getInt("hasil");
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
			
			if (Result == 1)
					return true;
			else
				return false;
	}

	// Mengembalikan true apabila telah terdapat kartu kredit dengan nomor CreditCard, false bila tidak
	private boolean CheckCredit(int CreditCard){
				// Variabel akses
				Connection conn = null;
				Statement stmt = null;
				int Result = 0;
				
				// Coba buka koneksi
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DBURL, USER, PASS);
					
					// Konstruksi query
					String query = "SELECT COUNT(1) as hasil FROM user WHERE creditcardnum = " +  CreditCard;
					System.out.println(query);
					
					stmt = conn.createStatement();
					
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					Result = rs.getInt("hasil");
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
				
				if (Result == 1)
						return true;
				else
					return false;
			}

	// Login, mengembalikan true bila login berhasil dan false bila gagal
	private boolean Login(String id, String password){
		// Variabel akses
		Connection conn = null;
		Statement stmt = null;
		int Result = 0;
					
		// Coba buka koneksi
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DBURL, USER, PASS);
						
			// Konstruksi query
			String query = "SELECT COUNT(1) as hasil FROM user WHERE id = '" + id + "' AND password = '" + password + "'";
			System.out.println(query);
						
			stmt = conn.createStatement();
						
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			Result = rs.getInt("hasil");
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
					
		if (Result == 1)
				return true;
		else
			return false;
	}
		
	// FUNGSI PENGAMBILAN DATA
	// Mengembalikan data user dengan id tertentu
	private String GetData(String id){
		// Variabel akses
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String responsetext = "";
		
		// Coba buka koneksi
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DBURL, USER, PASS);
								
			// Konstruksi query
			String query = "SELECT * FROM user WHERE id = '" + id + "'";
			System.out.println(query);
								
			stmt = conn.createStatement();
								
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				responsetext = "0|";
				responsetext = responsetext + rs.getString("id")+"|";
				responsetext = responsetext + rs.getString("password")+"|";
				responsetext = responsetext + rs.getString("email")+"|";
				responsetext = responsetext + rs.getString("full_name")+"|";
				responsetext = responsetext + rs.getString("alamat")+"|";
				responsetext = responsetext + rs.getString("provinsi")+"|";
				responsetext = responsetext + rs.getString("kotakabupaten")+"|";
				responsetext = responsetext + rs.getInt("kodepos")+"|";
				responsetext = responsetext + rs.getInt("nomor_handphone")+"|";
				responsetext = responsetext + rs.getInt("creditcardnum")+"|";
				responsetext = responsetext + rs.getString("privilege")+"|";
				responsetext = responsetext + rs.getInt("transaction")+"|";
			}
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
		
		return responsetext;
	}
}
