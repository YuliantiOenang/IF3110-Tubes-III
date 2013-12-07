package controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.Kredit;
import controller.Render;

/**
 * Servlet implementation class CartProcessing
 */
@WebServlet("/cart/process")
public class CartProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartProcessing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Render.setLogin(request, response);
		if (request.getAttribute("_pre_userid")!=null)
		{
			Account model = new Account();
			model.findByCondition("username = '" + request.getAttribute("_pre_userid") + "'");
			if (model.getDataCount()==1)
			{
				Kredit kredit = new Kredit();
				if (kredit.findByCondition("id_account = " + model.getDataVector().firstElement().get("id")).size()==1)
				{
					response.sendRedirect(request.getContextPath() + "/cart/submit");
				}
				else
				{
					request.setAttribute("habisitukesubmit", true);
					Render.Show(request, response, "../credit.jsp");
				}
			}
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}


}
