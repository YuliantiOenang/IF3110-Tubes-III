<%
	request.setAttribute("msg", "Halo dunia! Pesan ini datang dari JSP attribute.");
	RequestDispatcher disp = request.getRequestDispatcher("/hello.jsp");
	disp.forward(request, response);
%>
