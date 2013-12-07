package controller.profile;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Render;
import model.Account;
import model.Order;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/profile/edit")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String,String> data;
	private Account account;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Dummy
				data = new HashMap<String,String>();
				Cookie userCookie = new Cookie("username", "sonny");
				userCookie.setMaxAge(60*60*24);
				response.addCookie(userCookie);
				//Dummy
				
				//Account usr = new Account();
				account = new Account();
				Order ord = new Order();
				int ordercount;
				Cookie[] cookies = null;
				cookies = request.getCookies();
				if (cookies != null){
					for (int i=0; i<cookies.length; i++){
						if (cookies[i].getName().equals("username")){
							data = account.findByCondition("username='"+cookies[i].getValue()+"'").firstElement();
						}
					}
				}
				if (data.isEmpty()) {
					RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
					view.forward(request, response); 
				}
				else{
				request.setAttribute("model", data);
				Render.Show(request, response, "../profile_edit.jsp");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
