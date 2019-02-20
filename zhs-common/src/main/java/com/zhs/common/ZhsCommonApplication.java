package com.zhs.common;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication(scanBasePackages = {"com.zhs"})
@EnableRedisHttpSession   //开启session管理
@EnableEurekaClient
public class ZhsCommonApplication {

}
