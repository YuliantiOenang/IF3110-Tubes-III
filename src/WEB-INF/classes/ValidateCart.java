// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class ValidateCart extends HttpServlet{ 
	boolean IsLoaded=false;
	int DataJumlahSalah=0;
	ArrayList<String> DataNama=new ArrayList<String>();
	ArrayList<Integer> DataHarga=new ArrayList<Integer>();
	ArrayList<Integer> DataJumlah=new ArrayList<Integer>();
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
			if (i%3==0){
				DataNama.add(st.nextToken());}
			else if (i%3==1){
				DataHarga.add(Integer.parseInt(st.nextToken()));}
			else if (i%3==2){
				DataJumlah.add(Integer.parseInt(st.nextToken()));}
			i++;
		}
	}
	public void LoadDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession(true);
		String URL="http://wbd032.ap01.aws.af.cm/DatabaseBarangServer.php";
		//response.getWriter().println(URL);
		String Resp=httpGet(URL);
		//response.getWriter().println(Resp);
		Parse_Response(Resp,response);
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM BARANG;");
			while(rs.next()){ 
				//Retrieve by column name 
				int Jumlah = rs.getInt("Jumlah"); 
				int harga = rs.getInt("Harga"); 
				String Name = rs.getString("NamaBarang"); 
				DataNama.add(Name);
				DataHarga.add(harga);
				DataJumlah.add(Jumlah);
			}
			session.setAttribute("TabelNamaBarang",  DataNama);
			session.setAttribute("TabelHargaBarang",  DataHarga);
			session.setAttribute("TabelJumlahBarang",  DataJumlah);
			IsLoaded=true;
		}
		catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
		session.setAttribute("TabelNamaBarang",  DataNama);
		session.setAttribute("TabelHargaBarang",  DataHarga);
		session.setAttribute("TabelJumlahBarang",  DataJumlah);
		IsLoaded=true;
	}
	public boolean ValidateTrans(String NamaBarang,int Jumlah){
		boolean Found=false;
		for (int i=0;i<DataNama.size();i++){
			if (DataNama.get(i).equals(NamaBarang)){
				if (DataJumlah.get(i)>=Jumlah){
					DataJumlah.set(i,DataJumlah.get(i)-Jumlah);
					Found=true;
					break;}
				else{
					Found=false;
					DataJumlahSalah=DataJumlah.get(i);
					break;}
			}
		}
		return Found;
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		if (!IsLoaded){ LoadDatabase(request,response);}
		//for (int i=0;i<DataNama.size();i++){
		//	response.getWriter().print(""+DataNama.get(i)+" "+DataJumlah.get(i)+"\n");}
		HttpSession session = request.getSession(true);
		ArrayList<String> DataNamaSession=new ArrayList<String>();
		ArrayList<Integer> DataHargaSession=new ArrayList<Integer>();
		ArrayList<Integer> DataJumlahSession=new ArrayList<Integer>();
		ArrayList<String> DataDetailSession=new ArrayList<String>();
		String NamaBarang=(String)request.getParameter("Nama");
		int Jumlah=Integer.parseInt(request.getParameter("Jumlah"));
		int Harga=Integer.parseInt(request.getParameter("Harga"));
		String Detail=(String)request.getParameter("detail");
		String Resp;
		
		if (ValidateTrans(NamaBarang,Jumlah)){
			if (session.getAttribute("CartNama")!=null){
				DataNamaSession=(ArrayList<String>)session.getAttribute("CartNama");
				DataHargaSession=(ArrayList<Integer>)session.getAttribute("CartHarga");
				DataJumlahSession=(ArrayList<Integer>)session.getAttribute("CartJumlah");
				DataDetailSession=(ArrayList<String>)session.getAttribute("CartDetail");}
			
			DataNamaSession.add(NamaBarang);
			DataHargaSession.add(Harga);
			DataJumlahSession.add(Jumlah);
			DataDetailSession.add(Detail);
			
			session.setAttribute("CartNama", DataNamaSession);
			session.setAttribute("CartHarga",DataHargaSession);
			session.setAttribute("CartJumlah", DataJumlahSession);
			session.setAttribute("CartDetail", DataDetailSession);
			Resp="Betul";
		}
		else{
			Resp=Integer.toString(DataJumlahSalah);}
		response.getWriter().println(Resp);       // Write response body.
		/*for (int i=0;i<DataNamaSession.size();i++){
			response.getWriter().print(""+DataNamaSession.get(i)+" "+DataJumlahSession.get(i)+" "+DataHargaSession.get(i)+"\n");}*/
	} 
}