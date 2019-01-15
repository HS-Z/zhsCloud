package com.zhs.common.vo;

import java.util.Date;

/**
 * 用户信息
 */

public class UserInfoVo extends BaseModel {


    private String userName;  //用户名称

    private String userType;  //用户类型

    private String sex;  //性别 1男 2女 3保密

    private String account;  //登陆账号

    private String password;  //登陆密码

    private String security;  //加密时生成的key

    private String email;  //邮箱

    private String phone;  //手机号码

    private String address;  //住址

    private String state;  //用户状态

    private Date lastLoginTime;  //最近一次登陆时间（该值改变时，不更新lastUpdate）

    private Boolean isAdmin=Boolean.FALSE;  //是否是管理员

    private Boolean isLock=Boolean.FALSE;  //账号是否锁定，默认为否

    private Date lockTime;  //账号锁定时间

    private Boolean logOut=Boolean.FALSE;  //账号是否已注销，默认为否

    private Date logOutTime;  //账号注销时间


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Boolean getLogOut() {
        return logOut;
    }

    public void setLogOut(Boolean logOut) {
        this.logOut = logOut;
    }

    public Date getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(Date logOutTime) {
        this.logOutTime = logOutTime;
    }
}
