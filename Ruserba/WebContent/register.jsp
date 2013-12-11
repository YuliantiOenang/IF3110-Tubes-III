<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
    <%@ page import="javax.swing.JFrame" %>
    <%@ page import="javax.swing.JOptionPane" %>
    <%@ page import="javafiles.*" %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="assets/js/header.js"></script>
<link href="assets/css/default.css" rel="stylesheet" type="text/css"/>
<title>Register</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<%
	  String user = request.getParameter("username");
	  String pass = request.getParameter("password");
	  String Rpass = request.getParameter("Rpassword");
	  String nama = request.getParameter("nama");
	  String nohp = request.getParameter("hp");
	  String alamat = request.getParameter("addr");
	  String prov = request.getParameter("prov");
	  String kota = request.getParameter("kota");
	  String kodepos = request.getParameter("pos");
	  String email = request.getParameter("email");
      
	  
	  if (user != null && pass != null && nama != null 
			  && nohp != null && alamat != null && prov != null 
			  && kota != null && kodepos != null && email != null) {
		  String connectionURL = "jdbc:mysql://localhost:3306/waserda";  
          boolean found = false;
		  boolean Nama = false;
		  boolean Em = false;
		  boolean Em1 = false;
		  boolean Em2 = false;
		  int ALoc = 0;
		  
		  if(nama.length() < 3){
			  Nama = false;
		  } else {
			  for (int i=0; i<nama.length(); i++){
				  if (nama.charAt(i) == ' ' && (i!=0 || i!=nama.length()-1)){
					  Nama = true;
					  break;
				  }
			  }
		  }
		  
		  for(int i=0; i<email.length(); i++){
			  if(email.charAt(i) == '@' && i>0){
				  Em1 = true;
			  	  ALoc = i;
			  }
			  if(Em1 && email.charAt(i) == '.' && (i-ALoc)>1 && (email.length()-i) > 2){
				  Em = true;
			  }
		  }
		  
               try{  

               Class.forName("com.mysql.jdbc.Driver");  
               Connection con=DriverManager.getConnection(connectionURL, "java", "java");  
               Statement st=con.createStatement();  
               ResultSet rs=st.executeQuery("select username from data_user");  
               
               
               
               while(rs.next())  
                   {  
                   String username=rs.getString(1);    
                   if(user.equals(username)){    
                       out.println("Username sudah ada");  
                   	found = true;
                   	break;
                   }  
                           
               }  
               if(!found){
            	   if (!Rpass.equals(pass)){
          			 out.println("Password tidak sama");
          		 } else if (user.equals("") || pass.equals("")){
          			out.println("Username atau password tidak boleh kosong");
          		 } else if (user.length()<5) {
          		 	out.println("Username min 5 karakter");
               	 } else if (pass.length()<8){
               		 out.println("Password min 8 karakter");
               	 } else if (user.equals(pass) || pass.equals(email)){
               		 out.println("Password tidak boleh sama dengan user ataupun email");
               	 } else if (!Nama){
               		 out.println("Nama harus terdiri dari nama depan dan nama belakang");
               	 } else if (!Em){
               		 out.println("Syntax email salah");
               	 }
          		 else {
          		  javafiles.BarangManager.User(user, pass, nama, nohp, alamat, prov, kota, kodepos, email);
          		  out.println("Data berhasil ditambah");
          		 }
               }
          }catch(Exception e1){} 
		 
	      %>
	      
	      <script>
	      	out.println("Berhasil");
	          alert("Data berhasil ditambah");
	  	  </script><%
	  }
	%>
	
	<form method="post" action="register.jsp">
	            	<table>
	                    <tr>
	                        <td> Username  : </td><td> <input name="username" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Password  : </td><td> <input name="password" type="password" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Repeat Password  : </td><td> <input name="Rpassword" type="password" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Nama Lengkap  : </td><td> <input name="nama" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> No HP  : </td><td> <input name="hp" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Alamat  : </td><td> <input name="addr" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Provinsi  : </td><td> <input name="prov" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Kota  : </td><td> <input name="kota" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Kode pos  : </td><td> <input name="pos"type="text" /> </td> 
	                    </tr>
	                    <tr>
							<td>Email</td><td> <input type="text" name="email"></td>
						</tr>
	                </table>
	                <input type="submit" value="Submit" />
	            </form>
		<a href="index.jsp">Home</a>
		<jsp:include page="footer.jsp"/>
</body>
</html>