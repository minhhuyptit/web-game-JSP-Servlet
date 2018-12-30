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
import snow.dao.UserDAO;

/**
 *
 * @author huyla
 */
public class CheckUsernameServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (userDAO.checkUsername(request.getParameter("username"))) {
                response.getWriter().print("<img src=\"" + request.getContextPath() + "/template/images/delete.png\" >"
                + "<input type=\"hidden\"  name=\"user-result\" value=\"false\">");
            } else {
                response.getWriter().print("<img src=\"" + request.getContextPath() + "/template/images/check.png\" >"
                 + "<input type=\"hidden\"  name=\"user-result\" value=\"true\">");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckUsernameServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
