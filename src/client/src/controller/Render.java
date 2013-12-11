package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Kategori;
import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.Filter.Chain;

public class Render {
	
	private Render() {}
	
	public static void Show(HttpServletRequest request, HttpServletResponse response, String jsp)
	{
		preRender(request,response);
		RequestDispatcher view = request.getRequestDispatcher(jsp);
		try {
			request.setCharacterEncoding("utf8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        response.setContentType("text/html");
	    try {
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void preRender(HttpServletRequest request, HttpServletResponse response)
	{
		setLogin(request,response);
		setKategori(request, response);
	}
	
	public static void setLogin(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("setLogin");
		String userid = null;
		Cookie[] cookies_arr = null;
		cookies_arr = request.getCookies();
		if( cookies_arr != null ){
			for (int i = 0; i < cookies_arr.length; i++){
				System.out.println(cookies_arr[i].getName());
				if (cookies_arr[i].getName().equals("username")){
					System.out.println("KETEMU!"+ cookies_arr[i].getValue());
					request.setAttribute("_pre_userid", cookies_arr[i].getValue());
				}
			}
		}
	}
	
	public static boolean isLogin(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("setLogin");
		String userid = null;
		Cookie[] cookies_arr = null;
		cookies_arr = request.getCookies();
		if( cookies_arr != null ){
			for (int i = 0; i < cookies_arr.length; i++){
				System.out.println(cookies_arr[i].getName());
				if (cookies_arr[i].getName().equals("username")){
					return true;
				}
			}
		}
		return false;
	}
	
	private static void setKategori(HttpServletRequest request, HttpServletResponse response)
	{
		Kategori model = new Kategori();
		model.findAll();
		request.setAttribute("_cat_count", model.getDataCount());
		int i = 0;
		for (HashMap<String, String> element : model.getDataVector()) {
			request.setAttribute("_cat_"+i+"_id", element.get("id"));
			request.setAttribute("_cat_"+i+"_nama", element.get("nama_kategori"));
			i++;
		}
	}
}
