package Data;

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
import com.google.gson.*;

/**
 * Servlet implementation class verifyRegister
 */
@WebServlet(description = "To Verify the registration input", urlPatterns = { "/verifyRegister" })
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
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
			//Connection con = DriverManager.getConnection ("jdbc:mysql://localhost/progin_13511059", "root", "");
			PrintWriter out =  response.getWriter();
			// End OF DONT CHANGE
			
			
			if(action.equals("insert")){
				// TODO customize for funtion 
				// FORMAT INPUT : action = register & parameters = username , nama_lengkap , password, email ,handphone , address , province , state , postcode , n_pembelian
				// FORMAT OUTPUT : {Status_operasi: Success/Failed}
				// Silahakan GOoogling explorasi syntax SQL untuk insert, soalnya beda sama con.executeSQL kalau gak salah con.updateSQL
				
				Statement statement = con.createStatement();
				
				String username = parameter[0];
				String fullname = parameter[1];
				String password = parameter[2];
				String email = parameter[3];
				String hpnum = parameter[4];
				String address = parameter[5];
				String province = parameter[6];
				String kecamatan = parameter[7];
				String postcode = parameter[8];
				
				String query = "INSERT INTO `user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) VALUES ('"+username+"','"+fullname+"','"+password+"','"+email+"','"+hpnum+"','"+address+"','"+province+"','"+kecamatan+"','"+postcode+"')";
				
				int status;
				status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
				
				
			}else if(action.equals("update")){
			
				Statement statement = con.createStatement();
				
				String username = parameter[0];
				String fullname = parameter[1];
				String password = parameter[2];
				String email = parameter[3];
				String hpnum = parameter[4];
				String address = parameter[5];
				String province = parameter[6];
				String kecamatan = parameter[7];
				String postcode = parameter[8];
				
				String query = "UPDATE `user` SET nama_lengkap='"+fullname+"', password='"+password+"', handphone="+hpnum+", address='"+address+"', province='"+province+"', state='"+kecamatan+"', postcode ="+postcode+", email='"+email+"'  WHERE username= '"+ username+"'";
				
				
				int status = statement.executeUpdate(query);
				
				if(status==1){
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
				
			}else if(action.equals("login")){
			
				Statement statement = con.createStatement();
				
				String username = parameter[0];
				String password = parameter[1];
				boolean status = false;
				
				ResultSet rs = null;
				
				rs = statement.executeQuery("SELECT * FROM user where username ='"+username+"' AND password = '"+password+"'");
				status = rs.next();
				
				if (status)
					out.print("{ \"Status_operasi\" : \"berhasil\" , \"Username\" : \""+username+"\"}");
				else
					out.print("{ \"Status_operasi\" : \"gagal\" }");
					
			}else if(action.equals("find")){
				Statement statement = con.createStatement();
				
				String username = parameter[0];
				
				boolean status = false;
				//ResultSet rs = null;
				
				ResultSet rs = statement.executeQuery("SELECT * FROM user where username ='"+username+"'");
				
				
				
				
				/*
				ArrayList<String> HasilQuery_username= new ArrayList<>();
				ArrayList<String> HasilQuery_nama_lengkap= new ArrayList<>();
				ArrayList<String> HasilQuery_password= new ArrayList<>();
				ArrayList<String> HasilQuery_email= new ArrayList<>();
				ArrayList<String> HasilQuery_handphone= new ArrayList<>();
				ArrayList<String> HasilQuery_address= new ArrayList<>();
				ArrayList<String> HasilQuery_province= new ArrayList<>();
				ArrayList<String> HasilQuery_state= new ArrayList<>();
				ArrayList<String> HasilQuery_postcode= new ArrayList<>();
				*/
				ArrayList<user_data> List_User_data = new ArrayList<>();

				while(rs.next()){
					user_data UD = new user_data();
					
					out.print(rs.getObject(1).toString());
					
					UD.setUsername(rs.getObject(1).toString());
					UD.setNama_lengkap(rs.getObject(2).toString());
					UD.setPassword(rs.getObject(3).toString());
					UD.setEmail(rs.getObject(4).toString());
					UD.setHandphone(rs.getObject(5).toString());
					UD.setAddress(rs.getObject(6).toString());
					UD.setProvince(rs.getObject(7).toString());
					UD.setState(rs.getObject(8).toString());
					UD.setPostcode(rs.getObject(9).toString());
					UD.setN_pembelian(rs.getObject(10).toString());

					

					List_User_data.add(UD);
					/*
					HasilQuery_username.add();
					HasilQuery_nama_lengkap.add((String) rs.getObject(2));
					HasilQuery_password.add((String) rs.getObject(3));
					HasilQuery_email.add((String) rs.getObject(4));
					HasilQuery_handphone.add((String) rs.getObject(5));
					HasilQuery_address.add((String) rs.getObject(6));
					HasilQuery_province.add((String) rs.getObject(7));
					HasilQuery_state.add((String) rs.getObject(8));
					HasilQuery_postcode .add((String) rs.getObject(9));
					*/
				}
				
				
				//Convert Java Object into JSON object
				Gson gson = new Gson();
				
				String output = gson.toJson(List_User_data);
				status = List_User_data.isEmpty();
				if (!status)
					out.print("{ \"Status_operasi\" : \"berhasil\" , \"hasil\" : "+output+"  }");
				else
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				
			}
		}catch(Exception e){
			
		}
	}

	/*
	 * USED for data
	 * */
	
	
		
		
		
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
