<%-- 
    Document   : inc_playgame
    Created on : Sep 10, 2018, 8:29:40 PM
    Author     : huyla
--%>

<%@page import="snow.tool.Helper"%>
<%@page import="snow.model.Advertising"%>
<%@page import="snow.model.Game"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="snow.dao.CategoryDAO"%>
<%@page import="snow.dao.AdvertisingDAO"%>
<%@page import="snow.dao.GameDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    int id_game = 1;
    if (request.getParameter("id") != null) {
        try {
            id_game = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
    GameDAO gameDAO = new GameDAO();    
    AdvertisingDAO advertisingDAO = new AdvertisingDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    
    gameDAO.updateLuotChoi(id_game);
    Game game = gameDAO.getGame(id_game);
    
    String nameCategory = gameDAO.getNamCategory(id_game);
    
    ArrayList<Game> listGameChoiNhieuNhat = gameDAO.getListGameChoiNhieuNhatByIDGame(id_game);
    ArrayList<Game> listGameYeuThichNhat = gameDAO.getListGameYeuThichNhatByIDGame(id_game);
%>

<section class="content-left">
    <header class="title-box-playgame"><%= game.getGameName()%></header>
    <section class="box-playgame">
        <object>
            <param name="movie" value="<%= request.getContextPath()%>/template/games/data/<%= game.getGameFile() %>">
            <param name="quality" value="high">
            <embed src="<%= request.getContextPath()%>/template/games/data/<%= game.getGameFile() %>" 
                   quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"
                   type="application/x-shockwave-flash">
        </object>
        <section class="content-box-playgame">
            <div class="like">
                <p id="like">
                    <input class="star" id="star" type="checkbox" name="star" />
                    <label class="star" for="star"></label>
                </p>
                <p class="soluong" id="luotyeuthich" ><%= Helper.formatNumber(game.getGameLuotYeuThich()) %></p>
                <p id="dow">
                    <input id="dow" class="dow" type="button" name="dow" />
                    <label class="dow" for="dow"></label>
                </p>
                <p class="soluong"><%= Helper.formatNumber(game.getGameLuotChoi()) %></p>
                <p id="share">
                    <input id="fullscreen" class="fullscreen" type="button" name="share" />
                    <label class="fullscreen" for="fullscreen"></label>
                </p>
                <div style="float:left; margin-top: 22px; margin-left: 25px">
                    <jsp:include page="addthis_share.jsp"></jsp:include>
                </div>
                <div style="float:left; margin-left: 20px">
                    <jsp:include page="facebook_share.jsp"></jsp:include>
                </div>
            </div>
            <%= game.getGameContent()%>
            <jsp:include page="facebook_comment.jsp"></jsp:include>
        </section>
    </section>
    <section class="game-cung-theloai">
        <header class="title-game-cung-theloai">
            <section class="tentheloai"><a href="#"><%= nameCategory %></a></section>
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
            <% } %>
        </section>
    </section>
    <section class="game-choinhieunhat">
        <header class="title-game-choinhieunhat">Game yêu thích nhiều nhất</header>
        <section class="content-game-choinhieunhat">
            <%
                int count_3 = 0;
                int size_3 = listGameYeuThichNhat.size();
                for (Game item : listGameYeuThichNhat) {
                    count_3++;
                    String className = (count_3 % size_3 == 0) ? "box-game-choinhieunhat-last" : "box-game-choinhieunhat";
            %>
            <article class="<%= className%>">
                <a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= item.getGameID()%>">
                    <img src="<%= request.getContextPath()%>/template/games/img/<%= item.getGameImage()%>" 
                         alt="<%= item.getGameName()%>"></a>
                <section>
                    <a href="<%= request.getContextPath()%>/view/playgame.jsp?id=<%= item.getGameID()%>"><h5><%= Helper.cutString(item.getGameName(), 20)%></h5></a>
                    <p>Lượt yêu thích: <%= Helper.formatNumber(item.getGameLuotYeuThich())%></p>
                </section>
            </article>
            <% }%>
        </section>
    </section>
</aside>
