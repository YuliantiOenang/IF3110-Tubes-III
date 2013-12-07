package controller.api;

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
 * Servlet implementation class changeQuantity
 */
@WebServlet("/api/changeQuantity")
public class changeQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeQuantity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonobj = new JSONObject();
		if ((request.getParameter("nama_barang")!=null)&&(request.getParameter("quantity")!=null))
		{
			HttpSession session = request.getSession(true);
			ShoppingCart shop;
			if (session.getValue("shoppingcart")!=null) {
				Barang model = new Barang();
				model.findById((int)Integer.parseInt(request.getParameter("nama_barang")));
				if ((int)Integer.parseInt(request.getParameter("quantity"))<=(int)Integer.parseInt(model.getDataVector().firstElement().get("stok"))) {
					shop = (ShoppingCart)session.getValue("shoppingcart");
					jsonobj.put("status", true);
					shop.changeQuantity(Integer.parseInt(request.getParameter("nama_barang")), Integer.parseInt(request.getParameter("quantity")));
					session.putValue("shoppingcart", shop);
				}
				else
				{
					jsonobj.put("status", false);
					jsonobj.put("stok", model.getDataVector().firstElement().get("stok"));
				}
			}
			else
			{
				jsonobj.put("status", false);
				jsonobj.put("stok", 0);
			}
		}
		else
		{
			jsonobj.put("status", false);
			jsonobj.put("stok", 0);
		}
		
		PrintWriter out = response.getWriter();
		out.print(jsonobj);
	}

}
