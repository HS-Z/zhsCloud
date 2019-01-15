package com.zhs.basic.controller;


import com.zhs.basic.model.UserInfo;
import com.zhs.basic.service.UserInfoService;
import com.zhs.common.constant.RedisKey;
import com.zhs.common.redis.RedisUtils;
import com.zhs.common.utils.SessionUtils;
import com.zhs.common.vo.Json;
import com.zhs.common.vo.SessionInfo;
import com.zhs.common.vo.UserInfoVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    private final Logger logger=LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SessionUtils sessionUtils;
    @Autowired
    private UserInfoService userInfoService;


    /**
     * 拦截非法请求，跳转到登陆页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }


    @RequestMapping(value = "loginSystem",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Json loginSystem(@RequestParam("account") String account, @RequestParam("password") String password){

        Json json=new Json();

        Subject subject = SecurityUtils.getSubject();

        // 将用户名及密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);

        try {
            subject.login(token);
            // 判断当前用户是否登录
            if (subject.isAuthenticated()) {  //登陆成功

                redisUtils.remove(RedisKey.LOGIN_LOCK + account);   //登陆成功，清除锁定标记
                redisUtils.remove(RedisKey.LOGIN_COUNT + account);  //登陆成功，清除错误记录数

                UserInfo userInfo=userInfoService.findByAccount(account);  //根据账号查询用户信息

                UserInfoVo userInfoVo = new UserInfoVo();

                BeanUtils.copyProperties(userInfo,userInfoVo);
                sessionUtils.setSessionInfo(userInfoVo);  //将用户信息保存到session


                json.setSuccess(true);
                return json;
            }

        } catch (LockedAccountException e){  // 账号被锁定
            Long min=redisUtils.getExpire(RedisKey.LOGIN_LOCK + account) / 60 ;  // 账号锁定失效时间，单位为秒
            json.setSuccess(false);
            json.setMsg("该账号已被锁定，请"+ min +"分钟后再尝试登陆");
        } catch (UnknownAccountException e) {  // 账号不存在
            json.setSuccess(false);
            json.setMsg("用户名/密码错误");
        } catch (IncorrectCredentialsException e){  // 密码错误
            json.setSuccess(false);
            json.setMsg("用户名/密码错误");
        } catch (ExcessiveAttemptsException e){  // 登陆失败次数过多
            json.setSuccess(false);
            json.setMsg("登录失败多次，账户锁定1小时");
        } catch (AuthenticationException e) {
            json.setSuccess(false);
            json.setMsg("登陆失败");
        }
        return json;
    }


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){

        SessionInfo sessionInfo=sessionUtils.getSessionInfo();
        if (sessionInfo == null){
            return "login";
        }

        Long userId=sessionInfo.getUserId();  //当前登陆用户id
        if (userId == null){
            return "login";
        }
        UserInfo userInfo = userInfoService.findById(userId);
        if (userInfo == null){
            return "login";
        }

        logger.info("用户登陆成功，登陆账号为[{}]，用户名为[{}]",sessionInfo.getAccount(),sessionInfo.getUserName());



        return "index";
    }


}
