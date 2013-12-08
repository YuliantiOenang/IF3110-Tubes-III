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
 
public class CheckUsernameService extends HttpServlet
{
 	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/plain");

		PrintWriter out = null;
		try	{
			out = response.getWriter();
		}
		catch (Exception ex) {}

		String username = request.getParameter("username");
		String msg;

		if (username != null)
		{
			Database db = WebUtil.getDatabase(getServletContext());
			
			User user = null;
			try
			{
				user = db.getUserDataFromUsername(username);
			}
			catch(Exception ex) {}

			if (user != null) msg = "1";
			else msg = "0";
		}
		else
		{
			msg = "0";
		}

		out.write(msg + "\n");
		
	}
}
