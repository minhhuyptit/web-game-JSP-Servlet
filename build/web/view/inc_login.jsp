<%-- 
    Document   : inc_login
    Created on : Sep 9, 2018, 6:23:26 PM
    Author     : huyla
--%>

<%@page import="snow.tool.Helper"%>
<%@page import="snow.model.Game"%>
<%@page import="snow.dao.CategoryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="snow.dao.GameDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GameDAO gameDAO = new GameDAO();
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
        <header class="title-login-register">ĐĂNG NHẬP</header>
        <form action="<%= request.getContextPath()%>/UserServlet" method="post" id="login-register-form">
            <% if(request.getAttribute("error") != null){ %>
            <div class="row" style="background-color: #f76565; padding: 20px 60px">
                <li><%= request.getAttribute("error") %></li>
            </div>
            <% } %>
            <div class="row">
                <label for="username">Tên đăng nhập<span class="red asterisk bold"> *</span></label>
                <input name="username" id="username" type="text" required autofocus >
            </div>
            <div class="row">
                <label for="password">Mật khẩu<span class="red asterisk bold"> *</span></label>
                <input name="password" id="password" type="password" required >
            </div>
            <div class="row-submit">
                <input type="hidden" name="command" value="login" > 
                <button type="submit" name="submit">Đăng nhập</button>
            </div>
        </form>
    </section>
</section>
<aside class="content-right">
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