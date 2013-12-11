package controller.api;

import model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.JSONObject;
import model.Account;

/**
 * Servlet implementation class checkCreditCard
 */
@WebServlet("/api/checkCreditCard")
public class checkCreditCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkCreditCard() {
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
		// TODO Auto-generated method stub
		String credit_number = request.getParameter("Credit[credit_number]");
		String credit_name = request.getParameter("Credit[name_of_card]");
		
		Kredit model = new Kredit();
		int countN = model.findByCondition("card_number = '" + request.getParameter("Credit[credit_number]")+"'").size();
		int countC = model.findByCondition("name_of_card = '" + request.getParameter("Credit[name_of_card]")+"'").size();
		PrintWriter out = response.getWriter();
		JSONObject jsonobj = new JSONObject();
		if (countN==1){
			jsonobj.put("success", false);
			jsonobj.put("error", "Card Number sudah dipakai bro");
		}
		else if (countC==1){
			jsonobj.put("success", false);
			jsonobj.put("error", "Name of Card sudah dipakai bro");
		}
		else{
			jsonobj.put("success", true);
		}
		out.print(jsonobj);
	}

}
