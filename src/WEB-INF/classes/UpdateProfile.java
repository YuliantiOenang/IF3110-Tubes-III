// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class UpdateProfile extends HttpServlet{ 
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
		String DataNama=new String();
		String DataPass=new String();
		String DataCredit=new String();
		String DataEmail=new String();
		String DataNamaLengkap=new String();
		String DataHp=new String();
		String DataProvinsi=new String();
		String DataKota=new String();
		String DataAlamat=new String();
		String DataKodePos=new String();
		
		DataNama=request.getParameter("username");
		DataPass=request.getParameter("password");
		DataEmail=request.getParameter("email");
		DataNamaLengkap=request.getParameter("namalengkap");
		DataHp=request.getParameter("nohp");
		DataProvinsi=request.getParameter("provinsi");
		DataKota=request.getParameter("kotakabupaten");
		DataAlamat=request.getParameter("alamat");
		DataKodePos=request.getParameter("kodepos");
		HttpSession session=request.getSession(true);
		String URL="http://wbd032.ap01.aws.af.cm/UpdateProfileServer.php?username="+URLEncoder.encode(DataNama, "UTF-8")+"&password="+DataPass+"&email="+URLEncoder.encode(DataEmail, "UTF-8")+"&namalengkap="+URLEncoder.encode(DataNamaLengkap, "UTF-8")+"&nohp="+DataHp+"&provinsi="+URLEncoder.encode(DataProvinsi, "UTF-8")+"&kota="+URLEncoder.encode(DataKota, "UTF-8")+"&alamat="+URLEncoder.encode(DataAlamat, "UTF-8")+"&kodepos="+DataKodePos;
		response.getWriter().println(URL);
		String Resp=httpGet(URL);
		if (Resp.equals("BERHASIL")){
			session.setAttribute("username", DataNama);
			session.setAttribute("email", DataEmail);
			session.setAttribute("password", DataPass);
			session.setAttribute("NamaLengkap", DataNamaLengkap);
			session.setAttribute("NomerHp", DataHp);
			session.setAttribute("Provinsi", DataProvinsi);
			session.setAttribute("Kota", DataKota);
			session.setAttribute("Alamat", DataAlamat);
			session.setAttribute("KodePos", DataKodePos);}
		else{}
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			DataNama=request.getParameter("username");
			DataPass=request.getParameter("password");
			DataEmail=request.getParameter("email");
			DataNamaLengkap=request.getParameter("namalengkap");
			DataHp=request.getParameter("nohp");
			DataProvinsi=request.getParameter("provinsi");
			DataKota=request.getParameter("kotakabupaten");
			DataAlamat=request.getParameter("alamat");
			DataKodePos=request.getParameter("kodepos");
			PrintWriter out=response.getWriter();	
			s.executeUpdate("UPDATE user SET username="+"'"+DataNama+"'"+",password="+"'"+DataPass+"'"+",email="+"'"+DataEmail+"'"+",namalengkap="+"'"+DataNamaLengkap+"'"+",nohp="+"'"+DataHp+"'"+",provinsi="+"'"+DataProvinsi+"'"+",kotakabupaten="+"'"+DataKota+"'"+",alamat="+"'"+DataAlamat+"'"+",kodepos="+"'"+DataKodePos+"'"+" WHERE username="+"'"+DataNama+"'"+ ";"); 
			session.setAttribute("username", DataNama);
			session.setAttribute("email", DataEmail);
			session.setAttribute("password", DataPass);
			session.setAttribute("NamaLengkap", DataNamaLengkap);
			session.setAttribute("NomerHp", DataHp);
			session.setAttribute("Provinsi", DataProvinsi);
			session.setAttribute("Kota", DataKota);
			session.setAttribute("Alamat", DataAlamat);
			session.setAttribute("KodePos", DataKodePos);
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
		request.getRequestDispatcher("edit-profile.jsp").forward(request, response);
	} 
}