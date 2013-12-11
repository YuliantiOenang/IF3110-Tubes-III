package controller.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.JSONObject;
import model.Account;
import model.Barang;

/**
 * Servlet implementation class stokCukup
 */
@WebServlet("/api/stokCukup")
public class stokCukup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stokCukup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        JSONObject jsonobj = new JSONObject();
        
		Barang model = new Barang();
		model.findById((int)Integer.parseInt(request.getParameter("id_barang")));
		if ((int)Integer.parseInt(request.getParameter("quantity"))<=(int)Integer.parseInt(model.getDataVector().firstElement().get("stok")))
			jsonobj.put("status", true);
		else
		{
			jsonobj.put("status", false);
			jsonobj.put("stok", model.getDataVector().firstElement().get("stok"));
		}
		
		PrintWriter out = response.getWriter();
		out.print(jsonobj);
	}

}
