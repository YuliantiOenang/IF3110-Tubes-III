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
public class creditcard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creditcard() {
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
				
				String cardnum = parameter[0];
				String namecard = parameter[1];
				String expdate = parameter[2];
				
				String query = "INSERT INTO `progin_13511059`.`creditcard` (`card_id`, `card_nameon`, `card_expdate`, `card_owner`) VALUES ('"+cardnum+"','"+namecard+"', '"+expdate+"', '"+session.getAttribute("username")+"')";
				
				int status;
				status = statement.executeUpdate(query);
				
				if(status==0){
					out.print("{ \"Status_operasi\" : \"berhasil\" }");
				}else{
					out.print("{ \"Status_operasi\" : \"gagal\" }");
				}
				
				
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
