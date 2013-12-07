package controller.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Render;
import model.Account;

/**
 * Servlet implementation class SubmitRegister
 */
@WebServlet("/SubmitRegister")
public class SubmitRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRegister() {
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
		Account account = new Account();
		account.updateSQL("INSERT INTO account (username, password, nama, email, alamat, provinsi, kota, kodepos, telepon) "
				+ "VALUES ('" + request.getParameter("Register[username]") + "', '" +
				request.getParameter("Register[confirm]") + "', '" +
				request.getParameter("Register[nama]") + "', '" +
				request.getParameter("Register[email]") + "', '" +
				request.getParameter("Register[alamat]") + "', '" +
				request.getParameter("Register[provinsi]") + "', '" +
				request.getParameter("Register[kota]") + "', '" +
				request.getParameter("Register[kodepos]") + "', '" +
				request.getParameter("Register[telepon]") + "'" +		
				")" );
		request.setAttribute("card_name", request.getParameter("Register[nama]"));
		Render.Show(request, response, "credit.jsp");
		//response.sendRedirect(request.getContextPath()+"/credit");
	}

}
