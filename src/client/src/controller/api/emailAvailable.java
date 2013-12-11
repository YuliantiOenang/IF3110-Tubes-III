package controller.api;

import java.io.IOException;
import java.io.PrintWriter;

import json.*;

import javax.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import sun.org.mozilla.javascript.internal.json.JsonParser;

/**
 * Servlet implementation class emailAvaible
 */
@WebServlet("/api/emailAvailable")
public class emailAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emailAvailable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
        response.setContentType("application/json");
		Account model = new Account();
		int count = model.findByCondition("email = '" + request.getParameter("email")+"'").size();
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		if (count==1)
			jsonobj.put("status", false);
		else
			jsonobj.put("status", true);
		out.print(jsonobj);
	}
}
