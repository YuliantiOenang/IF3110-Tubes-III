package tubesII.wbd.kay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tubesII.wbd.GlobalConfig;
import org.json.*;
/**
 * Servlet implementation class verifyRegister
 */
@WebServlet(description = "To Verify the registration input", urlPatterns = { "/verifyRegister" })
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			/*EXAMPLE CODE*/
			/*Used for query .. DONT CHANGE THIS LINES*/
			String action=request.getParameter("action");
			String parameters=request.getParameter("parameters").trim();
			String parameter[]=parameters.split(",");
			GlobalConfig GC = new GlobalConfig();
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			Connection con = DriverManager.getConnection (GC.geturl(), GC.getuser(), GC.getpass());
			PrintWriter out =  response.getWriter();
			// End OF DONT CHANGE
			
			
			if(action.equals("register")){
				// TODO customize for funtion 
				// FORMAT INPUT : action = register & parameters = username , nama_lengkap , password, email ,handphone , address , province , state , postcode , n_pembelian
				// FORMAT OUTPUT : {Status_operasi: Success/Failed}
				// Silahakan GOoogling explorasi syntax SQL untuk insert, soalnya beda sama con.executeSQL kalau gak salah con.updateSQL
				
				Statement statement = con.createStatement();
				
				String username=parameter[0];
				String nama_lengkap=parameter[1];
				String password = parameter[2];
				String email = parameter[3];
				String handphone = parameter[4];
				
				int status;
				status = statement.executeUpdate("INSERT INTO user ('username','nama_lengkap') VALUES ");
				
				if(status==0){
					out.print("{ \"Status_operasi\" : \"Berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
				
				
			}else if(action.equals("login")){
				//Create specific query for specific purpose
				// In this section we want if the register function return an JSON object :
				// Format contoh OUTPUT :{"Status_Login":"berhasil","username":"codename"}
				// Base logic : Kalau kita nerima parameter 1 dan 2 berupa username dan password kemudian kita search ke database
				// ditemukan username dan password yang bersesuaian dengan parameter2 nya (memiliki one row result) 
				// jika empty set berarti invalid login.
				
				
				Statement statement=con.createStatement(); // persiapan untuk membuat query sql
				
				// Diasumsikan kita membuat "konvensi" dengan orang yang mengurus klien, misal dalam kasus ini 
				// orang yang mengurus bagian "klien" akan mengirim isi variable berformat = action=login&parameters=username,password
				// sehingga hasil split variable, parameter ke 0 akan berisi username, dan kedua berisi password
				String username=parameter[0];
				String password=parameter[1];
				ResultSet rs = statement.executeQuery("SELECT username FROM user where username ='"+username+"' AND password = '"+password+"'"); 
				
				ArrayList<String> HasilQuery_username= new ArrayList<>();
				
				while(rs.next()){
					HasilQuery_username.add((String) rs.getObject(1)); 
					// karena kita hanya menggunakan / mengambil username 'lihat kita bukan melakukan operasi SELECT *
					// Maka sesuai urutan pada notasi di database, username ada pada kolom pertama dalam tabel user
					// sehingga parameter get object bernilai 1
				}
				
				
				// LOGIKA PASCA Koneksi ke database
				if(HasilQuery_username.isEmpty()){ // kalau kosong berarti tidak ditemukan username dan password yang bersesuaian
					out.print("{ \"Status_login\" : \"Failed\" , \"username\" : \"\"}");
				}else{
					out.print("{ \"Status_login\" : \"Success\" , \"username\" : \""+HasilQuery_username.get(0)+"\"}");
				}
				/*
				 * Cara nge "output.print" itu cara primitif, caranya pasti melelahkan, kalau mau cepet coba eksplorasi command-comand  
				 * dibawah..ini ..
				 *  - JSONArray ==> Googling ! ini kalau gak salah konversi dari array list terus konvert ke array versi json
				 *  - JSONObject ==> Googling ! ini kalau gak salah konversi dari object java ke array 
				 * 
				 *  BErikut contoh penggunaan *kalau gak salah ya....
				 * ArrayList<String> AL = new ArrayList<String>();
				 *	try{
				 * 		
				 *	    Connection con = DriverManager.getConnection (GC.geturl(), GC.getuser(), GC.getpass());
				 *	    Statement state1 = con.createStatement();
				 *	    ResultSet uresult = state1.executeQuery("SELECT * FROM user");
				 *	    while(uresult.next()){
				 *				out.println(uresult.getObject(1)+"<br>");
				 *				AL.add((String) uresult.getObject(1));
				 *		}
				 *
				 *		JSONArray myjson = new JSONArray(AL);
				 *		out.print(myjson.toString());
				 *		out.print(myjson);
				 *	}catch (Exception e){
				 *		e.getMessage();
				 *	}
				 * 
				 * 
				*/
				
			}else if(action.equals("cek_pernah_daftar")){
				// TODO customize for funtion 
				// FORMAT INPUT :
				// FORMAT OUTPUT :				
			}else if(action.equals("update_profile")){
				
			}
		}catch(Exception e){
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GlobalConfig GC = new GlobalConfig();
		Connection con = null;
		Statement state1 = null;
		Statement state2 = null;
		Statement state3 = null;
		ResultSet uresult = null;
		ResultSet eresult = null;
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		// String password = request.getParameter("password");
		// String fullname = request.getParameter("namalengkap");
		// String hpnum = request.getParameter("hpnum");
		// String address = request.getParameter("address");
		// String province = request.getParameter("province");
		// String kecamatan = request.getParameter("kecamatan");
		// String postcode = request.getParameter("postcode");
		int urowcount =0;
		int erowcount =0;
		try{
			String uname = GC.getuser();
			String pass = GC.getpass();
			String url = GC.geturl();
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	        con = DriverManager.getConnection (url, uname, pass);
		}
		catch(Exception e){
			System.out.println("Cannot connect to database "+ e.getMessage());
			out.print("We're currently Unable to access the database. Please try again Later.");
		}
		try{
			state1 = con.createStatement();
			state2 = con.createStatement();
			state3 = con.createStatement();
			uresult = state1.executeQuery("SELECT * FROM user where username ='"+username+"'");
			eresult = state2.executeQuery("SELECT * FROM user where email ='"+email+"'");
			while(uresult.next()){
				System.out.println(uresult.getObject(1));
				urowcount++;
			}
			while(eresult.next()){
				System.out.println(eresult.getObject(1));
				erowcount++;
			}
			if(urowcount!=0){
				out.print(username+" is not a valid username");
			}
			if(erowcount != 0){
				out.print("The Email is already taken");
			}
			else{
				// String regquery = "INSERT INTO `progin_13511059`.`user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) VALUES ('"+username+"','"+fullname+"','"+password+"','"+email+"','"+hpnum+"','"+address+"','"+province+"','"+kecamatan+"','"+postcode+"')";
				// state3.executeUpdate(regquery);
				// session.setAttribute("username", username);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("masuk sini");
		}
	}

}
