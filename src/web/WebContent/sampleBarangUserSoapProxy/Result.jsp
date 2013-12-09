<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBarangUserSoapProxyid" scope="session" class="com.frexesc.soap.BarangUserSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBarangUserSoapProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleBarangUserSoapProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleBarangUserSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.frexesc.soap.BarangUserSoap getBarangUserSoap10mtemp = sampleBarangUserSoapProxyid.getBarangUserSoap();
if(getBarangUserSoap10mtemp == null){
%>
<%=getBarangUserSoap10mtemp %>
<%
}else{
        if(getBarangUserSoap10mtemp!= null){
        String tempreturnp11 = getBarangUserSoap10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String id_item_1id=  request.getParameter("id_item16");
        long id_item_1idTemp  = Long.parseLong(id_item_1id);
        String id_user_2id=  request.getParameter("id_user18");
        long id_user_2idTemp  = Long.parseLong(id_user_2id);
        String total_item_3id=  request.getParameter("total_item20");
        int total_item_3idTemp  = Integer.parseInt(total_item_3id);
        String description_4id=  request.getParameter("description22");
            java.lang.String description_4idTemp = null;
        if(!description_4id.equals("")){
         description_4idTemp  = description_4id;
        }
        sampleBarangUserSoapProxyid.addCart(id_item_1idTemp,id_user_2idTemp,total_item_3idTemp,description_4idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>