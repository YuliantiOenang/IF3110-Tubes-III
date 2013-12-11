<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="sampleSoapProxyid" scope="session" class="tubes2wbd.SoapProxy" />
<%
 sampleSoapProxyid.setEndpoint("http://dichbar.ap01.aws.af.cm/services/soap");
%>

<%

try {
        String username_1id=  request.getParameter("username");
            java.lang.String username_1idTemp = null;
        if(!username_1id.equals("")){
         username_1idTemp  = username_1id;
        }
        String password_2id=  request.getParameter("password");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        String nama_3id=  request.getParameter("nama");
            java.lang.String nama_3idTemp = null;
        if(!nama_3id.equals("")){
         nama_3idTemp  = nama_3id;
        }
        String nohp_4id=  request.getParameter("nohp");
            java.lang.String nohp_4idTemp = null;
        if(!nohp_4id.equals("")){
         nohp_4idTemp  = nohp_4id;
        }
        String alamat_5id=  request.getParameter("alamat");
            java.lang.String alamat_5idTemp = null;
        if(!alamat_5id.equals("")){
         alamat_5idTemp  = alamat_5id;
        }
        String provinsi_6id=  request.getParameter("provinsi");
            java.lang.String provinsi_6idTemp = null;
        if(!provinsi_6id.equals("")){
         provinsi_6idTemp  = provinsi_6id;
        }
        String kota_7id=  request.getParameter("kota");
            java.lang.String kota_7idTemp = null;
        if(!kota_7id.equals("")){
         kota_7idTemp  = kota_7id;
        }
        String kodepos_8id=  request.getParameter("kodepos");
            java.lang.String kodepos_8idTemp = null;
        if(!kodepos_8id.equals("")){
         kodepos_8idTemp  = kodepos_8id;
        }
        String email_9id=  request.getParameter("email");
            java.lang.String email_9idTemp = null;
        if(!email_9id.equals("")){
         email_9idTemp  = email_9id;
        }
        java.lang.String registeruser13mtemp = sampleSoapProxyid.registeruser(username_1idTemp,password_2idTemp,nama_3idTemp,nohp_4idTemp,alamat_5idTemp,provinsi_6idTemp,kota_7idTemp,kodepos_8idTemp,email_9idTemp);
if(registeruser13mtemp == null){
%>
<%=registeruser13mtemp %>
<%
}else{
        //String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registeruser13mtemp));
        %>
		<%=registeruser13mtemp %>
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