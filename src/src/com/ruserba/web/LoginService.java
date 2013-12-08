package com.ruserba.web;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.sql.SQLException;

import com.ruserba.model.Database;
import com.ruserba.model.User;
import com.ruserba.web.WebUtil;
 
public class LoginService extends HttpServlet
{
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
		Database db = WebUtil.getDatabase(getServletContext());

		String msg_out;

		User user;
		try
		{
			user = db.getUserDataFromUsername(username);
		}
		catch(Exception ex)
		{
			user = null;
		}

		if (user != null)
		{
			MessageDigest md = null;
			try
			{
				md = MessageDigest.getInstance("MD5");
			}
			catch(Exception ex)
			{
				md = null;
			}
			md.update(password.getBytes());
			byte pass_byte[] = md.digest();
	 
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < pass_byte.length; i++) {
				sb.append(Integer.toString((pass_byte[i] & 0xff) + 0x100, 16).substring(1));
			}

			String password_hash = sb.toString();

			if (password_hash.equals(user.getPassword()))
			{
				Cookie id_cookie = new Cookie("id_user", Integer.toString(user.getIdUser())); // Bad practice, but who cares? :p
				id_cookie.setPath("/"); id_cookie.setMaxAge(2592000);
				response.addCookie(id_cookie);

				Cookie username_cookie = new Cookie("username", user.getUsername()); // Bad practice, but who cares? :p
				username_cookie.setPath("/"); username_cookie.setMaxAge(2592000);
				response.addCookie(username_cookie);
				msg_out = "1";
			}
			else
			{
				msg_out = "0";
			}
		}
		else
		{
			msg_out = "0";
		}
		out.write(msg_out + "\n"); // No JSON, no XML, just pure "linebreak separated"...
	}
}
