<%-- 
    Document   : inc_register
    Created on : Sep 6, 2018, 8:58:30 PM
    Author     : huyla
--%>

<%@page import="snow.tool.Helper"%>
<%@page import="snow.model.Advertising"%>
<%@page import="snow.model.Game"%>
<%@page import="java.util.ArrayList"%>
<%@page import="snow.dao.CategoryDAO"%>
<%@page import="snow.dao.AdvertisingDAO"%>
<%@page import="snow.dao.GameDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    GameDAO gameDAO = new GameDAO();
    AdvertisingDAO advertisingDAO = new AdvertisingDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    ArrayList<Game> listGameHot = gameDAO.getListGameHot();
    ArrayList<Game> listGameChoiNhieuNhat = gameDAO.getListGameChoiNhieuNhat();

%>

<section class="content-left">
    <section class="game-hot">
        <section class="slider">
            <div id="wowslider-container1">
                <div class="ws_images">
                    <ul>
                        <% for (int i = 0; i < 5; i++) {%>
                        <li><a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= listGameHot.get(i).getGameID()%>" target="_self">
                                <img src="<%= request.getContextPath()%>/template/games/img/<%= listGameHot.get(i).getGameImage()%>" 
                                     alt="<%= listGameHot.get(i).getGameName()%>" title="<%= listGameHot.get(i).getGameName()%>" />
                            </a>
                        </li>
                        <% }%>
                    </ul>
                </div>
                <div class="ws_bullets">
                    <div>
                        <% for (int i = 0; i < 5; i++) {%>
                        <a href="#" title="<%= listGameHot.get(i).getGameName()%>"><%= (i + 1)%></a>
                        <% }%>
                    </div>
                </div>
            </div>
        </section>
        <aside class="sidebar">
            <header class="title-gamehot">Game hay</header>
            <section class="content-gamehot">
                <%
                    int count_1 = 0;
                    for (int i = 5; i < 11; i++) {
                        count_1++;
                        String className = (count_1 % 3 == 0) ? "box-gamehot-last" : "box-gamehot";
                %>
                <article class="<%= className%>">
                    <a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= listGameHot.get(i).getGameID()%>">
                        <img src="<%= request.getContextPath()%>/template/games/img/<%= listGameHot.get(i).getGameImage()%>" 
                             alt="<%= listGameHot.get(i).getGameName()%>"></a>
                    <h3><a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= listGameHot.get(i).getGameID()%>"><%= listGameHot.get(i).getGameName()%></a></h3>
                </article>
                <% }%>
            </section>
        </aside>
    </section>
    <section class="login">
        <header class="title-login-register">ĐĂNG KÝ THÀNH VIÊN</header>
        <form action="<%= request.getContextPath()%>/UserServlet" method="post" id="login-register-form">
            <% if(request.getAttribute("error") != null){ %>
            <div class="row" style="background-color: #f76565; padding: 20px 60px">
                <li><%= request.getAttribute("error") %></li>
            </div>
            <% } %>
            <div class="row">
                <label for="username">Tên đăng nhập<span class="red asterisk bold"> *</span></label>
                <input name="username" id="username" type="text" required autofocus pattern="^[a-z\d\.]{6,}$" title="Ít nhất 8 kí tự & không khoảng trắng">
                <span id="user-result" style="position: relative; top: 8px"></span>
            </div>
            <div class="row">
                <label for="password">Mật khẩu<span class="red asterisk bold"> *</span></label>
                <input name="password" id="password" type="password" required pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
                       title="Ít nhất 8 kí tự bao gồm chữ hoa, chữ thường, số">
            </div>
            <div class="row">
                <label for="email">Email<span class="red asterisk bold"> *</span></label>
                <input name="email" id="email" type="email" required>
            </div>
            <div class="row">
                <label for="name">Họ & tên</label>
                <input name="name" id="name" type="text">
            </div>
            <div class="row">
                <label for="">Giới tính</label>
                <input name="sex" value="nam" type="radio">Nam&nbsp;&nbsp;
                <input name="sex" value="nu" type="radio">Nữ
            </div>
            <div class="row">
                <label for="birthday">Ngày sinh</label>
                <input name="birthday" id="birthday" type="date">
            </div>
            <div class="row">
                <label for="address">Địa chỉ</label>
                <input name="address" id="address" type="text">
            </div>
            <div class="row-submit">
                <input type="hidden" name="command" value="insert" > 
                <button type="submit" name="submit">Đăng ký</button>
                <button type="reset">Làm lại</button>
            </div>


        </form>
    </section>
</section>
<aside class="content-right">
    <section class="quangcao">
        <% for (Advertising item : advertisingDAO.getListAds(1)) {%>
        <a href="<%= item.getAdsURL()%>" target="<%= item.getAdsTarget()%>"> 
            <img src="<%= request.getContextPath()%>/template/images/quangcao/<%= item.getAdsFile()%>" alt="<%= item.getAdsTitle()%>"></a>
            <% } %>
    </section>
    <section class="game-choinhieunhat">
        <header class="title-game-choinhieunhat">Game chơi nhiều nhất</header>
        <section class="content-game-choinhieunhat">
            <%
                int count_2 = 0;
                int size_2 = listGameChoiNhieuNhat.size();
                for (Game item : listGameChoiNhieuNhat) {
                    count_2++;
                    String className = (count_2 % size_2 == 0) ? "box-game-choinhieunhat-last" : "box-game-choinhieunhat";
            %>
            <article class="<%= className%>">
                <a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= item.getGameID()%>">
                    <img src="<%= request.getContextPath()%>/template/games/img/<%= item.getGameImage()%>" 
                         alt="<%= item.getGameName()%>"></a>
                <section>
                    <a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= item.getGameID()%>"><h5><%= Helper.cutString(item.getGameName(), 20)%></h5></a>
                    <p>Lượt chơi: <%= Helper.formatNumber(item.getGameLuotChoi())%></p>
                </section> 
            </article> 
            <% }%>
        </section>
    </section>
</aside>