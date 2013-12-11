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
import com.ruserba.model.SearchAttribute;
import com.ruserba.web.WebUtil;
 
public class CobaServlet extends HttpServlet
{
 	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/plain");

		PrintWriter out = null;
		try	{
			out = response.getWriter();
		}
		catch (Exception ex) {}

		out.write("Hello");

		Database db = WebUtil.getDatabase(getServletContext());

		SearchAttribute attr = new SearchAttribute();

	/*
		attr.setNamaBarang("tomat");
		attr.setIdKategori(2);
		attr.setHarga(3143);
		attr.setIdPerbandingan(2);
		attr.setIdPengurutan(Database.ORDERBY_PRODUCTNAME);
		attr.setIdMetodePengurutan(Database.SORT_ASC);
		attr.setIndeks(0);
		attr.setJumlah(5);
	*/

		attr.setNamaBarang("");
		attr.setIdKategori(3);
		attr.setHarga(-1);
		attr.setIdPerbandingan(0);
		attr.setIdPengurutan(Database.ORDERBY_SOLDQTY);
		attr.setIdMetodePengurutan(Database.SORT_DESC);
		attr.setIndeks(0);
		attr.setJumlah(3);

	}
}
