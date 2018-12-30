/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snow.model;

/**
 *
 * @author huyla
 */
public class User {
    private int userID;
    private String userUserName;
    private String userPassword;
    private String userEmail;
    private String userFullName;
    private String Sex;
    private String userBirthday;
    private String userAddress;

    public User() {
    }

    public User(int userID, String userUserName, String userPassword, String userEmail, String userFullName, String Sex, String userBirthday, String userAddress) {
        this.userID = userID;
        this.userUserName = userUserName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userFullName = userFullName;
        this.Sex = Sex;
        this.userBirthday = userBirthday;
        this.userAddress = userAddress;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    
}
