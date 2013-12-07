

import java.awt.Point;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kelas.Database;

/**
 * Servlet implementation class updateBarang
 */
public class updateBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateBarang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String db = "toko_imba";
		java.sql.Connection con = null;
		int id = Integer.parseInt(request.getParameter("id_barang"));
		int jml = Integer.parseInt(request.getParameter("jumlah"));
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+db, Database.getUser(), Database.getPass());
			System.out.println (db+ "database successfully opened.");
		
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM inventori WHERE id_inventori = " + id);
			int jumlahDiDatabaseWow = 0;
			while(rs.next()){
				jumlahDiDatabaseWow = rs.getInt("jumlah");
				break;
			}
			
			
			if(jml <= jumlahDiDatabaseWow){
				HttpSession session = request.getSession(true);
				
				System.out.println("masuk ke yg udah ada");

				boolean found = false;
				ArrayList<Point> cart = (ArrayList<Point>) session.getAttribute("cart");
				for(Point p: cart){
					if(p.x == id){
						found = true;
						response.getWriter().write("Updated!");
						p.y = jml;
						break;
					}
				}
				
				if(!found){
					response.getWriter().write("Item tidak ditemukan!");
				}
				session.setAttribute("cart", cart);
				
			} else {
				response.getWriter().write("Jumlah tidak mencukupi!");
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("SQLException caught: " +e.getMessage());
		}		
	}
}
