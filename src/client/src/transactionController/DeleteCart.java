package transactionController;

import java.io.IOException;
import java.util.ArrayList;

import javaModel.Barang;
import javaModel.Helper;
import javaModel.Kategori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		boolean isLogin = false;
		if (session.getAttribute("isLogin")!=null)
			isLogin = (boolean)session.getAttribute("isLogin");
		
		if (isLogin) {
			ArrayList<String> s = (ArrayList<String>) session.getAttribute("dibeli");
			String id_b = request.getParameter("id");
			for (int i = 0; i < s.size(); i ++) {
				if (id_b.equals(s.get(i))) {
					s.remove(i);
					break;
				}
			}
			session.setAttribute ("dibeli", s);
			session.removeAttribute(id_b);
			response.sendRedirect("/ruserba/cart");
		} else {
			response.sendRedirect("home");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
