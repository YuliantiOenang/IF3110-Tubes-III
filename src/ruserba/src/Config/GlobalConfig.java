package Config;

import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

public class GlobalConfig {
	public static String URLSQL = "jdbc:mysql://localhost:3306/ruserba";
	public static String SQLUser = "root";
	public static String SQLPass = "";
	public static String Path = "/home/habibie/IF3110-Tubes-II/src/ruserba/";
	private static DatabaseAdapter DBA = new DatabaseAdapter();
	
	public GlobalConfig() {
		try
		{
			if (java.lang.System.getenv("VCAP_SERVICES") != null)
			{
				if (java.lang.System.getenv("VCAP_SERVICES").equals(""))
				{
					JSONObject jsonVCAP = new JSONObject(java.lang.System.getenv("VCAP_SERVICES"));
					JSONArray mysql = jsonVCAP.getJSONArray("mysql-5.1");
					String table = mysql.getJSONObject(0).getJSONObject("credentials").getString("name");
					URLSQL = "jdbc:mysql://"+mysql.getJSONObject(0).getJSONObject("credentials").getString("hostname")+":3306/"+table;
					SQLUser = mysql.getJSONObject(0).getJSONObject("credentials").getString("username");
					SQLPass = mysql.getJSONObject(0).getJSONObject("credentials").getString("password");
				}
			}
		}catch (Exception e){}
	}
	
	public static void cekLogin(HttpServletRequest request, HttpServletResponse response)
	{
		String Value = getCookie(request,response, "isLogin");
		System.out.println("COOKIE : "+Value);
		
		if (Value!=null)
		{
			if ((Value.equals("") || (Value.equals("KOSONG"))))
			{
				System.out.println("Memang belum login");
			}
			else{
				automatedLogin(Value,request,response);
			}
		}
	}
	
	private static void automatedLogin(String username,HttpServletRequest request,HttpServletResponse response)
    {
    	try
    	{
	    	String Query = "select * from account where username='"+username+"'";
	    	DBA.executeQuery(Query);
	    	System.out.println(Query);
			ResultSet RS = DBA.getQueryResult();
			while (RS.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", true);
				session.setAttribute("username", username);
				session.setAttribute("role",Integer.parseInt(RS.getObject(12).toString()));
				session.setMaxInactiveInterval(0);
			}
    	}catch (Exception e){}
    }
	
	private static String getCookie(HttpServletRequest request,HttpServletResponse response, String nama) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
            	System.out.println("Nama : "+cookie.getName());
                if (cookie.getName().equals(nama))
                {
                	return cookie.getValue();
                }
            }
        }
        return null;
    }
}
