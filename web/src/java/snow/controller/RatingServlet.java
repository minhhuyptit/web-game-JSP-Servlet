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
import snow.tool.Helper;

/**
 *
 * @author huyla
 */
public class RatingServlet extends HttpServlet {

    GameDAO gameDAO = new GameDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int count = Integer.parseInt(request.getParameter("count"));
        int id_game = Integer.parseInt(request.getParameter("id_game"));
        boolean increment = (count % 2 == 1);
        try {
            gameDAO.updateLuotYeuThich(id_game, increment);
            response.getWriter().print( Helper.formatNumber(gameDAO.getLuotYeuThich(id_game)) );
            
        } catch (SQLException ex) {
            Logger.getLogger(RatingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}
