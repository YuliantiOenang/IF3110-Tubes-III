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
public class detailbarangservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailbarangservlet() {
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
		
		String id = null;
		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}
		
	    try {
	    	DbConnector dbconnector = new DbConnector();
			Connection conn = dbconnector.mySqlConnection(response);
			Statement stmt = conn.createStatement();
			
			String sql;
			sql = "select * from barang where id="+id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				out.print("<img src='"+rs.getString("gambar")+"' width='318' height='238'/>");
				out.print("<h2>"+rs.getString("nama")+"</h2>");
				out.print("<p>Keterangan : "+rs.getString("keterangan")+"</p>");
				out.print("<pre>Masukkan jumlah barang yang akan dibeli		<input type='number' name='quantity' min='1' id='qty'></pre>");
				out.print("<pre id='addedrequest'>Masukkan tambahan permintaan 			<textarea name='tambahan' rows='4'></textarea></pre>");
				out.print("<input type='button' value='Beli!' onclick='tempBuy("+rs.getInt("id")+",qty.value)'>");
			}
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
