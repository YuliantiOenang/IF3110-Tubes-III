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
		Kategori K = Helper.findAllKategori();
		request.setAttribute("kategoris", K);
		request.setAttribute("effect", !(Boolean.parseBoolean(request.getParameter("e"))));
		
		Map<Integer, Barang> topbarangs = new HashMap();
		for(int i = 0; i < K.id.size(); i++) {
			String q = "select * from barang where id_kategori = "+K.id.get(i)+" order by counter desc limit 0, 4";
			Barang B = new Barang(DBA);
			B.executeQuery(q);
			topbarangs.put(Integer.parseInt(K.id.get(i)), B);
		}
		
		request.setAttribute("topbarangs", topbarangs);
		
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
