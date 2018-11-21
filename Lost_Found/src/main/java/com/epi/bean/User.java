package com.epi.bean;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userTime=" + userTime +
            '}';
    }

    private String userEmail;
    public User(){

    }
    public User(Integer userId, String userName, String userPassword, String userEmail, Date userTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userTime = userTime;
    }

    private Date userTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }
}