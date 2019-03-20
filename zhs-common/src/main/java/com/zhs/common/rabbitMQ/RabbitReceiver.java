package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Zhang on 2019/3/20.
 */
@Component
public class RabbitReceiver {


    @RabbitListener(queues = RabbitMQ.TEST)
    public void hello(Object o){
        System.out.println("消息測試");
    }

}
