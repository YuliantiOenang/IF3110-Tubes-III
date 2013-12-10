<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ include file= "./header.jsp" %>
<script type="text/javascript" src="verify2.js"></script>
<div id="profilehere">
<script>
	getProfileContent();
</script>
</div>
<script>
function getProfileContent(){
	var detail = document.getElementById("profilehere");
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
	xmlhttp.open("GET","getProfileContent?idbarang="+id,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send();
}
</script>
<%@ include file= "./footer.jsp" %>