<%-- 
    Document   : logout
    Created on : Nov 27, 2013, 2:13:21 PM
    Author     : A46CB
--%>

<% 
    Cookie[] cookies = request.getCookies();
        if(cookies != null){
        for(Cookie cookie : cookies){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        }
        //invalidate the session if exists
        if(session != null){
            session.setAttribute("user", null);
            session.invalidate();
        }
        //no encoding because we have invalidated the session
        response.sendRedirect("index.jsp");
  %>
