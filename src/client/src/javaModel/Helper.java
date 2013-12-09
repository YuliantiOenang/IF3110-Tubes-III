package javaModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpException;

import databaseLib.DatabaseAdapter;

public class Helper {
	static DatabaseAdapter DBA = new DatabaseAdapter();
	public Helper() {
		
	}
	public static Kategori findAllKategori() {
//		String Query = "select * from kategori";
		Kategori K = new Kategori(DBA);
//		K.executeQuery(Query);
		K.findAllRest();
		return K;
	}
	public static String getUserLogged(HttpSession session) {
		if (session.getAttribute("isLogin")!=null) {
			if (Boolean.parseBoolean(session.getAttribute("isLogin").toString())) {
				return (String)session.getAttribute("username");
			}
		}
		return "";
	}
	public static Integer getUserRole(HttpSession session) {
		if (session.getAttribute("isLogin")!=null) {
			if (Boolean.parseBoolean(session.getAttribute("isLogin").toString())) {
				return Integer.parseInt(session.getAttribute("role").toString());
			}
		}
		return 0;
	}
	public static Integer getUserId(HttpSession session) {
	    if (session.getAttribute("isLogin")!=null) {
            if (Boolean.parseBoolean(session.getAttribute("isLogin").toString())) {
                return Integer.parseInt(session.getAttribute("id").toString());
            }
        }
        return 0;
	}
	public static Boolean isCreditCard(HttpSession session) {
		Integer userId = Helper.getUserId(session);
		if (userId == 0) {
			return true;
		} else {
			DatabaseAdapter DBA = new DatabaseAdapter();
//			String query = "select * from kredit where id_account = '" + userId + "' limit 1";
//			DBA.executeQuery(query);
		    Credit C = new Credit(DBA); 
		    C.findByAccountRest(userId);
			if(C.id.size() > 0) {
				return true;
			} else {
			    return false;
			}
		}
	}
}
