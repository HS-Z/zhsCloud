package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Zhang on 2019/3/20.
 */
@Component
public class RabbitReceiver {


    @RabbitListener(queues = RabbitMQ.DIRECT_QUEUE_A)
    public void directQueueA(Object o){
        System.out.println("RabbitReceiver ----> directQueueA ----> "+o.toString());
    }


    @RabbitListener(queues = RabbitMQ.DIRECT_QUEUE_B)
    public void directQueueB(Object o){
        System.out.println("RabbitReceiver ----> directQueueB ----> "+o.toString());
    }


    @RabbitListener(queues = RabbitMQ.TOPIC_QUEUE_A)
    public void topicQueueA(Object o){
        System.out.println("RabbitReceiver ----> topicQueueA ----> "+o.toString());
    }


    @RabbitListener(queues = RabbitMQ.TOPIC_QUEUE_B)
    public void topicQueueB(Object o){
        System.out.println("RabbitReceiver ----> topicQueueB ----> "+o.toString());
    }


    @RabbitListener(queues = RabbitMQ.TOPIC_QUEUE_C)
    public void topicQueueC(Object o){
        System.out.println("RabbitReceiver ----> topicQueueC ----> "+o.toString());
    }




}
