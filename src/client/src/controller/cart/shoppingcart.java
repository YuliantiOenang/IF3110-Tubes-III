package controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Render;
import model.ShoppingCart;

/**
 * Servlet implementation class shoppingcart
 */
@WebServlet("/cart/shoppingcart")
public class shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Render.isLogin(request, response)) {
			HttpSession session = request.getSession(true);
			ShoppingCart shop;
			if (session.getValue("shoppingcart")!=null)
				shop = (ShoppingCart)session.getValue("shoppingcart");
			else
				shop = new ShoppingCart();
			request.setAttribute("shoppingcart", shop);
			Render.Show(request, response, "../cart.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/register");
		}
	}

}
