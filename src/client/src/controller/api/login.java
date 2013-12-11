package controller.api;

import model.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.JSONObject;
import model.Kredit;

/**
 * Servlet implementation class login
 */
@WebServlet("/api/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name = request.getParameter("Login[username]");
		String user_pass = request.getParameter("Login[password]");
		JSONObject jsonobj = new JSONObject();
		PrintWriter out = response.getWriter();
		if (user_name.equals("admin")&&user_pass.equals("admin"))
		{
			jsonobj.put("success", true);
			jsonobj.put("admin", true);
		}
		else {
			Account model = new Account();
			int countN = model.findByCondition("username = '" + request.getParameter("Login[username]")+"'").size();
			int countP = model.findByCondition("password = '" + request.getParameter("Login[password]")+"'").size();
						
			if (countN==1&&countP==1){
				jsonobj.put("success", true);
				Cookie userCookie = new Cookie("username", user_name);
				userCookie.setMaxAge(60*60*24);
				userCookie.setPath(request.getContextPath());
				response.addCookie(userCookie);
			}
			else{
				jsonobj.put("success", false);
				jsonobj.put("admin", false);
			}
		}
		out.print(jsonobj);
	}

}
