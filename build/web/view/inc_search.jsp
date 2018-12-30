<%-- 
    Document   : inc_search
    Created on : Sep 11, 2018, 2:37:18 PM
    Author     : huyla
--%>

<%@page import="snow.model.Advertising"%>
<%@page import="snow.dao.AdvertisingDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
      AdvertisingDAO advertisingDAO = new AdvertisingDAO();

%>

<section class="content-left">
    <section class="game-cung-theloai">
        <header class="title-game-cung-theloai">
            <section class="tentheloai"><a href="#"><%= request.getParameter("search") %></a></section>
        </header>
        <section class="list-game"></section>
        <button type="button" class="box-game-xemthem">Xem thêm</button>
    </section>
</section>
<aside class="content-right">
    <section class="quangcao">
        <% for (Advertising item : advertisingDAO.getListAds(2)) {%>
        <a href="<%= item.getAdsURL()%>" target="<%= item.getAdsTarget()%>"> 
            <img src="<%= request.getContextPath()%>/template/images/quangcao/<%= item.getAdsFile()%>" alt="<%= item.getAdsTitle()%>"></a>
            <% } %>
    </section>
</aside>

