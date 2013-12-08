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
				
				String query = "INSERT INTO `progin_13511059`.`user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) VALUES ('"+username+"','"+fullname+"','"+password+"','"+email+"','"+hpnum+"','"+address+"','"+province+"','"+kecamatan+"','"+postcode+"')";
				
				int status;
				status = statement.executeUpdate(query);
				
				if(status==0){
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
				
				String query = "UPDATE `progin_13511059`.`user` SET nama_lengkap='"+fullname+"', password='"+password+"', handphone="+hpnum+", address='"+address+"', province='"+province+"', state='"+kecamatan+"', postcode ="+postcode+" WHERE username= '"+ session.getAttribute("username")+"'";
				
				int status;
				status = statement.executeUpdate(query);
				
				if(status==0){
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
				
				rs = executeQuery("SELECT * FROM user where username ='"+username+"' AND password = '"+password+"'");
				status = rs.next();
				
				if (status)
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				else
					out.print("{ \"Status_operasi\" : \"gagal\" }");
					
			}else if(action.equals("find")){
				Statement statement = con.createStatement();
				
				String username = parameter[0];
				
				boolean status = false;
				ResultSet rs = null;
				
				rs = executeQuery("SELECT * FROM user where username ='"+username+"'");
				status = rs.next();
				
				if (status)
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				else
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				
			}
		}catch(Exception e){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
