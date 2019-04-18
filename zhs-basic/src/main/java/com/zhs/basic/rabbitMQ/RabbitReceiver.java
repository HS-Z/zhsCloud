package com.zhs.basic.rabbitMQ;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

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


    @RabbitListener(queues = RabbitMQ.TOPIC_QUEUE_A)
    public void topicQueueA(Channel channel, Message message){
        System.out.println("RabbitReceiver ----> topicQueueA ----> ");

        try {
            //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息，如果为true就表示连续取得多条消息才发会确认
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //ack返回false，并重新回到队列，api里面解释得很清楚
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

            //重新发送消息到队尾
            //当消息回滚到消息队列时，这条消息不会回到队列尾部，而是仍是在队列头部，这时消费者会立马又接收到这条消息进行处理，接着抛出异常，进行回滚，如此反复进行
//            channel.basicPublish(message.getMessageProperties().getReceivedExchange(), message.getMessageProperties().getReceivedRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN, JSON.toJSONBytes(new Object()));
            //拒绝消息，requeue=true，表示将消息重新放入到队列中，requeue=false表示直接从队列中删除，此时和basicAck(long deliveryTag, false)的效果一样
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*@RabbitListener(queues = RabbitMQ.TOPIC_QUEUE_B)
    public void topicQueueC(Channel channel, Message message){
        System.out.println("RabbitReceiver ----> topicQueueB ----> ");

        try {
            //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息，如果为true就表示连续取得多条消息才发会确认
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}
