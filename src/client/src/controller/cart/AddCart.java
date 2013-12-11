package controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/cart/addcart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ((request.getParameter("id_barang")!=null)&&(request.getParameter("quantity")!=null)&&(request.getParameter("req_msg")!=null))
		{
			HttpSession session = request.getSession(true);
			ShoppingCart shop;
			if (session.getValue("shoppingcart")!=null)
				shop = (ShoppingCart)session.getValue("shoppingcart");
			else
				shop = new ShoppingCart();
			shop.addData((int)Integer.parseInt(request.getParameter("id_barang")), (int)Integer.parseInt(request.getParameter("quantity")), request.getParameter("req_msg"));
			session.putValue("shoppingcart", shop);
			ShoppingCart shopval = (ShoppingCart)session.getValue("shoppingcart");
		}
		response.sendRedirect(request.getContextPath() + "/cart/shoppingcart");
	}

}
