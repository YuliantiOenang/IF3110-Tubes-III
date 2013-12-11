<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="sampleSoapProxyid" scope="session" class="tubes2wbd.SoapProxy" />
<%
sampleSoapProxyid.setEndpoint("http://dichbar.ap01.aws.af.cm/services/soap");
%>

<%
response.setContentType("text/html");

try {
	 String nama_10id=  request.getParameter("nama");
     java.lang.String nama_10idTemp = null;
	 if(!nama_10id.equals("")){
	  nama_10idTemp  = nama_10id;
	 }
	 String img_11id=  request.getParameter("img");
	     java.lang.String img_11idTemp = null;
	 if(!img_11id.equals("")){
	  img_11idTemp  = img_11id;
	 }
	 String harga_12id=  request.getParameter("harga");
	     java.lang.String harga_12idTemp = null;
	 if(!harga_12id.equals("")){
	  harga_12idTemp  = harga_12id;
	 }
	 String kategori_13id=  request.getParameter("kategori");
	     java.lang.String kategori_13idTemp = null;
	 if(!kategori_13id.equals("")){
	  kategori_13idTemp  = kategori_13id;
	 }
	 String jumlah_14id=  request.getParameter("jumlah");
	     java.lang.String jumlah_14idTemp = null;
	 if(!jumlah_14id.equals("")){
	  jumlah_14idTemp  = jumlah_14id;
	 }
	 String deskripsi_15id=  request.getParameter("deskripsi");
	     java.lang.String deskripsi_15idTemp = null;
	 if(!deskripsi_15id.equals("")){
	  deskripsi_15idTemp  = deskripsi_15id;
	 }
	 java.lang.String additem34mtemp = sampleSoapProxyid.additem(nama_10idTemp,img_11idTemp,harga_12idTemp,kategori_13idTemp,jumlah_14idTemp,deskripsi_15idTemp);
	if(additem34mtemp == null){
	%>
	<%=additem34mtemp %>
	<%
	}else{
	 //String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(additem34mtemp));
	 %>
	 <%= additem34mtemp %>
	 <%
	}
} catch (Exception e) { 
	%>
	Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
	Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
	<%
	return;
}
%>