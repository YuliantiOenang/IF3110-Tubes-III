<% request.setAttribute("page_title", "Hello RuSerBa!"); %>
<jsp:include page="/WEB-INF/jsp/begin.jsp" />
<p>Hello!</p>
<% request.removeAttribute("msg"); %>
<jsp:include page="/WEB-INF/jsp/end.jsp" />