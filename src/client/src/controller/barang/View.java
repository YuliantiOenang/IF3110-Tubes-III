package controller.barang;

import model.*;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Render;

/**
 * Servlet implementation class View
 */
@WebServlet("/barang/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id")!=null) {
			Barang model = new Barang();
			model.findById((int)Integer.parseInt(request.getParameter("id")));
			model.formatAllCurrency();
			request.setAttribute("model", model.getDataVector().firstElement());
			Render.Show(request, response, "../barang.jsp");
		}
		else
		{
			
		}
	}

}
