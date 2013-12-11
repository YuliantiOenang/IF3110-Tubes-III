<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="helloJsp.object.ShoppingCart"%>
<%@page import="helloJsp.object.Item"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import= "java.net.HttpURLConnection"%>
<%@page import= "java.net.URL" %>
<%@ page import="org.json.JSONObject"%>
<%@ page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="public/css/style.css">
<script type="text/javascript" src="public/js/cart.js"></script>
<title>Chintalian &#9733 &#9733 &#9733 &#9733 &#9733 dinner italian cuisine</title>
</head>

<body class="container" alink=#000000 vlink=#000000>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="helloJsp.model.ModelInventori"%>
	<%@include file="templates/header.jsp"%>

	<%
		ArrayList<ModelInventori> TabelBarang = new ArrayList<ModelInventori>();
		TabelBarang = (ArrayList<ModelInventori>) session.getAttribute("tabel");
	%>
	<div class="fullbar">
		<h2>YOUR CART</h2>
		<%
			if(session.getAttribute("card") == null){
				if(session.getAttribute("user") == null)
					response.sendRedirect("registrasi.jsp");
				else
					response.sendRedirect("registerCardForm.jsp");
			}
			
			if (request.getParameter("buy") != null){
				JSONObject json = new JSONObject(session.getAttribute("shoppingCart"));
				System.out.println("test :"+json.toString());
				
				String url = "http://wbd3.ap01.aws.af.cm/cart?type=3&json='"+json.toString()+"'";
				try {
					JSONObject jobj = new JSONObject(json.toString());
					System.out.println("jobj = "+jobj.toString());
					JSONArray j2 = jobj.getJSONArray("items");
					System.out.println("j2 = "+j2.toString());
					ShoppingCart sc = new ShoppingCart();
					for (int i=0; i<j2.length(); i++){
						JSONObject json1 = j2.getJSONObject(i);
						Item barang = new Item(json1.getInt("quantity"),json1.getInt("idItem"),json1.getInt("price"),json1.getString("description"));
						sc.getItems().add(barang);
						System.out.println(sc.getItems().get(i).getIdItem()+" "+sc.getItems().get(i).getPrice()+" "+sc.getItems().get(i).getQuantity()+" "+sc.getItems().get(i).getDescription());
					}
					} catch (JSONException e){
						out.println(-1);
					}
				
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();

				// optional default is GET
				con.setRequestMethod("GET");

				//add request header
				con.setRequestProperty("User-Agent", "Mozilla/5.0");

				int responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer sresponse = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					sresponse.append(inputLine);
				}
				in.close();
				
				session.removeAttribute("shoppingCart");
				
				int sr = Integer.parseInt(sresponse.toString().split(" ")[0]);
				System.out.println("ke index : "+sr);
				
				if(sr == -1){
					response.sendRedirect("index.jsp?msg='bought unsuccessfully...'");
				} else if(sr == 0){
					response.sendRedirect("index.jsp?msg='bought not successful due stock reasons...'");
				} else if(sr == 11){
					response.sendRedirect("index.jsp?msg='bought successfully!'");
				} else {
					response.sendRedirect("index.jsp?msg='bought unsuccessfully...'");
				}
			}
			
			int total = 0;
			if (session.getAttribute("shoppingCart") != null) {
				ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingCart");
				out.println("");
				for (int i = 0; i < sc.getItems().size(); i++) {
					int temp = 0;
					for (int j = 0; j < TabelBarang.size(); j++) {
						if(TabelBarang.get(j).getId_inventori() == sc.getItems().get(i).getIdItem()){
							temp = j;
							break;
						}
					}
					out.println("(" + (i + 1) + ") <input type='number' value=" + sc.getItems().get(i).getQuantity() + " size=5 > " + TabelBarang.get(temp).getNama_inventori()+ " Rp. "+sc.getItems().get(i).getQuantity()*sc.getItems().get(i).getPrice() +",- <button onClick='deleteFromCart("+ (i) +")'>delete</button><br/>");
					if(sc.getItems().get(i).getDescription().equals("")){
						out.println("No special order<br/>");
					} else
						out.println("Special order : " + sc.getItems().get(i).getDescription());
					total += sc.getItems().get(i).getQuantity()*sc.getItems().get(i).getPrice();
				}
			}
			out.println("<br/><b>Total price: Rp. " + total+",-</b>");
			
			out.println("<a href='viewCart.jsp?buy=1'><button>buy</button></a>");
		%>
	</div>
	</div>
	<script>
		<%
			if (request.getParameter("msg") != null){
		%>
		alert(<%=request.getParameter("msg")%>);
		<% } %>
	</script>
	<%@include file="templates/footer.jsp"%>
</body>
</html>