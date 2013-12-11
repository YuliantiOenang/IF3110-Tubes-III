/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.if3110.model.UserManagement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class Home extends HttpServlet {
    
    HttpSession session;
    
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        session = request.getSession(true);
        String shopping_bag = (String) session.getAttribute("shopping_bag");
        int total_keranjang = 0;
        try {
            if(shopping_bag != null) {
                JSONObject result_bag = new JSONObject(shopping_bag);
                JSONArray result_bag_ari = result_bag.getJSONArray("data");
                total_keranjang = result_bag_ari.length();
            }
        } catch (JSONException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("total_keranjang", total_keranjang);
        
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        doPost(request, response);
    }
}
