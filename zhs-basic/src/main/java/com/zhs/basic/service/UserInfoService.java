package com.zhs.basic.service;


import com.zhs.basic.model.UserInfo;

public interface UserInfoService{


    public void save(UserInfo userInfo);


    public void update(UserInfo userInfo);


    public UserInfo findByAccount(String account);


    public UserInfo findById(Long id);


    public void deleteById(Long id);


}
