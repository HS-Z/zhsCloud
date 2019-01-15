package com.zhs.common;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.zhs"})
@EnableRedisHttpSession   //开启session管理
@EnableTransactionManagement  //开启事务管理
@EnableEurekaClient
public class ZhsCommonApplication {

}
