<%-- 
    Document   : logout
    Created on : Sep 9, 2018, 7:08:54 PM
    Author     : huyla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  session.removeAttribute("user");
  response.sendRedirect(request.getContextPath() + "/view/index.jsp");
%>
