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
public class barang extends HttpServlet{
    private String barang_id;
    
    @Override
    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        if(request.getRequestURL() != null) {
            String[] url = request.getRequestURI().split("/");
            if(url.length > 3)
                barang_id = url[3];
            System.out.println(barang_id);
        }
        Proses proses = new Proses();
        HashMap<String, String> result = proses.showBarang(barang_id);
        request.setAttribute("data", result);
        RequestDispatcher view = request.getRequestDispatcher("/aplikasi/page/barang.jsp");
        view.forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        if(request.getRequestURL() != null) {
            String[] url = request.getRequestURI().split("/");
            if(url.length > 3)
                barang_id = url[3];
        }
        doPost(request, response);
    }
}
