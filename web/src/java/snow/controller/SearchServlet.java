/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import snow.dao.GameDAO;
import snow.model.Game;
import snow.tool.Helper;

/**
 *
 * @author huyla
 */
public class SearchServlet extends HttpServlet {
    
    GameDAO gameDAO = new GameDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String keyword = request.getParameter("keyword");
        int position = Integer.parseInt(request.getParameter("position"));
        int item = Integer.parseInt(request.getParameter("item"));

        String xhtml = "";
        try {
            int count = 0;
            for (Game game : gameDAO.getListGameSearch(keyword, position, item)) {
                count++;
                String className = (count % 4 == 0) ? "box-game-last" : "box-game";
                xhtml += "<article class=\"" + className +"\">"
                        + "                        <a href=\"playgame.jsp?id=" + game.getGameID() + "\">"
                        + "                             <img src=\"" + request.getContextPath() + "/template/games/img/" + game.getGameImage() + "\" "
                                                            + "alt=\"" + game.getGameName() + "\"></a>"
                        + "                        <section>"
                        + "                            <a href=\"playgame.jsp?id=" + game.getGameID() + "\"><h5>" + Helper.cutString(game.getGameName(), 20)  + "</h5></a>"
                        + "                            <p>Lượt chơi: " + Helper.formatNumber(game.getGameLuotChoi()) + "</p>"
                        + "                        </section>"
                        + "                    </article>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadGameServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.getWriter().print(xhtml);        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
