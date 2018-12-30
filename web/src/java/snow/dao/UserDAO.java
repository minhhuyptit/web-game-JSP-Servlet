/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import snow.connect.DBConnect;
import snow.model.User;
import snow.tool.Helper;
import snow.tool.MD5;
import snow.tool.Mail;

/**
 *
 * @author huyla
 */
public class UserDAO {

    public boolean insertUser(User user) {
        try {
            String randomKey = MD5.encryption(Helper.randomKey(20));
            Connection connection = DBConnect.getConnection();
            String query = "INSERT INTO `user` (`id`, `username`, `password`, `email`, `fullname`, `sex`, `birthday`, `address`, `randomkey`, `active`, `id_group`) "
                    + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserUserName());
            ps.setString(2, MD5.encryption(user.getUserPassword()));
            ps.setString(3, user.getUserEmail());
            ps.setString(4, user.getUserFullName());
            ps.setString(5, user.getSex());
            ps.setString(6, user.getUserBirthday());
            ps.setString(7, user.getUserAddress());
            ps.setString(8, randomKey);
            ps.setInt(9, 0);
            ps.setInt(10, 3);
            ps.executeUpdate();
            Mail.sendMail(user.getUserEmail(), "Active tài khoản", Mail.message(user, randomKey));         
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkUsername(String username) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM `user` WHERE `username` =?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            DBConnect.closeConnection(connection);
            return true;
        }
        return false;
    }

    public boolean activeUser(String username, String code) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String query = "UPDATE `user` SET `active` = 1 WHERE `username` = ? AND `randomkey` = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, code);
        if (ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public User login(String username, String password) throws SQLException{
        Connection connection = DBConnect.getConnection();
        String query = "SELECT *FROM `user` WHERE `username` = ? AND `password` = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet result = ps.executeQuery();
        if(result.next()){
            User user = new User();
            int active = result.getInt("active");
            if(active == 1){
                user.setUserID(result.getInt("id"));
            }else{
                user.setUserID(0);
            }
            user.setUserUserName(result.getString("username"));
            user.setUserPassword(result.getString("password"));
            user.setUserEmail(result.getString("email"));
            user.setUserFullName(result.getString("fullname"));
            user.setSex(result.getString("sex"));
            user.setUserBirthday(result.getDate("birthday").toString());
            user.setUserAddress(result.getString("address"));
            DBConnect.closeConnection(connection);
            return user;
        }
        return null;
    }
}
