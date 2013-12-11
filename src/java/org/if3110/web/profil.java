/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class profil extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("/aplikasi/page/profil_pelanggan.jsp");
        view.forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        doPost(request, response);
    }
}
