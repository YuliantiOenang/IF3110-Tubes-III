package com.ruserba.web;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ruserba.model.Database;
import com.ruserba.model.User;
import com.ruserba.web.WebUtil;
import com.ruserba.model.Service;
 
public class LoginService extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doPost(request,response);
	}
 	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/plain");

		PrintWriter out = null;
		try	{
			out = response.getWriter();
		}
		catch (Exception ex) {}

		String username = request.getParameter("username"); if (username == null) username = "";
		String password = request.getParameter("password"); if (password == null) password = "";

		String[] paramName = new String[] { "username", "password" };
		String[] paramVal = new String[] { username, password };

		ArrayList<String> res = null;
		try	{
			res = Service.httpPost("login_service.php", paramName, paramVal);
		} catch (Exception ex) {}

		if (res.get(0).equals("1"))
		{
			Cookie id_cookie = new Cookie("id_user", res.get(1)); // Bad practice, but who cares? :p
			id_cookie.setPath("/"); id_cookie.setMaxAge(2592000);
			response.addCookie(id_cookie);

			Cookie username_cookie = new Cookie("username", res.get(2)); // Bad practice, but who cares? :p
			username_cookie.setPath("/"); username_cookie.setMaxAge(2592000);
			response.addCookie(username_cookie);
		}

		out.write(res.get(0) + "\n"); // No JSON, no XML, just pure "linebreak separated"...
	}
}
