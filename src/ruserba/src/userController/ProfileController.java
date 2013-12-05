package userController;

import java.io.IOException;
import java.io.PrintWriter;

import javaModel.Helper;
import javaModel.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.group.Response;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class Profile
 */
@WebServlet({"/profile/index", "/profile"})
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DatabaseAdapter DBA = new DatabaseAdapter();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("ignore")==null)
			if (!Helper.isCreditCard(request.getSession())) {
				response.sendRedirect("/ruserba/profile/credit");
				return;
			}
		String username = Helper.getUserLogged(request.getSession());
		if (username.isEmpty()) {
			response.sendRedirect("/ruserba/register");
			return;
		}
		String q = "select * from account where username = '" + username  + "' limit 1";
		Profile P = new Profile(DBA);
		P.executeQuery(q);
		request.setAttribute("profile", P);
		request.setAttribute("includeJspContent", "profile.jsp");
		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
