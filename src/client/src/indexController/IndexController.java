package indexController;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javaModel.Barang;
import javaModel.Helper;
import javaModel.Kategori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class Home
 */
@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();
    private Cookie[] cookies;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Config.GlobalConfig.cekLogin(request, response);
		request.setAttribute("effect", !(Boolean.parseBoolean(request.getParameter("e"))));
		
		Map<Integer, Barang> topbarangs = new HashMap<Integer, Barang>();
		Barang B = new Barang(DBA);
		B.findTopThreeRest();
		
		request.setAttribute("topbarangs", B);
		
		request.setAttribute("includeJspContent", "index.jsp");
		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
