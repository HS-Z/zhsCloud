package com.zhs.basic.feignClient.provider;

import com.zhs.common.constant.ServiceId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zhang on 2019/1/8.
 */
@FeignClient(value = ServiceId.ZHS_PROVIDER)
public interface RoleInfoClient {

    @RequestMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping("/txLcn")
    void txLcn();


}
