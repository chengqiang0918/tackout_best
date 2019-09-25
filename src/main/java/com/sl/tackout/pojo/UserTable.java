package com.sl.tackout.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by happy on 2019/8/21.
 */
@Data
public class UserTable implements Serializable {
    private int userId;//用户id
    private String userName;//用户名
    private String userPwd;//用户密码
    private String userRealname;//用户真名
    private String userPhone;//用户手机号
    private String userAdress;//用户地址
    private Date userCreatTime;//用户创建时间
    private String userPhoto;//用户头像

    public UserTable() {
    }

    public UserTable(int userId, String userName, String userPwd, String userRealname, String userPhone, String userAdress, Date userCreatTime, String userPhoto) {

        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.userPhone = userPhone;
        this.userAdress = userAdress;
        this.userCreatTime = userCreatTime;
        this.userPhoto = userPhoto;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public Date getUserCreatTime() {
        return userCreatTime;
    }

    public void setUserCreatTime(Date userCreatTime) {
        this.userCreatTime = userCreatTime;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAdress='" + userAdress + '\'' +
                ", userCreatTime=" + userCreatTime +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}
