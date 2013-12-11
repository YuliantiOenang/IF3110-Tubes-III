// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class ValidateRegistrasi extends HttpServlet{ 
	public static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn =(HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}
		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String Request=request.getParameter("DataType");
		String Data=request.getParameter("Data");
		String URL="http://wbd032.ap01.aws.af.cm/ValidateRegistrasiServer.php?DataType="+Request+"&Data="+URLEncoder.encode(Data, "UTF-8");
		String Resp=httpGet(URL);
		if (!Resp.equals("BERHASIL")){
			response.getWriter().println("salah");}
		else{
			response.getWriter().println("betul");}
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			PrintWriter out=response.getWriter();
			//out.println(Request+" "+Data);
			ResultSet rs;	
			if (Request.equals("username")){
				rs = s.executeQuery("SELECT * FROM user WHERE username="+"'"+Data+"'"+";");
			}
			else if (Request.equals("email")){
				rs = s.executeQuery("SELECT * FROM user WHERE email="+"'"+Data+"'"+";");
			}
			else if (Request.equals("cardnumber")){
				rs = s.executeQuery("SELECT * FROM creditcard WHERE number="+"'"+Data+"'"+";");
			}
			else if (Request.equals("cardname")){
				rs = s.executeQuery("SELECT * FROM creditcard WHERE name="+"'"+Data+"'"+";");
			}
			else if (Request.equals("expiredate")){
				rs = s.executeQuery("SELECT * FROM creditcard WHERE expiredate="+"'"+Data+"'"+";");
			}
			else{
				rs= s.executeQuery("SELECT * FROM user WHERE username="+"'TERLARANG'"+";");}
			if (Request.equals("username") || Request.equals("email")){
				int Found=0;
				while(rs.next()){
					Found=1;}
				if (Found==1){
					out.println("salah");}
				else{
					out.println("betul");}
			}
			else{
				int Found=0;
				while(rs.next()){
					Found=1;}
				if (Found==1){
					out.println("betul");}
				else{
					out.println("salah");}
			}
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
	} 
}