<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<div id = "detailhere">
<script>
	getDetail(<%= request.getParameter("id") %>);
</script>
</div>
<script>
function getDetail(id){
	var detail = document.getElementById("detailhere");
	detail.innerHTML = "masuk sayang";
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200){
			detail.innerHTML = xmlhttp.responseText;

			if(err_login.innerHTML==""){
				//Handle SESSION & LOCAL STORAGE
				window.location="index.jsp";
			}
		}
	};
	xmlhttp.open("GET","getDetailBarang?idbarang="+id,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send();
}
</script>
<%@ include file= "./footer.jsp" %>