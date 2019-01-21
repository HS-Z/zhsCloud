package com.zhs.zuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Zhang on 2019/1/21.
 */
public class ErrorFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);


    @Override
    public String filterType() {
        //异常处理器
        return "error";
    }

    @Override
    public int filterOrder() {
        //优先级，数字越小，越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();

        log.info("进入异常过滤器");

        System.out.println(ctx.getResponseBody());

        ctx.setResponseBody("出现异常");

        return null;
    }
}
