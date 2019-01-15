package com.zhs.feign.controller;

import com.zhs.feign.service.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * Created by Zhang on 2018/11/30.
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {


    @Override
    public String hello(String name) {
        return "Hello World";
    }
}
