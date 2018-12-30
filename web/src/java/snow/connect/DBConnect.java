/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author huyla
 */
public class DBConnect {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            //Step 1 Đăng ký Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Step 2: Open Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game?useUnicode=true&characterEncoding=UTF-8", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
