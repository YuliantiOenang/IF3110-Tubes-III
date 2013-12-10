package localservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class welcomeHeader
 */
@WebServlet("/welcomeHeader")
public class welcomeHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcomeHeader() {
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
			result ="<div id='site_title'><h1><a href='index.jsp'>Welcome</a>, <a href='profile.jsp'>"+"</a></h1></div>";
		}
		else{
			result ="<div id='site_title'><h1><a href='index.jsp'>Ruko Serba Ada</a></h1></div>";
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
