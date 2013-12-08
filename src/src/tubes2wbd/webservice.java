package tubes2wbd;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class webservice
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

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url =  request.getParameter("url");	
		String type = request.getParameter("type");
		System.out.println(url + " - " + type);
		
		if (type != null)
		{
			response.setContentType("text/"+type);				
		}
		else
		{
			response.setContentType("text/plain");
		}
		
		while (true)
		{
			String new_url = url.replace("*", "&");
			if (new_url == null) break;
			if (new_url.equals(url)) break;
			
			url = new_url;
		}
		
		while (true)
		{
			String new_url = url.replace(" ", "+");
			if (new_url == null) break;
			if (new_url.equals(url)) break;
			
			url = new_url;
		}
		
		System.out.println(url);
		PrintWriter out = response.getWriter();
		try {
	        URL serviceURL = new URL(url);
	        InputStream is = serviceURL.openStream();
	        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	        BufferedReader br = new BufferedReader(isr);
	        
	        StringBuffer buff = new StringBuffer();
	        String nextLineFromService = br.readLine();
	        while (nextLineFromService != null) {
	            buff.append(nextLineFromService);
	            nextLineFromService = br.readLine();
	        }
	        
	        out.print(buff.toString());
	    }
	    catch (Exception e) {
	        //out.println(e);
	    }
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url =  request.getParameter("url");	
		String type = request.getParameter("type");
		
		if (type != null)
		{
			response.setContentType("text/"+type);				
		}
		else
		{
			response.setContentType("text/plain");
		}
		
		PrintWriter out = response.getWriter();
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		Enumeration<String> parameterNames = request.getParameterNames();
		String urlParameters = "";
		
		int j = 0;
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			
			if (paramName.equals("url") || paramName.equals("type"))
				continue;
			
			out.write(paramName);
			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				if (j > 0) urlParameters += "&";
				j++;
                urlParameters += paramName+"="+paramValue;
                System.out.println(paramName+"="+paramValue);
                
	        }

		}
		
		while (true)
		{
			String new_urlParameters = urlParameters.replace(" ", "+");
			if (new_urlParameters == null) break;
			if (new_urlParameters.equals(urlParameters)) break;
			
			urlParameters = new_urlParameters;
		}
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer buff = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			buff.append(inputLine);
		}
		in.close();
 
		//print result
		out.println(buff.toString());
	}


}
