/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.if3110.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Setyo Legowo <setyo.legowo@live.com>
 */
public class kategori extends HttpServlet {
    private String page;
    private String sort;
    private String by;
    private String kat;
    
    @Override
    public void doPost(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        if(request.getRequestURL() != null) {
            String[] url = request.getRequestURI().split("/");
            if(url.length > 3)
                kat = url[3];
            page = request.getParameter("page");
            sort = request.getParameter("sort");
            by = request.getParameter("by");
            System.out.println(kat);
        }
        try {
            DBConnector dbCon = DBConnector.getInstance();
            Connection con = dbCon.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT DISTINCT COUNT(*) AS total FROM barang_data WHERE kategori_id = " + kat);
            
            res.next();
            int sisa = res.getInt("total") % 10;
            int page_no = ((res.getInt("total") - sisa)/10) + 1;
            Proses proses = new Proses();
            JSONObject json_result;
            if(page == null) {
                json_result = proses.showKategoriNonFilter(String.valueOf(kat), "?page=1");
            } else {
                json_result = proses.showKategoriWithFilter(String.valueOf(kat), "?by=" + by + "&sort=" + sort + "&page=" + page);
            }
            request.setAttribute("nama_kategori", json_result.getString("nama_kategori"));
            request.setAttribute("data", json_result.getJSONArray("data"));
            request.setAttribute("page_no", page_no);
        } catch (Exception ex) {
            Logger.getLogger(kategori.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher("/aplikasi/page/kategori.jsp");
        view.forward(request, response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                      throws IOException, ServletException {
        if(request.getRequestURL() != null) {
            String[] url = request.getRequestURI().split("/");
            if(url.length > 3)
                kat = url[3];
        }
        page = request.getParameter("page");
        sort = request.getParameter("sort");
        by = request.getParameter("by");
        doPost(request, response);
    }
    
}
