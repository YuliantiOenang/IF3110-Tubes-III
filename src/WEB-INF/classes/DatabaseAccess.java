// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class DatabaseAccess extends HttpServlet{ 
	ArrayList<String> DataNama;
	ArrayList<Integer> DataHarga;
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
			if (i%2==0){
				DataNama.add(st.nextToken());}
			else{
				DataHarga.add(Integer.parseInt(st.nextToken()));}
			i++;
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{	
		DataNama=new ArrayList<String>();
		DataHarga=new ArrayList<Integer>();
		String KategoriReq=(String)request.getParameter("Kategori");
		String URL=new String();
		if (request.getParameter("SortBy")!=null){
			URL="http://wbd032.ap01.aws.af.cm/BarangServer.php?Kategori="+URLEncoder.encode(KategoriReq, "UTF-8")+"&SortBy="+request.getParameter("SortBy");}
		else{
			URL="http://wbd032.ap01.aws.af.cm/BarangServer.php?Kategori="+URLEncoder.encode(KategoriReq, "UTF-8");}
		response.getWriter().println(URL);
		String Resp=httpGet(URL);
		response.getWriter().println(Resp);
		Parse_Response(Resp,response);
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			KategoriReq = (String)request.getParameter("Kategori");
			PrintWriter out=response.getWriter();
			ResultSet rs;	
			if (request.getParameter("SortBy")!=null){
				if (request.getParameter("SortBy").equals("NamaBarang")){
					rs = s.executeQuery("SELECT * FROM BARANG WHERE Kategori="+"\""+KategoriReq+"\""+" ORDER BY NamaBarang ASC;");}
				else{
					rs = s.executeQuery("SELECT * FROM BARANG WHERE Kategori="+"\""+KategoriReq+"\""+" ORDER BY Harga ASC;");}
			}
			else{
				rs = s.executeQuery("SELECT * FROM BARANG WHERE Kategori="+"\""+KategoriReq+"\""+";");}
			response.setContentType("text/html"); 
			while(rs.next()){ 
				//Retrieve by column name 
				int id = rs.getInt("IdBarang"); 
				int harga = rs.getInt("Harga"); 
				String Name = rs.getString("NamaBarang"); 
				String Kategori= rs.getString("Kategori"); 
				DataNama.add(Name);
				DataHarga.add(harga);
			}
			s.close();
			con.close();
			for (String O:DataNama){
				out.println(O);}
			for (Integer O:DataHarga){
				out.println(O);}
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}
		
		request.setAttribute("KategoriBarang", KategoriReq);
		request.setAttribute("TabelNamaBarang", DataNama);
		request.setAttribute("TabelHargaBarang",DataHarga);
		request.getRequestDispatcher("Barang.jsp").forward(request, response);*/
		request.setAttribute("KategoriBarang", KategoriReq);
		request.setAttribute("TabelNamaBarang", DataNama);
		request.setAttribute("TabelHargaBarang",DataHarga);
		request.getRequestDispatcher("Barang.jsp").forward(request, response);
	} 
}