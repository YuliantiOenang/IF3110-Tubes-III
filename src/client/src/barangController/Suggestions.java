package barangController;

import java.io.IOException;
import java.io.PrintWriter;
import javaModel.Barang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databaseLib.DatabaseAdapter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Suggestions
 */
@WebServlet("/barang/suggestions")
public class Suggestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAdapter DBA;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suggestions() {
        super();
        DBA = new DatabaseAdapter();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HTTP/1.1 200 OK Content-Type
		try
		{
			String name;
			
			if (request.getParameter("name")==null) name="";
			else name = request.getParameter("name");
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			JSONObject json = new JSONObject();
			
			String str="";
			
			if (!name.equals("")) 
			{
				String Query = "select * from barang where nama LIKE '%"+name+"%'";
				DBA.executeQuery(Query);
				System.out.println(Query);
				str = str + "<ul>";
				while (DBA.getQueryResult().next())
				{
					str = str + "<li>";
					str = str + "<a href=\"#\" onclick=\"suggestions(this);\">";
					str = str + DBA.getQueryResult().getObject(3);
					str = str + "</a>";
					str = str + "</li>";
				}
				str = str + "</ul>";
			}
			
			json.put("content",str);
			out.write(json.toString());
			out.close();
		}catch (Exception e){}
	}

}
