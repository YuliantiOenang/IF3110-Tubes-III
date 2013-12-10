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
		var query = document.forms['form']['text'].value;
		sendGet("Receiver?url=http://tubeswbd.ap01.aws.af.cm/test?query="
				+ query, function() {
			var jsonArray = JSON.parse(xmlhttp.responseText);
			var b = jsonArray.result[0];
			document.getElementById('test').innerHTML = b;
		});
	}
</script>

</head>

<body>
	<form id='form' method="GET" action="javascript:getquery();">
		<input type="text" id="text"> <input type="submit"
			value="submit">
	</form>
	<div id='test'></div>
</body>
</html>