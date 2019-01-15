package com.zhs.feign.controller;

import com.zhs.feign.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Zhang on 2018/11/29.
 */
@RestController
public class HelloController {

    @Autowired
    HelloRemote helloRemote;


    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String param) {
        System.out.println("feign服务被调用");
        return helloRemote.hello(param);
    }

}
