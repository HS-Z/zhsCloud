package com.zhs.feign.service;

import com.zhs.feign.controller.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zhang on 2018/11/29.
 */

/**
 * 启用熔断
 */
@FeignClient(name = "zhs-provider", fallback = HelloRemoteHystrix.class)
@Component
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}
