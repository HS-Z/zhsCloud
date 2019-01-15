package com.zhs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhang on 2018/12/4.
 */
@RestController
@RefreshScope  // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class TestController {


    @Value("${zhs-name}")
    String foo;


    /**
     * 测试地址：http://localhost:8007/hi
     * @return
     */
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
