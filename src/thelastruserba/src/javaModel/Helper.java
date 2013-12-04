package javaModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import databaseLib.DatabaseAdapter;

public class Helper {
	static DatabaseAdapter DBA = new DatabaseAdapter();
	public Helper() {
		
	}
	public static Kategori findAllKategori() {
		String Query = "select * from kategori";
		Kategori K = new Kategori(DBA);
		K.executeQuery(Query);
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
		String username = Helper.getUserLogged(session);
		String q1 = "select * from account where username = '" + username  + "' limit 1";
		Profile P = new Profile(DBA);
		P.executeQuery(q1);
		if (P.id.size() > 0)
			return Integer.parseInt(P.id.get(0));
		else
			return 0;
	}
	public static Boolean isCreditCard(HttpSession session) {
		Integer userId = Helper.getUserId(session);
		if (userId == 0) {
			return true;
		} else {
			DatabaseAdapter DBA = new DatabaseAdapter();
			String query = "select * from kredit where id_account = '" + userId + "' limit 1";
			DBA.executeQuery(query);
			ResultSet RS = DBA.getQueryResult();
			try {
				if (!RS.isBeforeFirst()) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
}
