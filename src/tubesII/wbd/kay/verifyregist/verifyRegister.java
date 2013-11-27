package tubesII.wbd.kay.verifyregist;

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

/**
 * Servlet implementation class verifyRegister
 */
@WebServlet(description = "To Verify the registration input", urlPatterns = { "/verifyRegister" })
public class verifyRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		Statement state1 = null;
		Statement state2 = null;
		Statement state3 = null;
		ResultSet uresult = null;
		ResultSet eresult = null;
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("namalengkap");
		String hpnum = request.getParameter("hpnum");
		String address = request.getParameter("address");
		String province = request.getParameter("province");
		String kecamatan = request.getParameter("kecamatan");
		String postcode = request.getParameter("postcode");
		int urowcount =0;
		int erowcount =0;
		try{
			String uname = "root";
			String pass = "";
			String url = "jdbc:mysql://localhost/progin_13511059";
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
				String regquery = "INSERT INTO `progin_13511059`.`user` (`username`, `nama_lengkap`, `password`, `email`, `handphone`, `address`, `province`, `state`, `postcode`) VALUES ('"+username+"','"+fullname+"','"+password+"','"+email+"','"+hpnum+"','"+address+"','"+province+"','"+kecamatan+"','"+postcode+"')";
				state3.executeUpdate(regquery);
				session.setAttribute("username", username);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("masuk sini");
		}
	}

}
