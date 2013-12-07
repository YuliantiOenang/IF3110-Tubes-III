package adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class DeleteBarang
 */
@WebServlet("/admin/deletebarang")
public class DeleteBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			
			HttpSession session = request.getSession();
			
			boolean isLogin;
			if (session.getAttribute("isLogin")!=null)
				isLogin = (boolean)session.getAttribute("isLogin");
			else
				isLogin = false;
			
			if (isLogin)
			{
				DBA.deleteQuery("delete from barang where id="+request.getParameter("id"));
				json.put("content", "OK");
			}
			else
				json.put("content", "zzzz");
			out.write(json.toString());
			out.close();
			//response.sendRedirect("/ruserba/admin/");
		}catch (Exception e){System.out.println(e.getMessage());}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
