package com.zhs.provider.controller;

import com.zhs.provider.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Zhang on 2018/11/29.
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;  //服务端口

    @Autowired
    private RoleInfoService roleInfoService;


    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        System.out.println("来了来了");
        return "provider, " + name + " " + new Date();
    }


    @RequestMapping("/port")
    public String port(@RequestParam String p) {
        System.out.println(p);
        return "你好，服务端口号是： " + port + " " + new Date();
    }



    @RequestMapping("/txLcn")
    public void txLcn() {
        System.out.println("方法进来了-================");
        roleInfoService.txLcn();
    }




}
