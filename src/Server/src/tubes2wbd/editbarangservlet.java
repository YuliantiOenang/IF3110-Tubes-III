package tubes2wbd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editbarangservlet
 */
public class editbarangservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editbarangservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	    String id;
	    if(request.getParameter("id")!=null){
	    	id=request.getParameter("id");
	    }else{
	    	id="1";
	    }
	    try {
	    	DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
			Statement stmt = conn.createStatement();
			String sql;
            sql = "select * from barang where id="+id;
            ResultSet rs = stmt.executeQuery(sql);
          	// Extract data from result set
          	while(rs.next()){
          		out.println("<input type=\"hidden\" value='"+id+"'name='id'>"
          				+"<pre>Nama Barang	: <input type=\"text\" name=\"nama\" value="+rs.getString("nama")+"></pre>"
                		+"<pre>Kategori		: <input type=\"text\" name=\"kategori\" value="+rs.getString("kategori")+"></pre>"
                		+"<pre>Harga		: <input type=\"text\" name=\"harga\" value="+rs.getString("harga")+"></pre>"
                		+"<pre>Jumlah		: <input type=\"text\" name=\"jumlah\" value="+rs.getString("jumlah")+"></pre>"
                		+"<pre id=\"addedrequest\">Deskripsi		: <textarea name=\"deskripsi\" cols=\"25\" rows=\"5\">"+rs.getString("keterangan")+"</textarea></pre>"
                		+"<pre>Link Gambar	: <input type=\"text\" name=\"img\" value="+rs.getString("gambar")+"></pre>");
          	}
          	// Clean-up environment
          	rs.close();
          	stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
