package com.zhs.basic.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Zhang on 2019/3/20.
 */
@Component
public class RabbitReceiver {


    /*@RabbitListener(queues = RabbitMQ.DIRECT_QUEUE_A)
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
    }*/


    @RabbitListener(queues = RabbitMQ.FANOUT_QUEUE_A)
    public void fanoutQueueA(Object o, Channel channel){
        System.out.println("RabbitReceiver ----> fanoutQueueA ----> "+o.toString());
    }


    @RabbitListener(queues = RabbitMQ.FANOUT_QUEUE_B)
    public void fanoutQueueB(Object o){
        System.out.println("RabbitReceiver ----> fanoutQueueB ----> "+o.toString());
    }


    @RabbitListener(queues = RabbitMQ.FANOUT_QUEUE_C)
    public void fanoutQueueC(Object o){
        System.out.println("RabbitReceiver ----> fanoutQueueC ----> "+o.toString());
    }

}
