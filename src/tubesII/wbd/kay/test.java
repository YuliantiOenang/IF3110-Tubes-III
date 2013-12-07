package tubesII.wbd.kay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tubesII.wbd.GlobalConfig;
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
		// TODO Auto-generated method stub
		PrintWriter out =  response.getWriter();
		GlobalConfig GC = new GlobalConfig();
		out.print("Diakses dari halaman test metode get");
		out.print("Username mysql:"+ GC.getuser());
		out.print("PASS  mysql:"+ GC.getpass());
		out.print("URL mysql:"+ GC.geturl());
		
		//Contoh query mysql
		out.print("<h1>Contoh query myqsl</h1><br>SELECT:");

		ArrayList<String> AL = new ArrayList<String>();
		try{
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		    Connection con = DriverManager.getConnection (GC.geturl(), GC.getuser(), GC.getpass());
		    Statement state1 = con.createStatement();
		    ResultSet uresult = state1.executeQuery("SELECT * FROM user");
		    while(uresult.next()){
					out.println(uresult.getObject(1)+"<br>");
					AL.add(uresult.getObject(1));
			}
			JSONArray myjson = new JSONArray(AL);
			out.print(myjson.toString());
			out.print(myjson);
		}catch (Exception e){
			e.getMessage();
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
