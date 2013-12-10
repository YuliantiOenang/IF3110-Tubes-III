<%@page import="com.oracle.jrockit.jfr.DataType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src='${pageContext.request.contextPath}/ajax.js'></script>
<script>
	function getquery() {
		var query = "select * from user";
		sendQuery(query, function() {
			var jsonArray = JSON.parse(xmlhttp.responseText);
			var b = jsonArray.result[0][1];
			document.write(b);
		});
	}
	
</script>

</head>

<body>
	<div id='test'>
		<script>getquery();</script>
	</div>
</body>
</html>