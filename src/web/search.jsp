<%-- 
    Document   : search
    Created on : Nov 27, 2013, 9:32:49 PM
    Author     : A46CB
--%>


<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Register"/> 
</jsp:include> 
    <div class="section page">
    <div class="wrapper">
        <h1>Search</h1>
        <form method="GET" action="searchresult.jsp" id="searchform">
					<input type="text" class="search" name="keyword">
					<input type="submit" value="search" class="search-btn">
					<form>
    </div>
</div>
<%@include file="footer.jsp" %>