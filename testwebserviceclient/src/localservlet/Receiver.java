package localservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Receiver
 */
@WebServlet("/Receiver")
public class Receiver extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receiver() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                String USER_AGENT = "Mozilla/5.0";
                String url = request.getParameter("url");
                
                String[] tokens = url.split(" ");
                String newUrl = "";
                for (int i = 0; i < tokens.length; i++) {
                        newUrl += tokens[i]+"+";
                }
                url = newUrl;

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
                // optional default is GET
                con.setRequestMethod("GET");
 
                //add request header
                con.setRequestProperty("User-Agent", USER_AGENT);
 
                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
 
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine = null;
                StringBuffer resp = new StringBuffer();
                String temp = null;
                
                while ((temp = in.readLine()) != null) {
                        inputLine = temp;
                        resp.append(inputLine);
                }
                System.out.println(inputLine);
                
                // Send data to jsp
                PrintWriter out = response.getWriter();
                if (inputLine == null) out.write(1);
                else out.write(inputLine);
                in.close();
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
        }

}