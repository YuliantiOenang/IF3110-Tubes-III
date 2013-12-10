package localservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getTopItem
 */
@WebServlet("/getTopItem")
public class getTopItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTopItem() {
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
		String idkat = request.getParameter("idkat");
		String query = "SELECT * FROM `progin_13511059`.barang WHERE kategori_barang ="+idkat+" ORDER BY n_beli DESC LIMIT 0,3";
		String result = "";
		//INI NANTI MINTA DARI SERVLET
		for(int i =0; i < 3;i++){
			//UNTUK MENGULANGI SAMPE 3 TOP ITEM
			result+="<div class='product_box'>";
			result+="<h3> "+"</h3><br>";
			result+="<a href='detail.jsp?id="+"'><img src='"+"'/></a>";
			result+="<p class='product_price'>Harga : Rp "+",-<br>";
			result+="Stok : "+"<br>";
			result+="<form name='beli' action='addCart' method='post'>";
			result+="<input type='hidden' name='id_barang' value='"+"'>";
			result+="<input type='hidden' name='request_tambahan' value='-'>";
			result+="Quantity <input type='text' name='qt' style='width: 20px; text-align: right' />";
			result+="<input type='submit' value='Add to cart'>";
			result+="</form></p></div>";
		}
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
