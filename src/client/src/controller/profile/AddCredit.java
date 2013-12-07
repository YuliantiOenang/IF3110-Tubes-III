package controller.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import controller.Render;

/**
 * Servlet implementation class AddCredit
 */
@WebServlet("/credit")
public class AddCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCredit() {
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
		String id = account.findByCondition("nama='"+request.getParameter("Credit[name_of_card]")+"'").firstElement().get("id");
		account.updateSQL("INSERT INTO kredit (id_account, card_number, name_of_card, expired_date) "
				+ "VALUES ('" + id + "', '" +
				request.getParameter("Credit[card_number]") + "', '" +
				request.getParameter("Credit[name_of_card]") + "', '" +
				request.getParameter("Credit[expired_date]") + "'" +		
				")" );
		if (request.getParameter("habisitukesubmit")!=null)
		{
			response.sendRedirect(request.getContextPath()+"/cart/submit");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/home");
		}
	}

}
