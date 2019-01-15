package com.zhs.common.utils;


import com.zhs.common.redis.RedisUtils;
import com.zhs.common.vo.SessionInfo;
import com.zhs.common.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Service
public final class SessionUtils implements Serializable {

    @Autowired
    private RedisUtils redisUtils;


    public SessionUtils(RedisUtils redisUtils) {
        if (redisUtils == null){
            throw new RuntimeException(" 未找到 Redis 缓存工具类");
        }
        this.redisUtils = redisUtils;
    }


    public SessionInfo setSessionInfo(UserInfoVo userInfoVo) {

        if (userInfoVo == null){
            throw new RuntimeException("获取账号信息失败");
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();

        if (request == null) {
            throw new RuntimeException("获取 request 失败");
        }

        if (session == null) {
            throw new RuntimeException("获取 session 失败");
        }

        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setUserId(userInfoVo.getId());
        sessionInfo.setUserName(userInfoVo.getUserName());
        sessionInfo.setUserType(userInfoVo.getUserType());
        sessionInfo.setAccount(userInfoVo.getAccount());

        session.setAttribute("sessionInfo",sessionInfo);

        return sessionInfo;
    }


    public SessionInfo getSessionInfo() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();

        if (request == null) {
            throw new RuntimeException("获取 request 失败");
        }

        if (session == null) {
            throw new RuntimeException("获取 session 失败");
        }

        SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");

        return sessionInfo;
    }

}
