package tubesII.wbd.kay.addCart;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class addChart
 */
@WebServlet("/addCart")
public class addCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCart() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id_barang = request.getParameter("id_barang");
		String req = request.getParameter("request_tambahan");
		int Quantity = Integer.parseInt(request.getParameter("qt"));
		if(session.getAttribute("shopping_cart")==null){
			Vector<String> nshopping_cart = new Vector<String>();
			Vector<String> nshopping_request = new Vector<String>();
			Vector<Integer> nitem= new Vector<Integer>();
			session.setAttribute("shopping_cart", nshopping_cart);
			session.setAttribute("shopping_request", nshopping_request);
			session.setAttribute("amount", nitem);
		}
		Vector<String> shopping_cart = (Vector<String>) session.getAttribute("shopping_cart");
		Vector<String> shopping_request = (Vector<String>) session.getAttribute("shopping_request");
		Vector<Integer> item= (Vector<Integer>) session.getAttribute("amount");
		shopping_cart.add(id_barang);
		shopping_request.add(req);
		item.add(Quantity);
		session.setAttribute("shopping_cart", shopping_cart);
		session.setAttribute("shopping_request", shopping_request);
		session.setAttribute("amount", item);
		String url = "/index.jsp";
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
