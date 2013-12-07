package transactionController;

import java.io.IOException;
import java.util.ArrayList;

import javaModel.Barang;
import javaModel.Helper;
import javaModel.Kategori;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class Home
 */
@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA = new DatabaseAdapter();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		boolean isLogin = false;
		if (session.getAttribute("isLogin")!=null)
			isLogin = (boolean)session.getAttribute("isLogin");
		
		if (isLogin) {
			int total = 0;
			
			ArrayList <String> arrayn = new ArrayList<String>();
			ArrayList <String> arrayid = new ArrayList<String>();
			ArrayList <String> arrayc = new ArrayList<String>();
			ArrayList <String> arrayp = new ArrayList<String>();
			ArrayList <String> arrayq = new ArrayList<String>();
			ArrayList <String> arrayst = new ArrayList<String>();
			if (session.getAttribute("dibeli")!=null) {
				ArrayList <String> array = (ArrayList<String>) session.getAttribute("dibeli");
				total = 0;;
				Kategori K = Helper.findAllKategori();
				for (int i = 0; i < array.size (); i ++) {
					if (session.getAttribute(array.get(i))==null)
						continue;
					if (!session.getAttribute(array.get(i)).equals("0")){
						int jml = 0;
						String sjml = (String) session.getAttribute(array.get(i));
//						sjml = "12";
//						System.out.println (sjml);
						for (int j = 0; j < sjml.length(); j ++) {
							jml = jml * 10 + (int) (sjml.charAt(j) - '0');
						}
						String q = "select * from barang where id = "+array.get(i);
						String k = "";
						Barang B = new Barang(DBA);
						B.executeQuery(q);
						for (int i1 = 0; i1 < K.id.size(); i1++)
							if (K.id.get(i1).equals(B.id_kat.get(0))) {
								k = K.nama_kategori.get(i1);
								break;
							}				
						
						int harga = 0;
						for (int j = 0; j < B.harga.get(0).length(); j ++) {
							harga = harga * 10 + (int) (B.harga.get(0).charAt(j) - '0');
						}
						int subtotal = harga * jml;
						total += subtotal;
						arrayn.add(B.nama.get(0));
						arrayc.add(k);
						arrayid.add(array.get(0));
						arrayp.add(B.harga.get(0));
						arrayq.add(jml+"");
						arrayst.add(subtotal+"");
//						System.out.println (jml + " " + subtotal);
					}
				}
			} 
			request.setAttribute("total_shopping",total);
			System.out.println (request.getAttribute("total_shopping"));
			request.setAttribute("namabeli",arrayn);
			request.setAttribute("idbeli",arrayid);
			request.setAttribute("katbeli",arrayc);
			request.setAttribute("hargabeli",arrayp);
			request.setAttribute("jumlahbeli",arrayq);
			request.setAttribute("stbeli",arrayst);
			
			request.setAttribute("includeJspContent", "shoppingcart.jsp");
			request.getRequestDispatcher("/view/layout.jsp").forward(request, response);	
		} else {
			response.sendRedirect("home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
