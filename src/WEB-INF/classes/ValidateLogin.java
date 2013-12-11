// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class ValidateLogin extends HttpServlet{ 
	String DataNama;
	String DataPass;
	String DataCredit;
	String DataEmail;
	String DataNamaLengkap;
	String DataHp;
	String DataProvinsi;
	String DataKota;
	String DataAlamat;
	String DataKodePos;
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
	public void Parse_Response(String Resp,HttpServletResponse response) throws ServletException,IOException {
		StringTokenizer st = new StringTokenizer(Resp,";");
		int i=0;
		while (st.hasMoreTokens()) {
			if (i%10==0){
				DataNama=st.nextToken();}
			else if (i%10==1){
				DataPass=st.nextToken();}
			else if (i%10==2){
				DataEmail=st.nextToken();}
			else if (i%10==3){
				DataNamaLengkap=st.nextToken();}
			else if (i%10==4){
				DataHp=st.nextToken();}
			else if (i%10==5){
				DataProvinsi=st.nextToken();}
			else if (i%10==6){
				DataKota=st.nextToken();}
			else if (i%10==7){
				DataAlamat=st.nextToken();}
			else if (i%10==8){
				DataKodePos=st.nextToken();}
			else if (i%10==9){
				DataCredit=st.nextToken();}
			i++;
		}
	}
	public void Parse_Response_Credit(String Resp,HttpServletResponse response,HttpServletRequest request) throws ServletException,IOException {
		StringTokenizer st = new StringTokenizer(Resp,";");
		int i=0;
		String DataNamaKartu=new String();
		String DataNomor=new String();
		String DataExpire=new String();
		HttpSession session=request.getSession(true);
		while (st.hasMoreTokens()) {
			if (i%3==0){
				DataNomor=st.nextToken();}
			else if (i%3==1){
				DataNamaKartu=st.nextToken();}
			else if (i%3==2){
				DataExpire=st.nextToken();}
			i++;
		}
		session.setAttribute("creditcard", DataNomor);
		session.setAttribute("creditcardNama", DataNamaKartu);
		session.setAttribute("creditcardExpireDate", DataExpire);
		Cookie CreditNamaCookie = new Cookie("creditcardNama", DataNamaKartu); //Add cookie Credit
		response.addCookie(CreditNamaCookie);
		Cookie CreditExpireDateCookie = new Cookie("creditcardExpireDate", DataExpire); //Add cookie Credit
		response.addCookie(CreditExpireDateCookie);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		DataNama=new String();
		DataPass=new String();
		DataCredit=new String();
		DataEmail=new String();
		DataNamaLengkap=new String();
		DataHp=new String();
		DataProvinsi=new String();
		DataKota=new String();
		DataAlamat=new String();
		DataKodePos=new String();
		HttpSession session=request.getSession(true);
		String Response=new String();
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();*/
		DataNama=request.getParameter("username");
		DataPass=request.getParameter("password");
		String URL="http://wbd032.ap01.aws.af.cm/ValidateLoginServer.php?Username="+DataNama+"&Password="+DataPass;
		//response.getWriter().println(URL);
		String Resp=httpGet(URL);
		response.getWriter().println(Resp);
		if (!(Resp.equals("GAGAL"))){
			Parse_Response(Resp,response);
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
			
			if (DataCredit!=null){
				Cookie CreditCookie = new Cookie("creditcard", DataCredit); //Add cookie Credit
				response.addCookie(CreditCookie);
				session.setAttribute("creditcard", DataCredit);
				String URL1="http://wbd032.ap01.aws.af.cm/GetCreditCard.php?NoCredit="+DataCredit;
				response.getWriter().println(URL1);
				String Resp1=httpGet(URL1);
				Parse_Response_Credit(Resp1,response,request);
			}
			String URL1="http://wbd032.ap01.aws.af.cm/JumlahTransaksi.php?username="+DataNama;
			//response.getWriter().println(URL);
			Cookie JumlahTransCookie = new Cookie("JumlahTransaksi", httpGet(URL1)); //Add cookie Jumlah Transaksi
			response.addCookie(JumlahTransCookie);
		}
		else{
			response.getWriter().println("Login Gagal");}
			/*PrintWriter out=response.getWriter();
			ResultSet rs;
			boolean Found=false;
			rs = s.executeQuery("SELECT * FROM user WHERE username="+"'"+DataNama+"'"+" AND password="+"'"+DataPass+"'"+";"); 
			while(rs.next()){
				DataEmail=rs.getString("email");
				DataNamaLengkap=rs.getString("namalengkap");
				DataHp=rs.getString("nohp");
				DataProvinsi=rs.getString("provinsi");
				DataKota=rs.getString("kotakabupaten");
				DataAlamat=rs.getString("alamat");
				DataKodePos=rs.getString("kodepos");
				if (rs.getString("nocredit")!=null){
					DataCredit=rs.getString("nocredit");}
				Found=true;
				
			}
			if (Found){
				Response="Login Berhasil!";
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
				
				if (DataCredit!=null){
					Cookie CreditCookie = new Cookie("creditcard", DataCredit); //Add cookie Credit
					response.addCookie(CreditCookie);
					session.setAttribute("creditcard", DataCredit);
					ResultSet Credit=s.executeQuery("SELECT * FROM creditcard WHERE number="+"'"+DataCredit+"';");
					while(Credit.next()){
						String DataNamaKartu=Credit.getString("name");
						String DataNomor=Credit.getString("number");
						String DataExpire=Credit.getString("expiredate");
						session.setAttribute("creditcard", DataNomor);
						session.setAttribute("creditcardNama", DataNamaKartu);
						session.setAttribute("creditcardExpireDate", DataExpire);
						
						Cookie CreditNamaCookie = new Cookie("creditcardNama", DataNamaKartu); //Add cookie Credit
						response.addCookie(CreditNamaCookie);
						Cookie CreditExpireDateCookie = new Cookie("creditcardExpireDate", DataExpire); //Add cookie Credit
						response.addCookie(CreditExpireDateCookie);
					}
				}
				rs = s.executeQuery("SELECT count(*) FROM transactionlog WHERE username="+"'"+DataNama+"'"+";"); 
				String JumlahTrans=new String();
				while(rs.next()){
					JumlahTrans=rs.getString("count(*)");}
				Cookie JumlahTransCookie = new Cookie("JumlahTransaksi", JumlahTrans); //Add cookie Jumlah Transaksi
				response.addCookie(JumlahTransCookie);
				out.println(DataCredit);
			}
			else{
				Response="Login Gagal!";}
			out.println(Response);
			s.close();
			con.close();
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
		response.setHeader("Refresh", "2; URL=home.jsp");
		return;
	} 
}