<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleUserSoapProxyid" scope="session" class="com.frexesc.soap.UserSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleUserSoapProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleUserSoapProxyid.getEndpoint();
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
        sampleUserSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.frexesc.soap.UserSoap getUserSoap10mtemp = sampleUserSoapProxyid.getUserSoap();
if(getUserSoap10mtemp == null){
%>
<%=getUserSoap10mtemp %>
<%
}else{
        if(getUserSoap10mtemp!= null){
        String tempreturnp11 = getUserSoap10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String username_1id=  request.getParameter("username16");
            java.lang.String username_1idTemp = null;
        if(!username_1id.equals("")){
         username_1idTemp  = username_1id;
        }
        String password_2id=  request.getParameter("password18");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        String email_3id=  request.getParameter("email20");
            java.lang.String email_3idTemp = null;
        if(!email_3id.equals("")){
         email_3idTemp  = email_3id;
        }
        String name_4id=  request.getParameter("name22");
            java.lang.String name_4idTemp = null;
        if(!name_4id.equals("")){
         name_4idTemp  = name_4id;
        }
        String telephone_5id=  request.getParameter("telephone24");
            java.lang.String telephone_5idTemp = null;
        if(!telephone_5id.equals("")){
         telephone_5idTemp  = telephone_5id;
        }
        String address_6id=  request.getParameter("address26");
            java.lang.String address_6idTemp = null;
        if(!address_6id.equals("")){
         address_6idTemp  = address_6id;
        }
        String province_7id=  request.getParameter("province28");
            java.lang.String province_7idTemp = null;
        if(!province_7id.equals("")){
         province_7idTemp  = province_7id;
        }
        String city_8id=  request.getParameter("city30");
            java.lang.String city_8idTemp = null;
        if(!city_8id.equals("")){
         city_8idTemp  = city_8id;
        }
        String postal_9id=  request.getParameter("postal32");
            java.lang.String postal_9idTemp = null;
        if(!postal_9id.equals("")){
         postal_9idTemp  = postal_9id;
        }
        sampleUserSoapProxyid.register(username_1idTemp,password_2idTemp,email_3idTemp,name_4idTemp,telephone_5idTemp,address_6idTemp,province_7idTemp,city_8idTemp,postal_9idTemp);
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