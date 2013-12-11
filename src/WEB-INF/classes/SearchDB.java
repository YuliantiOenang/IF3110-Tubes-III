// Loading required libraries 
import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;
import java.net.*;
 
public class SearchDB extends HttpServlet{ 
	ArrayList<String> DataNama;
	ArrayList<Integer> DataHarga;
	int ResultSize;
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
			ResultSize++;
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String QueryReq=request.getParameter("Query");
		int PageNum=Integer.parseInt(request.getParameter("Page"))*2;
		ResultSize=0;
		DataNama=new ArrayList<String>();
		DataHarga=new ArrayList<Integer>();
		String URL=new String();
		URL="http://wbd032.ap01.aws.af.cm/SearchServer.php?Query="+URLEncoder.encode(QueryReq, "UTF-8")+"&PageNum="+PageNum;
		response.getWriter().println(URL);
		String Resp=httpGet(URL);
		response.getWriter().println(Resp);
		Parse_Response(Resp,response);
		if (request.getAttribute("PageSize")==null && ResultSize>0){
			int PageSize=0;
			URL="http://wbd032.ap01.aws.af.cm/SearchServer.php?Query="+URLEncoder.encode(QueryReq, "UTF-8")+"&PageNum=-1";
			response.getWriter().println(URL);
			PageSize=Integer.parseInt(httpGet(URL));
			int FinPageSize = PageSize/2-1;
			if (FinPageSize <0) {
				FinPageSize = 0;
			}
			request.setAttribute("PageSize",FinPageSize);
		}
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datauser", "root", "root");
			Statement s = (Statement) con.createStatement();
			QueryReq = (String)request.getParameter("Query");
			PageNum=Integer.parseInt(request.getParameter("Page"));
			PageNum=PageNum*2;
			ResultSet rs;
			rs = s.executeQuery("SELECT * FROM BARANG WHERE NamaBarang LIKE '%"+QueryReq+"%' LIMIT "+PageNum+", 2;");
			while(rs.next()){ 
				//Retrieve by column name 
				int id = rs.getInt("IdBarang"); 
				int harga = rs.getInt("Harga"); 
				String Name = rs.getString("NamaBarang"); 
				String Kategori= rs.getString("Kategori"); 
				DataNama.add(Name);
				DataHarga.add(harga);
				ResultSize++;
			}
			if (request.getAttribute("PageSize")==null && ResultSize>0){
				int PageSize=0;
				rs=s.executeQuery("SELECT * FROM BARANG WHERE NamaBarang LIKE '%"+QueryReq+"%';");
				while(rs.next()){
					PageSize++;}
				int FinPageSize = PageSize/2-1;
				if (FinPageSize <2) {
					FinPageSize = 0;
				}
				request.setAttribute("PageSize",FinPageSize);
			}
			s.close();
			con.close();
			request.setAttribute("QuerySearch",QueryReq);
			request.setAttribute("TabelSearchNamaBarang", DataNama);
			request.setAttribute("TabelSearchHargaBarang",DataHarga);
		}catch(Exception e){
			throw new SecurityException("Class not found " + e.toString());
		}*/
		request.setAttribute("QuerySearch",QueryReq);
		request.setAttribute("TabelSearchNamaBarang", DataNama);
		request.setAttribute("TabelSearchHargaBarang",DataHarga);
		request.getRequestDispatcher("Search.jsp").forward(request, response);
	} 
}