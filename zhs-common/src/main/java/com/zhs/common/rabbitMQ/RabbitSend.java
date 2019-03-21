package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Zhang on 2019/3/20.
 * 消息生产者
 */
@Component
public class RabbitSend {


    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(String a, Object o){

//        this.amqpTemplate.convertAndSend(a,o);
        this.amqpTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.QUEUE_MESSAGE,"hahhhahhahahahahha");  //
        this.amqpTemplate.convertAndSend(RabbitMQ.FANOUT_EXCHANGE,"","Fanout");  //广播模式

    }


}
