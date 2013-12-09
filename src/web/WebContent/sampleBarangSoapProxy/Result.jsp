<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBarangSoapProxyid" scope="session" class="com.frexesc.soap.BarangSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBarangSoapProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleBarangSoapProxyid.getEndpoint();
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
        sampleBarangSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.frexesc.soap.BarangSoap getBarangSoap10mtemp = sampleBarangSoapProxyid.getBarangSoap();
if(getBarangSoap10mtemp == null){
%>
<%=getBarangSoap10mtemp %>
<%
}else{
        if(getBarangSoap10mtemp!= null){
        String tempreturnp11 = getBarangSoap10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String id_category_1id=  request.getParameter("id_category16");
        long id_category_1idTemp  = Long.parseLong(id_category_1id);
        String name_2id=  request.getParameter("name18");
            java.lang.String name_2idTemp = null;
        if(!name_2id.equals("")){
         name_2idTemp  = name_2id;
        }
        String picture_3id=  request.getParameter("picture20");
            java.lang.String picture_3idTemp = null;
        if(!picture_3id.equals("")){
         picture_3idTemp  = picture_3id;
        }
        String price_4id=  request.getParameter("price22");
        int price_4idTemp  = Integer.parseInt(price_4id);
        String description_5id=  request.getParameter("description24");
            java.lang.String description_5idTemp = null;
        if(!description_5id.equals("")){
         description_5idTemp  = description_5id;
        }
        String total_item_6id=  request.getParameter("total_item26");
        int total_item_6idTemp  = Integer.parseInt(total_item_6id);
        sampleBarangSoapProxyid.addBarang(id_category_1idTemp,name_2idTemp,picture_3idTemp,price_4idTemp,description_5idTemp,total_item_6idTemp);
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