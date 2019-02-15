package com.zhs.basic;


import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.zhs.common.ZhsCommonApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@MapperScan("com.zhs.basic.dao.MybatisMapper")
@EnableFeignClients(basePackages = {"com.zhs.basic.service.feign"})  //启用feign进行远程调用
@EnableDistributedTransaction   //tx-lcn
public class ZhsBasicApplication extends ZhsCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhsBasicApplication.class, args);
    }
}
