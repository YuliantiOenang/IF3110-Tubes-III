package com.ruserba.web;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import com.ruserba.model.Database;

public class WebUtil
{
	public static boolean isLoggedIn(ServletContext context, HttpServletRequest request) throws SQLException
	{
		Cookie[] cookies = request.getCookies();
		int user_id;
		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				if (cookies[i].getName().equals("id_user"))
				{
					user_id = Integer.parseInt(cookies[i].getValue());

					// Periksa kebenaran user ID.
					Database db = getDatabase(context);
					if (db.getUserData(user_id) != null) return true;
					else return false;
				}
			}
		}
		return false;
	}

	public static Database getDatabase(ServletContext context)
	{
		return (Database)context.getAttribute("db");
	}

	public static String getProductImagePath(String product_image_filename)
	{
		return "images/products/" + product_image_filename;
	}

	public static String getProductPage(int product_id)
	{
		return "product.jsp?product_id=" + product_id;
	}

}
