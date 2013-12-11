package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import controller.Render;

/**
 * Servlet implementation class AdminDelete
 */
@WebServlet("/admin/delete")
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Model model2 = new Model("barang");
			String command;
			command = "DELETE FROM barang WHERE id = " + id + ";";
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
