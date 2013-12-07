package controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Render;
import model.Account;
import model.Order;
import model.OrderItem;
import model.ShoppingCart;

/**
 * Servlet implementation class SubmitCart
 */
@WebServlet("/cart/submit")
public class SubmitCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getValue("shoppingcart")!=null)
		{
			ShoppingCart shop = (ShoppingCart)session.getValue("shoppingcart");
			Order ordermodel = new Order();
			Account accountmodel = new Account();
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("username"))
					ordermodel.addValue("id_account",accountmodel.findByCondition("username = '" + cookies[i].getValue() + "'").firstElement().get("id"));
			}
			ordermodel.addValue("total", shop.getTotalPrice().toString());
			ordermodel.save();
			ordermodel.findAll();
			String idorder = ordermodel.getDataVector().lastElement().get("id");
			for (Integer barang : shop.getKeySet()) {
				OrderItem orderitemmodel = new OrderItem();
				orderitemmodel.addValue("id_order", idorder);
				orderitemmodel.addValue("id_barang", barang.toString());
				orderitemmodel.addValue("jumlah", shop.getJumlah(barang).toString());
				orderitemmodel.addValue("tambahan", shop.getKeterangan(barang).toString());
				orderitemmodel.save();
			}
			request.setAttribute("msg", "Terima kasih transaksi anda berhasil");
			Render.Show(request, response, "../message.jsp");
		}
		else
		{
			request.setAttribute("msg", "Maaf transaksi anda berhasil");
			Render.Show(request, response, "../message.jsp");
		}
	}

}
