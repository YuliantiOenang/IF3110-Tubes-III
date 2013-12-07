package controller.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import json.JSONObject;
import model.Barang;
import model.ShoppingCart;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/cart/delete")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id")!=null)
		{
			HttpSession session = request.getSession(true);
			ShoppingCart shop;
			if (session.getValue("shoppingcart")!=null)
				shop = (ShoppingCart)session.getValue("shoppingcart");
			else
				shop = new ShoppingCart();
			shop.deleteData((int)Integer.parseInt(request.getParameter("id")));
			session.putValue("shoppingcart", shop);
		}
		response.sendRedirect(request.getContextPath()+"/cart/shoppingcart");
	}

}
