<%

session.invalidate();
Cookie[] cookies = request.getCookies();
if(cookies!=null)
for (int i = 0; i < cookies.length; i++) {
 cookies[i].setMaxAge(0);
response.addCookie(cookies[i]);
}
response.sendRedirect("index.jsp");
%>