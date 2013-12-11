package controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Barang;
import model.Kategori;
import controller.Render;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admin/home")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Kategori model = new Kategori();
		model.findAll();
		int i = 0;
		for (HashMap<String, String> elmt : model.getDataVector()) {
			int j = 0;
			Barang brg = new Barang();
			brg.getFourBestCategory(Integer.parseInt(elmt.get("id")));
			for (HashMap<String, String> brg_elmt : brg.getDataVector()) {
				request.setAttribute("_cat_" + i + "_best_"+j,brg_elmt);
				j++;
			}
			i++;
		}
		Render.Show(request, response,"../adminhome.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
