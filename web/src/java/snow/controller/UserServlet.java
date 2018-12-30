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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import snow.dao.UserDAO;
import snow.model.User;
import snow.tool.MD5;

/**
 *
 * @author huyla
 */
public class UserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        User user = new User();
        String url = "";
//        PrintWriter pw = response.getWriter();

        switch (command) {
            case "insert":
                if (request.getParameter("user-result").equals("true")) {
                    user.setUserUserName(request.getParameter("username"));
                    user.setUserPassword(request.getParameter("password"));
                    user.setUserEmail(request.getParameter("email"));
                    user.setUserFullName(request.getParameter("name"));
                    if (request.getParameter("sex") != null) {
                        String sex = (request.getParameter("sex").equals("nam")) ? "Nam" : "Nữ";
                        user.setSex(sex);
                    }
                    if (!request.getParameter("birthday").equals("")) {
                        user.setUserBirthday(request.getParameter("birthday"));
                    }
                    user.setUserAddress(request.getParameter("address"));
                    userDAO.insertUser(user);
                    request.setAttribute("message", "Chúc mừng bạn đăng ký tài khoản thành công. <br>"
                            + "Bạn cần vào hộp thư Mail để <span style=\"color:red\">xác thực</span> tài khoản.");
                    url = "/view/success.jsp";
                } else if (request.getParameter("user-result").equals("false")) {
                    url = "/view/register.jsp";
                    request.setAttribute("error", "Username is already exists");
                }
                break;
            case "login":
                String username = request.getParameter("username");
                String password = MD5.encryption(request.getParameter("password"));
                 {
                    try {
                        user = userDAO.login(username, password);
                        if (user != null) {
                            if (user.getUserID() == 0) {  //Nếu ID == 0 tức là tài khoản chưa được kích hoạt
                                request.setAttribute("message", "Tài khoản của bạn vẫn chưa xác thực qua Email <br>"
                                        + "Vui lòng vào hộp thư Mail để <span style=\"color:red\">kích hoạt</span> tài khoản");
                                url = "/view/success.jsp";
                            }else{
                                session.setAttribute("user", user);
                                url = "/view/index.jsp";
                            }
                        } else {
                            request.setAttribute("error", "Error username or password");
                            url = "/view/login.jsp";
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
