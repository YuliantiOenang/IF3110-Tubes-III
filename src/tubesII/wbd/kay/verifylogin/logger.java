package tubesII.wbd.kay.verifylogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tubesII.wbd.GlobalConfig;

public class logger {
	
	public static boolean validate(String username, String password){
		Connection con = null;
		Statement state = null;
		ResultSet result = null;
		boolean status = false;
		
		try{
			String uname = GC.getuser();
			String pass = GC.getpass();
			String url = GC.geturl();
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	        con = DriverManager.getConnection (url, uname, pass);
		}
		catch(Exception e){
			System.out.println("Cannot connect to database "+ e.getMessage());
		}
		try{
			state = con.createStatement();
			result = state.executeQuery("SELECT * FROM user where username ='"+username+"' AND password = '"+password+"'");
			status = result.next();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("masuk sini");
		}
		
		return status;
	}
}
