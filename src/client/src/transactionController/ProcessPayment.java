package transactionController;

import java.io.IOException;
import java.util.ArrayList;

import javaModel.Barang;
import javaModel.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class ProcessPayment
 */
@WebServlet("/cart/payment")
public class ProcessPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessPayment() {
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
			if (!Helper.isCreditCard(session)) {
				response.sendRedirect("/ruserba/profile/credit?returnUrl=/ruserba/cart/payment");
				return;
			}
			ArrayList<String> s = (ArrayList<String>) session.getAttribute("dibeli");
			
			for (int i = 0; i < s.size(); i ++) {
				String id_b = s.get(i);
				Barang B = new Barang (DBA);
				B.executeQuery("select * from barang where id = " + id_b);
				Integer stok = Integer.parseInt(B.stok.get(0));
				if (stok >= Integer.parseInt((String)session.getAttribute(id_b)))
				{
					System.out.println("Stok : "+stok+" pilih : "+Integer.parseInt((String)session.getAttribute(id_b)));
					stok = stok - Integer.parseInt((String)session.getAttribute(id_b));
					String q = "update barang set stok = " + stok + " where id = " + id_b;
					DBA.insertQuery(q);
					
				}else System.out.println("DEBUG, barang melebihi stok");
				session.removeAttribute(id_b);
			}
			String id_u = Helper.getUserId(session).toString();
			DBA.insertQuery("update account set transaksi = transaksi + 1 where id = " + id_u);
			session.removeAttribute("dibeli");
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
