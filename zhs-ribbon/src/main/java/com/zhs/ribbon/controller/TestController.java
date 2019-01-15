package com.zhs.ribbon.controller;


import com.zhs.ribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhang on 2018/12/3.
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "sayHello")
    public String sayHello(@RequestParam String param){
        System.out.println("ribbon服务被调用");
        String backParam=testService.sayHello(param);
        return backParam;
    }


}
