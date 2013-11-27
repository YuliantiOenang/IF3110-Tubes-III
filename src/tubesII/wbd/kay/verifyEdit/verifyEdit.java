package tubesII.wbd.kay.verifyEdit;

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
 * Servlet implementation class verifyEdit
 */
@WebServlet("/verifyEdit")
public class verifyEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyEdit() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		Statement state = null;
		Statement state1 = null;
		ResultSet result = null;
		
		String password = request.getParameter("password");
		String fullname = request.getParameter("namalengkap");
		String hpnum = request.getParameter("hpnum");
		String address = request.getParameter("address");
		String province = request.getParameter("province");
		String kecamatan = request.getParameter("kecamatan");
		String postcode = request.getParameter("postcode");
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
			state = con.createStatement();
			result = state.executeQuery("SELECT * FROM `progin_13511059`.user WHERE password = '"+password+"' AND nama_lengkap = '"+fullname+"' AND handphone = '"+hpnum+"' AND address= '"+address+"' AND province = '"+province+"' AND state = '"+kecamatan+"' AND postcode='"+postcode+"'");
			if(result.next()){
				out.print("The data is still the same");
			}
			else{
				state1 = con.createStatement();
				String regquery = "UPDATE `progin_13511059`.`user` SET nama_lengkap='"+fullname+"', password='"+password+"', handphone="+hpnum+", address='"+address+"', province='"+province+"', state='"+kecamatan+"', postcode ="+postcode+" WHERE username= '"+ session.getAttribute("username")+"'";
				state1.executeUpdate(regquery);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("masuk sini");
		}
	}

}
