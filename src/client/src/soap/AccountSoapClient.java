package soap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountSoapClient
 */
@WebServlet("/AccountSoapClient")
public class AccountSoapClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSoapClient() {
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
		AccountSoapProxy asp = new AccountSoapProxy();
		String username = request.getParameter("reg_username");
		String password = request.getParameter("reg_password");
		String nama = request.getParameter("reg_nama");
		String email = request.getParameter("reg_email");
		String alamat = request.getParameter("reg_alamat");
		String provinsi = request.getParameter("reg_provinsi"); 
		String kota = request.getParameter("reg_kota"); 
		String kodepos = request.getParameter("reg_kodepos"); 
		String telepon = request.getParameter("reg_telepon"); 
		Integer role = 1;
		Integer transaksi = 0;
		asp.createAcc(username, password, nama, email, alamat, provinsi, kota, kodepos, telepon, role, transaksi);
		response.sendRedirect("/ruserba");
	}

}
