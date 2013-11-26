package tubesII.wbd.kay.editShopCart;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class editShopCart
 */
@WebServlet("/editShopCart")
public class editShopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editShopCart() {
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
		HttpSession session = request.getSession();
		Vector<String> shopping_cart = (Vector<String>) session.getAttribute("shopping_cart");
		Vector<String> shopping_request = (Vector<String>) session.getAttribute("shopping_request");
		Vector<Integer> item= (Vector<Integer>) session.getAttribute("amount");
		for(int i = 0; i < shopping_cart.size();i++){
			int newAmount = Integer.parseInt(request.getParameter(""+i));
			item.setElementAt(newAmount,i);
		}
		session.setAttribute("amount", item);
		String url = "/shoppingbag.jsp";
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
