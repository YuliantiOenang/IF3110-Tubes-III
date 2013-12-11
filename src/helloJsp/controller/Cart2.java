package helloJsp.controller;

import helloJsp.object.Item;
import helloJsp.object.ShoppingCart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart2")
public class Cart2 extends HttpServlet {

	public Cart2() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int quantity = 0, idItem = 0, stock = 0, price = 0, type = 0;
		String desc = "";

		type = Integer.parseInt(request.getParameter("type"));
		HttpSession session = request.getSession();

		if (type == 1) {
			quantity = Integer.parseInt(request.getParameter("quantity"));
			idItem = Integer.parseInt(request.getParameter("id"));
			desc = request.getParameter("desc");
			stock = Integer.parseInt(request.getParameter("stock"));
			price = Integer.parseInt(request.getParameter("price"));

			if (stock < quantity) {
				// fail
				out.println(-1);
			} else {
				try {
					ShoppingCart sc = new ShoppingCart();
					if (session.getAttribute("shoppingCart") != null)
						sc = (ShoppingCart) session.getAttribute("shoppingCart");
					sc.getItems().add(new Item(quantity, idItem, price, desc));
					if (session.getAttribute("shoppingCart") != null)
						session.removeAttribute("shoppingCart");
					session.setAttribute("shoppingCart", sc);
					out.println(1);
				} catch (Exception x) {
					out.println(0);
				}
			}
		} else if (type == 2) {
			ShoppingCart sc = new ShoppingCart();
			idItem = Integer.parseInt(request.getParameter("id"));
			if (session.getAttribute("shoppingCart") != null) {
				sc = (ShoppingCart) session.getAttribute("shoppingCart");
				sc.getItems().remove(idItem);
				if (session.getAttribute("shoppingCart") != null)
					session.removeAttribute("shoppingCart");
				session.setAttribute("shoppingCart", sc);
				out.println(idItem);
			} else
				out.println(-1);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
