package controller.profile;

import model.*;

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

/**
 * Servlet implementation class profileController
 */
@WebServlet("/profile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String,String> data;
	private Account account;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
					String id = account.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("id");
					/*
					String nama = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("nama");
					String username = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("username");
					String email = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("email");
					String alamat = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("alamat");
					String provinsi = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("provinsi");
					String kota = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("kota");
					String kodepos = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("kodepos");
					String name = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("nama");
					String telepon = usr.findByCondition("username='"+cookies[i].getValue()+"'").firstElement().get("telepon");
					*/
					ordercount=ord.findByCondition("id_account='"+id+"'").size();
					request.setAttribute("order_count", ordercount);
				}
			}
		}
		if (data.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
			view.forward(request, response); 
		}
		else{
		request.setAttribute("model", data);
		Render.Show(request, response, "profile.jsp");
		}
	}

}
