/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class Keranjang extends HttpServlet {
    
    HttpSession session;
    
    @Override
    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        session = request.getSession(true);
        String shopping_bag = (String) session.getAttribute("shopping_bag");
        try {
            Proses proses = new Proses();
            JSONObject result = proses.showShoppingBag(shopping_bag);
            request.setAttribute("keranjang", result);
        } catch (Exception ex) {
            Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher("/aplikasi/page/keranjang_belanja.jsp");
        view.forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        doPost(request, response);
    }
}
