<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>RuSerBa</title>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
</head>
<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<%@ include file="header.jsp" %>
	<article id="featured" class="body">
	<form method="post" action="editbarang">
		<h2>Edit</h2>
		<% 
		Connection conn = null;
	    Statement stmt = null;
	    String id;
	    if(request.getParameter("id")!=null){
	    	id=request.getParameter("id");
	    }else{
	    	id="1";
	    }
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql;
            sql = "select * from barang where id="+id;
            ResultSet rs = stmt.executeQuery(sql);
          	// Extract data from result set
          	while(rs.next()){
          		out.println("<input type=\"hidden\" value='"+id+"'name='id'>"
          				+"<pre>Nama Barang	: <input type=\"text\" name=\"nama\" value="+rs.getString("nama")+"></pre>"
                		+"<pre>Kategori		: <input type=\"text\" name=\"kategori\" value="+rs.getString("kategori")+"></pre>"
                		+"<pre>Harga		: <input type=\"text\" name=\"harga\" value="+rs.getString("harga")+"></pre>"
                		+"<pre>Jumlah		: <input type=\"text\" name=\"jumlah\" value="+rs.getString("jumlah")+"></pre>"
                		+"<pre id=\"addedrequest\">Deskripsi		: <textarea name=\"deskripsi\" cols=\"25\" rows=\"5\">"+rs.getString("keterangan")+"</textarea></pre>"
                		+"<pre>Link Gambar	: <input type=\"text\" name=\"img\" value="+rs.getString("gambar")+"></pre>");
          	}
          	// Clean-up environment
          	rs.close();
          	stmt.close();
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		%>
		<input type="submit" value="Edit">
	</form>
	</article><!-- /#featured -->
	<%@ include file="footer.jsp" %>
	</div>
</body>
</html>