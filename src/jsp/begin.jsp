<%--
	Input Specs
	-----------

	page_title: Title dari halaman, dalam string.
	css_file: File CSS custom, dalam string/arraylist.
	js_file: File javascript custom, dalam string/arraylist.

	Semua dalam attribute, bukan parameter.
--%>

<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title><%= (String)request.getAttribute("page_title") %></title>
	<link rel="stylesheet" type="text/css" href="styles/global.css" />
	<script type="text/javascript" src="scripts/global.js"></script>
	<%
		// Urus custom CSS dan javascript.
		ArrayList<String> css_file;
		ArrayList<String> js_file;
		int css_cnt = 0, js_cnt = 0;

		if (request.getAttribute("css_file") instanceof String)
		{
			css_file = new ArrayList<String>();
			css_file.add((String)request.getAttribute("css_file"));
		}
		else
		{
			css_file = (ArrayList<String>)request.getAttribute("css_file");
		}
		if (request.getAttribute("js_file") instanceof String)
		{
			js_file = new ArrayList<String>();
			js_file.add((String)request.getAttribute("js_file"));
		}
		else
		{
			js_file = (ArrayList<String>)request.getAttribute("js_file");
		}

		if (css_file != null) css_cnt = css_file.size();
		for (int i = 0; i < css_cnt; i++)
		{
			out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + css_file.get(i) + "\" />");
		}

		if (js_file != null) js_cnt = js_file.size();
		for (int i = 0; i < js_cnt; i++)
		{
			out.write("<script type=\"text/javascript\" src=\"" + js_file.get(i) + "\"></script>");
		}
	%>
<body>
	<div id="popuplayer"></div>
		<div id="core">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
		<div id="content">
