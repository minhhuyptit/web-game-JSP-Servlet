<%-- 
    Document   : footer
    Created on : Sep 3, 2018, 7:08:48 PM
    Author     : huyla
--%>
<%@page import="snow.dao.CategoryDAO"%>
<%@page import="snow.model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    CategoryDAO categoryDAO = new CategoryDAO();
%>

<section class="sitemap">
    
    <%
        int count = 0;
        for (Category item : categoryDAO.getListCategory()) {
            count++;
            String className = (count % 5 == 0) ? "box-sitemap-last" : "box-sitemap";
    %>
    <div class="<%= className %>"><a href="<%= request.getContextPath()%>/view/theloaigame.jsp?id=<%= item.getCategoryID() %>"><%= item.getCategoryName()%></a></div>
    <%            
        }
    %>
</section>

<footer class="footer">
    <a href="#"><img src="<%= request.getContextPath()%>/template/images/facebook.png" /></a>
    <a href="#"><img src="<%= request.getContextPath()%>/template/images/gmail.png" /></a>
    <a href="#"><img src="<%= request.getContextPath()%>/template/images/contact.png" /></a>
    <a href="#"><img src="<%= request.getContextPath()%>/template/images/map.png" /></a>
    <div>
        <p>
            Chịu trách nhiệm nội dung: Nhật Tường - Minh Huy - Thanh Lộc - Trúc Phương.</br>
            Chơi game lành mạnh, vui vẻ, sắp xếp thời gian hợp lý, tận hưởng cuộc sống lành mạnh, học tập tốt và lao động
            tốt. </br>
            ©2018 học viên Công Nghê Bưu Chính Viễn Thông, Địa chỉ: Man Thiện, Q9,
            tp.HCM . Điện thoại: 024 2242 6188.</p>
    </div>

</footer>