package controller.profile;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Render;

/**
 * Servlet implementation class InputProfile
 */
@WebServlet("/InputProfile")
public class InputProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Account accounta;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //String c request.getParameter("string");  
	     PrintWriter out = response.getWriter();  
	     out.println("test");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie userCookie = new Cookie("username", "sonny");
		userCookie.setMaxAge(60*60*24);
		response.addCookie(userCookie);
		//Dummy
		String usrname;
		
		//Account usr = new Account();
		accounta = new Account();
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null){
			for (int i=0; i<cookies.length; i++){
				if (cookies[i].getName().equals("username")){
					usrname=cookies[i].getValue();
					//accounta.updateSQL("UPDATE account SET nama='test2' WHERE username='"+ usrname +"'");
					accounta.updateSQL("UPDATE account SET nama='"+request.getParameter("Profile[nama]")+"' , "+
							"password='" + request.getParameter("Profile[confirm]") + "' , "+
							"alamat='" + request.getParameter("Profile[alamat]") + "' , "+
							"provinsi='" + request.getParameter("Profile[provinsi]") + "' , "+
							"kota='" + request.getParameter("Profile[kota]") + "' , "+
							"kodepos='" + request.getParameter("Profile[kodepos]") + "' , "+
							"telepon='" + request.getParameter("Profile[telepon]") + "'  "+
							" WHERE username='"+ usrname + "'");
				}
			}
		}
		//Render.Show(request, response, "profile.jsp");
		response.sendRedirect(request.getContextPath()+"/profile");
	}

}

