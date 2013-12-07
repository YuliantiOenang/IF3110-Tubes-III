/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ruserba.database.DatabaseHelper;

/**
 *
 * @author ize
 */
public class RequestServlet extends HttpServlet {

    static HashMap<String, String> pages;
    static final String suffix = " | Ruko Serba Ada";
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pages = new HashMap<String, String>();
        pages.put("register", "Pendaftaran");
        pages.put("search", " - Hasil Pencarian");
        pages.put("profile", "Profil");
        pages.put("registerkartu", "Pendaftaran Kartu Kredit");
        pages.put("kategori", "");
        pages.put("barang", "");
        pages.put("cart", "Keranjang Belanja");
        pages.put("admin", "Admin");
        pages.put("adminedit", "Edit Item");
        pages.put("adminadd", "Add Item");
        pages.put("barang", "Barang");
        pages.put("home", "Home");
        pages.put("cart", "Cart");
        pages.put("kategori", "Kategori");
    }
    
    private String getPageTitle(String name) {
        if (pages.containsKey(name)) {
            return pages.get(name);
        }
        return "404";
    }
    
    private String getPageContent(String name) {
        System.out.println(name);
        if (pages.containsKey(name)) {
            return name + ".jsp";
        }
        return "error.jsp";
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>");
            String page = request.getParameter("page");
            if (page != null) {
                String title = getPageTitle(page);
                DatabaseHelper.Connect();
                if (page.equals("kategori")) {
                    String query = "select nama_kategori from kategori where id_kategori=" + request.getParameter("id");
                    ResultSet result = DatabaseHelper.executeQuery(query);
                    try {
                        result.next();
                        title = result.getString("nama_kategori");
                    } catch (SQLException ex) {
                        Logger.getLogger(RequestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (page.equals("barang")) {
                    String query = "select nama_barang from barang where id_barang=" + request.getParameter("id");
                    ResultSet result = DatabaseHelper.executeQuery(query);
                    try {
                        result.next();
                        title = result.getString("nama_barang");
                    } catch (SQLException ex) {
                        Logger.getLogger(RequestServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (page.equals("search")) {
                    title = URLDecoder.decode(request.getParameter("q"), "UTF-8") + title;
                }
                DatabaseHelper.Disconnect();
                out.println(title);
            }
            else {
                out.println("Beranda");
            }
            out.println(suffix);
            out.println("</title>");
            out.println("<link rel='icon' type='image/png' href='/ruserba/assets/favicon.PNG' />");
            out.println("<link rel='stylesheet' media='only screen and (min-width:1224px)' href='/ruserba/css/desktop.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='wrapper'>");
            out.println("<div id='header'>");
            request.getRequestDispatcher("header.jsp").include(request, response);
            out.println("</div>");
            out.println("<div class='divider'>");
            out.println("</div>");
            out.println("<div id='content'>");
            if (page != null) {
                request.getRequestDispatcher(getPageContent(page)).include(request, response);
            }
            else {
                request.getRequestDispatcher("home.jsp").include(request, response);
            }
            out.println("</div>");
            out.println("<div class='divider'>");
            out.println("</div>");
            out.println("<div id='footer'>");
            request.getRequestDispatcher("footer.jsp").include(request, response);
            out.println("</div>");
            out.println("<br/><br/><br/><br/><br/><br/>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
