// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class Registrasi extends HttpServlet{ 
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
		//response.getWriter().println(DataNama);
		//response.getWriter().println(DataPass);
		String URL="http://wbd032.ap01.aws.af.cm/RegistrasiClient.php?username="+URLEncoder.encode(DataNama, "UTF-8")+"&password="+DataPass+"&email="+URLEncoder.encode(DataEmail, "UTF-8")+"&namalengkap="+URLEncoder.encode(DataNamaLengkap, "UTF-8")+"&nohp="+DataHp+"&provinsi="+URLEncoder.encode(DataProvinsi, "UTF-8")+"&kota="+URLEncoder.encode(DataKota, "UTF-8")+"&alamat="+URLEncoder.encode(DataAlamat, "UTF-8")+"&kodepos="+DataKodePos;
		response.getWriter().println(URL);
		String Resp=httpGet(URL);
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
			s.executeUpdate("INSERT INTO user VALUES("+"'"+DataNama+"'"+","+"'"+DataPass+"'"+","+"'"+DataEmail+"'"+","+"'"+DataNamaLengkap+"'"+","+"'"+DataHp+"'"+","+"'"+DataProvinsi+"'"+","+"'"+DataKota+"'"+","+"'"+DataAlamat+"'"+","+"'"+DataKodePos+"','NULL');");*/
		if (Resp.equals("BERHASIL")){	
			Cookie usernameCookie = new Cookie("username", DataNama); //Add cookie username
			usernameCookie.setMaxAge(60*60*24);
			response.addCookie(usernameCookie);
			
			Cookie emailCookie = new Cookie("email", DataEmail); //Add cookie email
			emailCookie.setMaxAge(60*60*24);
			response.addCookie(emailCookie);
			
			Cookie PassCookie = new Cookie("password", DataPass); //Add cookie password
			PassCookie.setMaxAge(60*60*24);
			response.addCookie(PassCookie);
			
			Cookie NamaLengkapCookie = new Cookie("NamaLengkap", DataNamaLengkap); //Add cookie NamaLengkap
			NamaLengkapCookie.setMaxAge(60*60*24);
			response.addCookie(NamaLengkapCookie);
			
			Cookie NomerHpCookie = new Cookie("NomerHp", DataHp); //Add cookie Nomer Hp
			NomerHpCookie.setMaxAge(60*60*24);
			response.addCookie(NomerHpCookie);
			
			Cookie ProvinsiCookie = new Cookie("Provinsi", DataProvinsi); //Add cookie Provinsi
			ProvinsiCookie.setMaxAge(60*60*24);
			response.addCookie(ProvinsiCookie);
			
			Cookie KotaCookie = new Cookie("Kota", DataKota); //Add cookie Kota
			KotaCookie.setMaxAge(60*60*24);
			response.addCookie(KotaCookie);
			
			Cookie AlamatCookie = new Cookie("Alamat", DataAlamat); //Add cookie Alamat
			AlamatCookie.setMaxAge(60*60*24);
			response.addCookie(AlamatCookie);
			
			Cookie KodePosCookie = new Cookie("KodePos", DataKodePos); //Add cookie username
			KodePosCookie.setMaxAge(60*60*24);
			response.addCookie(KodePosCookie);
			
			session.setAttribute("username", DataNama);
			session.setAttribute("email", DataEmail);
			session.setAttribute("password", DataPass);
			session.setAttribute("NamaLengkap", DataNamaLengkap);
			session.setAttribute("NomerHp", DataHp);
			session.setAttribute("Provinsi", DataProvinsi);
			session.setAttribute("Kota", DataKota);
			session.setAttribute("Alamat", DataAlamat);
			session.setAttribute("KodePos", DataKodePos);
			/*s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
		}
		else{}
			//response.sendRedirect("registrasi.jsp");
			//return;}
		//response.sendRedirect("credit-card.jsp");
		//return;
	} 
}