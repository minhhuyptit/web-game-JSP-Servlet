<%-- 
    Document   : header
    Created on : Sep 3, 2018, 7:08:34 PM
    Author     : huyla
--%>
<%@page import="snow.model.User"%>
<%@page import="snow.model.Category"%>
<%@page import="snow.dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Start Header -->
<header class="header-top">
    <section class="container">
        <section class="logo">
            <img src="<%= request.getContextPath()%>/template/images/logo.gif" alt="Logo">
        </section>
        <form action="<%= request.getContextPath()%>/view/search.jsp" class="searchform cf" method="get">
            <input type="text" name="search" placeholder="Bạn muốn chơi game gì?">
            <button type="submit">Search</button>
        </form>
        <%
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
        %>
        <div id="info-user">
            Xin chào <span><%= user.getUserUserName()%></span> | 
            <a href="<%= request.getContextPath()%>/view/logout.jsp">Thoát</a>
        </div>
        <% } else {%>
            <button type="submit" id="button-login"><a href="<%= request.getContextPath()%>/view/login.jsp">Đăng nhập</a></button>
            <button type="submit" id="button-register"><a href="<%= request.getContextPath()%>/view/register.jsp">Đăng ký</a></button>
        <% } %>
    </section>
</header>
<!-- End Header -->


<!-- Start Menu -->
<%
    CategoryDAO categoryDAO = new CategoryDAO();
%>
<nav class="menu">
    <section class="container">
        <ul>
            <li><a href="<%= request.getContextPath()%>/view/index.jsp">Trang chủ</a></li>
                <% for (Category item : categoryDAO.getListCategory()) {
                        if (item.isVisiableMenu()) {
                %>
            <li><a href="<%= request.getContextPath()%>/view/theloaigame.jsp?id=<%= item.getCategoryID()%>"><%= item.getCategoryName()%></a></li>
                <%
                        }
                    }
                %>
            <li><a href="#">Thể loại khác</a></li>
        </ul>
    </section>
</nav>

<!-- End Menu -->