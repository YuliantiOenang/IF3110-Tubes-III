<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.json.JSONObject"%>
<%@page import= "java.io.DataOutputStream"%>
<%@page import ="java.io.InputStreamReader"%>
<%@page import ="java.net.HttpURLConnection"%>
<%@page import ="java.net.URL"%>
<%@page import="javax.net.ssl.HttpsURLConnection"%>
<%@ page import ="java.io.BufferedReader"%>
<%@ page import ="java.io.InputStreamReader"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="public/css/style.css">
<title>Login</title>

</head>
<body>
<% 
if(session.getAttribute("user")!=null)
	response.sendRedirect("index.jsp");
boolean login=false;
if(request.getParameter("username")!=null&&request.getParameter("password")!=null){

	//out.println("username :"+request.getParameter("username"));
	//out.println("password : "+request.getParameter("password"));
	String username =request.getParameter("username");
	//out.println(username);
	String password =request.getParameter("password");
	//out.println(password);
	String url = "https://wbd3.ap01.aws.af.cm/login";
	URL obj = new URL(url);
	HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	 String USER_AGENT = "Mozilla/5.0";
	//add reuqest header
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

	String urlParameters = "username="+username+"&password="+password;

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
	StringBuffer responses = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		responses.append(inputLine);
	}
	System.out.println("this is response :"+responses);
	inputLine =responses.toString();
	in.close();
	if(inputLine.equals("welcome")){
		session.setAttribute("user", username);
		//setting session to expiry in 30 mins
		session.setMaxInactiveInterval(180000);
		Cookie userName = new Cookie("user", username);
		userName.setMaxAge(30*60);
		System.out.println("cookies : "+userName.getValue());
		response.addCookie(userName);
		response.sendRedirect("LoginSuccessful.jsp");
	}
	else{
		login=true;
		//request=null;
		//RequestDispatcher rd = getServletContext().getRequestDispatcher("login.jsp");
		//out.println("<font color=red>Either user name or password is wrong.</font>");
		//rd.include(request, response);
		//response.sendRedirect("login.jsp");
		
	}
	
	
}

	

%>
<div id="loginpages">

<form id="loginform" method="Post" action="login.jsp">
		<img id="chef" src="public/img/cartoon-chef-2.png"/><strong><h2 id="log">Login</h2></strong><br>
		<pre>Username			<input type="text" name="username" placeholder="username" id="username" /><span id="validasiUser"></span></pre>
		<pre>Password			<input type="password" name="password" placeholder="password" id="password" /><span id="validasiPass"></span></pre>
		<%if(login){out.println("<font color=red>Either user name or password is wrong.</font><br>");} %>
		<input type="submit" value="Login"> <a href='index.jsp'>Kembali</a></form>
</div>		
</body>
</html>