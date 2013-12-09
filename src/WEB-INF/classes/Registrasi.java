// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
 
public class Registrasi extends HttpServlet{ 
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
		HttpSession session=request.getSession(true);
		try{
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
			s.executeUpdate("INSERT INTO user VALUES("+"'"+DataNama+"'"+","+"'"+DataPass+"'"+","+"'"+DataEmail+"'"+","+"'"+DataNamaLengkap+"'"+","+"'"+DataHp+"'"+","+"'"+DataProvinsi+"'"+","+"'"+DataKota+"'"+","+"'"+DataAlamat+"'"+","+"'"+DataKodePos+"','NULL');");
			Cookie usernameCookie = new Cookie("username", DataNama); //Add cookie username
			usernameCookie.setMaxAge(100);
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
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		response.sendRedirect("credit-card.jsp");
		return;
	} 
}