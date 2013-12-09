// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class deletebarang extends HttpServlet{ 
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
		String active;
		String namabarang;
		PrintWriter out = response.getWriter();
		ResultSet  rs = null;
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
            response.getWriter().println(paramName);
			String URL="http://wbd032.ap01.aws.af.cm/DeleteBarangServer.php?Nama="+URLEncoder.encode(paramName, "UTF-8");
			httpGet(URL);
			response.getWriter().println(URL);
		}
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			Statement s2 = (Statement) con.createStatement();
			rs = s.executeQuery("SELECT * FROM barang;");
			response.setContentType("text/html"); 
			while(rs.next()) {
				namabarang = rs.getString("NamaBarang");
				active = request.getParameter(namabarang);				
				if("on".equals(active)){
					s2.executeUpdate("DELETE FROM barang WHERE NamaBarang='"+namabarang+"';");
				} 
			}
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		out.println("Change success <a href = home.jsp> return to home </a>");*/
		//response.setHeader("Refresh", "1; URL=home.jsp");
	} 
}