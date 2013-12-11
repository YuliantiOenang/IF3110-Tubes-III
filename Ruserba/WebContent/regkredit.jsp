<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
    <%@ page import="javax.swing.JFrame" %>
    <%@ page import="javax.swing.JOptionPane" %>
    <%@ page import="javafiles.*" %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<%
	  String no_kartu = request.getParameter("kartu");
      String nama_pemegang_kartu = request.getParameter("nama");
	  
	  if (no_kartu != null ) {
		  String connectionURL = "jdbc:mysql://localhost:3306/waserda";  
               try{  

               Class.forName("com.mysql.jdbc.Driver");  
               Connection con=DriverManager.getConnection(connectionURL, "java", "java");  
               Statement st=con.createStatement();  
               ResultSet rs=st.executeQuery("select no_kartu,nama_pemegang_kartu from data_kartu_kredit");  
               while(rs.next())  
                  {  
                   String no=rs.getString(1);    
                   String name=rs.getString(2); 
                   if(no_kartu.equals(no) && nama_pemegang_kartu.equals(name)){    
                       out.println("Berhasil");  
                       javafiles.BarangManager.Kartu(no);
                   	break;
                   }  
                           
               }
               if(!rs.next()){
            	   out.println("Gagal");
               }
          }catch(Exception e1){} 
		 
	      %>
	      
	      <script>
	      	out.println("Berhasil");
	          alert("Data berhasil ditambah");
	  	  </script><%
	  }
	%>
	
	<form method="post" action="regkredit.jsp">
	            	<table>
	                    <tr>
	                        <td> Nomor Kartu  : </td><td> <input name="kartu" type="text" /> </td> 
	                    </tr>
	                    <tr>
	                        <td> Nama Pemegang  : </td><td> <input name="nama" type="text" /> </td> 
	                    </tr>
	                <input type="submit" value="Submit" />
	            </form>
		<a href="index.jsp">Home</a>
</body>
</html>