package localservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getNavbar
 */
@WebServlet("/getNavbar")
public class getNavbar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getNavbar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String query = "QUERY UNTUK SESSION INI JING";
		String result = "";
		//INI NANTI MINTA DARI SERVLET
		if(true){
			//KALAU SESINYA ADA
			result +="<div id='site_title'><h1><a href='index.jsp'>Welcome</a>, <a href='profile.jsp'>"+"</a></h1></div>";
		}
		else{
			result +="<li><a href='registercreditcard.jsp'> Register Credit Card </a></li><li><a href='shoppingbag.jsp'> Shopping Bag </a></li><li><a href='profile.jsp'>Profile</a></li>";
			if(true){
				//KALAU SESINYA ADMIN
				result +="<li><a href='kategori.jsp?laman=1&id=1'>Admin Barang</a></li>";
			}
			result += "<li><a href='logout.jsp'>Log out</a></li>";
		}
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
