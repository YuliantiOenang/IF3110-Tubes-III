package com.ruserba.web;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.ruserba.model.Database;
import com.ruserba.model.User;
import com.ruserba.web.WebUtil;
 
public class RegisterUserService extends HttpServlet
{
 	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("text/plain");

		/*PrintWriter out = null;
		try	{
			out = response.getWriter();
		}
		catch (Exception ex) {}

		out.write("Hello");*/

		MessageDigest md = null;
		try	{
			md = MessageDigest.getInstance("MD5");
		} catch (Exception ex) {}
        md.update(request.getParameter("password").getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
		{
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String pass_enc = sb.toString();
        
		// Ambil data.
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(pass_enc);
		user.setNamaLengkap(request.getParameter("namaLengkap"));
		user.setProvinsi(request.getParameter("provinsi"));
		user.setKota(request.getParameter("kota"));
		user.setAlamat(request.getParameter("alamat"));
		user.setKodePos(request.getParameter("kodePos"));
		user.setKontak(request.getParameter("kontak"));

		Database db = WebUtil.getDatabase(getServletContext());
		
		PreparedStatement stat = null;
		try
		{
			stat = db.getConnection().prepareStatement("insert into user(username, email, password, nama_lengkap, provinsi, kota, alamat, kode_pos, kontak, admin) " +
			"values (?, ?, ?, ?, ?, ?, ?, ?, ?, 0)");
		
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getEmail());
			stat.setString(3, user.getPassword());
			stat.setString(4, user.getNamaLengkap());
			stat.setString(5, user.getProvinsi());
			stat.setString(6, user.getKota());
			stat.setString(7, user.getAlamat());
			stat.setString(8, user.getKodePos());
			stat.setString(9, user.getKontak());
			stat.executeUpdate();
		}
		catch (Exception ex) {}

		Cookie id_cookie = new Cookie("id_user", Integer.toString(user.getIdUser())); // Bad practice, but who cares? :p
		id_cookie.setPath("/"); id_cookie.setMaxAge(2592000);
		response.addCookie(id_cookie);

		Cookie username_cookie = new Cookie("username", user.getUsername()); // Bad practice, but who cares? :p
		username_cookie.setPath("/"); username_cookie.setMaxAge(2592000);
		response.addCookie(username_cookie);
	}
}
