package userController;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("includeJspContent", "register.jsp");
		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reg_nama = request.getParameter("reg_nama");
		String reg_email = request.getParameter("reg_email");
		String reg_username = request.getParameter("reg_username");
		String reg_password = request.getParameter("reg_password");
		String reg_alamat = request.getParameter("reg_alamat");
		String reg_provinsi = request.getParameter("reg_provinsi");
		String reg_kota = request.getParameter("reg_kota");
		String reg_kodepos = request.getParameter("reg_kodepos");
		String reg_telepon = request.getParameter("reg_telepon");

		String Query = "insert into account (username,password,nama,email,alamat,provinsi,kota,kodepos,telepon,role,transaksi) values (\""+reg_username+"\",\""+reg_password+"\",\""+reg_nama+"\",\""+reg_email+"\",\""+reg_alamat+"\",\""+reg_provinsi+"\",\""+reg_kota+"\",\""+reg_kodepos+"\",\""+reg_telepon+"\",\"1\",\"0\")";
        DBA.insertQuery(Query);
        response.sendRedirect("home");
	}

}
