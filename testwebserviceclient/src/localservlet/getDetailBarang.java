package localservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getDetailBarang
 */
@WebServlet("/getDetailBarang")
public class getDetailBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDetailBarang() {
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
		String idbarang = request.getParameter("idbarang");
		String query = "SELECT * FROM `progin_13511059`.barang WHERE id_barang ="+ idbarang;
		String result = "";
		//INI NANTI MINTA DARI SERVLET
		    result+="<h1>"+"</h1><br>";
		    result+="<img src='"+"' width='300px' height='300px'/><br>";
		    result+="<br><h2>Deskripsi :</h2><p>"+"</p><br>";
		    result+="Request tambahan 	: <br>";
		    result+="<form action='addCart' method='post' id='usrform'>";
		    result+="<textarea rows='4' cols='50'  name='request_tambahan' form='usrform'></textarea><br>";
		    result+="<input type='hidden' name='id_barang' value='"+"'>";
		    result+="Quantity : <input type='text' name='qt' style='width: 20px; text-align: right' /><br>";
		    result+="<input type='submit' value='Add to cart'></form>";
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
