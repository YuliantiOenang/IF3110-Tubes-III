package webservice;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import json.JSONObject;
import model.Model;

/**
 * Servlet implementation class select
 */
public class webservice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webservice() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String replacer(String data) {
        try {
           StringBuffer tempBuffer = new StringBuffer();
           int incrementor = 0;
           int dataLength = data.length();
           while (incrementor < dataLength) {
              char charecterAt = data.charAt(incrementor);
              if (charecterAt == '%') {
                 tempBuffer.append("<percentage>");
              } else if (charecterAt == '+') {
                 tempBuffer.append("<plus>");
              } else {
                 tempBuffer.append(charecterAt);
              }
              incrementor++;
           }
           data = tempBuffer.toString();
           data = URLDecoder.decode(data, "utf-8");
           data = data.replaceAll("<percentage>", "%");
           data = data.replaceAll("<plus>", "+");
        } catch (Exception e) {
           e.printStackTrace();
        }
        return data;
     }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model(replacer(request.getParameter("table")));
		boolean action = model.runSQLSyntax(replacer(request.getParameter("sqlsyntax")));
		JSONObject jsonobj = new JSONObject();
		if (action)
			jsonobj.put("status", "success");
		else {
			jsonobj.put("status", "failed");
			jsonobj.put("message", model.errorMessage);
		}
		response.getWriter().println(jsonobj);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model(replacer(request.getParameter("table")));
		Vector<HashMap<String,String>> data = new Vector();
		if ((request.getParameter("parameter")==null)&&(request.getParameter("id")==null))
		{
			data = model.findAll();
		}
		else if ((request.getParameter("parameter")!=null))
		{
			data = model.findByCondition(replacer(request.getParameter("parameter")));
		}
		else if ((request.getParameter("id")!=null))
		{
			HashMap<String,String> map = model.findById(Integer.parseInt(replacer(request.getParameter("id"))));
			data.add(map);
		}
		
		JSONObject jsonobj = new JSONObject();
		if (data.size()>0) {
			jsonobj.put("status", "success");
			jsonobj.put("data", data);
		}
		else
			jsonobj.put("status", "failed");
		response.getWriter().println(jsonobj);
	}

}
