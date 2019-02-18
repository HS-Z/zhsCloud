package com.zhs.basic.serviceImpl;

import com.zhs.basic.dao.JpaRepository.UserInfoRepository;
import com.zhs.basic.dao.MybatisMapper.UserInfoMapper;
import com.zhs.basic.model.UserInfo;
import com.zhs.basic.service.UserInfoService;
import com.zhs.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends CommonService implements UserInfoService{

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 新增
     * @param userInfo
     */
    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    /**
     * 更新（必须有主键id）
     * @param userInfo
     */
    public void update(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }


    public UserInfo findByAccount(String account) {
        UserInfo userInfo=userInfoMapper.findByAccount(account);
        return userInfo;
    }


    public UserInfo findById(Long id) {
        UserInfo userInfo=userInfoRepository.getOne(id);
        return userInfo;
    }

    public void deleteById(Long id){
        userInfoRepository.deleteById(id);
    }

}
