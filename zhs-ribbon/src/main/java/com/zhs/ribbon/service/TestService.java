package com.zhs.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Zhang on 2018/12/3.
 */
@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHello(String param){
        //可以直接使用服务名进行调用
        String backParam=restTemplate.getForObject("http://zhs-provider/hello?name="+param, String.class);
        return backParam;
    }


    public String hiError(String param) {
        return "hi,"+ param +",sorry,error!";
    }



}
