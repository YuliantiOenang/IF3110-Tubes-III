package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Barang;
import model.Model;
import controller.Render;

/**
 * Servlet implementation class AdminEdit
 */
@WebServlet("/admin/edit")
public class AdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Barang model = new Barang();
		model.findById((int)Integer.parseInt(request.getParameter("id")));
		model.formatAllCurrency();
		request.setAttribute("model", model.getDataVector().firstElement());
		Render.Show(request, response, "../adminbarang.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Barang model = new Barang();
		model.findById((int)Integer.parseInt(request.getParameter("id")));
		request.setAttribute("model", model.getDataVector().firstElement());
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String nama = request.getParameter("nama");
			System.out.println(1);
			String harga = request.getParameter("harga");
			String deskripsi = request.getParameter("deskripsi");
			int stok = Integer.parseInt(request.getParameter("stok"));
			System.out.println(2);
			Model model2 = new Model("barang");
			String command;
			command = "UPDATE barang SET nama = '" + nama + "', harga = " + harga + ", stok = " + stok + ",keterangan = '" + deskripsi +  "' WHERE id = " + id + ";";
			//System.out.println(command);
			model2.updateSQL(command);
			request.setAttribute("msg", "Changes have been made successfully, keep up the good work!");
			Render.Show(request, response, "../adminpesan.jsp");
		}
		catch (Exception e){
			//response.getWriter().println("Failed");
			request.setAttribute("msg", "Failed to apply changes, try again!");
			Render.Show(request, response, "../adminpesan.jsp");
		}
	}

}
