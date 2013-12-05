package adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import databaseLib.DatabaseAdapter;

/**
 * Servlet implementation class CekBarang
 */
@WebServlet("/admin/cekBarang")
public class CekBarang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DatabaseAdapter DBA;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CekBarang() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String name = request.getParameter("name");
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			DBA.executeQuery("select * from barang where nama='"+name+"'");
			if (!DBA.getQueryResult().next()) json.put("content", "UNIK");
			else json.put("content", "TIDAK UNIK"); 
			//System.out.println(DBA.getQueryResult().getObject(0));
			out.write(json.toString());
			out.close();
		}catch (Exception e){System.out.println("ERROR"+e.getMessage());}
	}

}
