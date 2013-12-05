package userController;

import java.io.IOException;

import javaModel.Credit;
import javaModel.Helper;
import javaModel.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class CreditController
 */
@WebServlet("/profile/credit")
public class CreditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseAdapter DBA = new DatabaseAdapter();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = Helper.getUserLogged(request.getSession());
		if (username.isEmpty()) {
			response.sendRedirect("/ruserba/register");
			return;
		}
		Integer userId = Helper.getUserId(request.getSession());
		String q2 = "select * from kredit where id_account = "+userId;
		Credit C = new Credit(DBA);
		C.executeQuery(q2);
		if (C.id.size() == 0) {
			C.id.add("");
			C.id_account.add(userId.toString());
			C.name_of_card.add("");
			C.card_number.add("");
			C.expired_date.add("");
		}
		
		request.setAttribute("credit", C);
		request.setAttribute("includeJspContent", "credit.jsp");
		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = Helper.getUserLogged(request.getSession());
		Integer userId = Helper.getUserId(request.getSession());
		
		String card_number = request.getParameter("card_number");
		String name_of_card = request.getParameter("name_of_card");
		String expired_date = request.getParameter("expired_date");
		String returnUrl = request.getParameter("returnUrl");

		String q2 = "insert into kredit (id_account, card_number, name_of_card, expired_date) values (\""+userId+"\",\""+card_number+"\",\""+name_of_card+"\",\""+expired_date+"\")";
        DBA.insertQuery(q2);
        if (returnUrl != null)
        	response.sendRedirect(returnUrl);
        else
        	response.sendRedirect("/ruserba/profile");
	}

}
