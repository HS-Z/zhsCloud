package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Zhang on 2019/3/20.
 * 消息生产者
 */
@Component
public class RabbitSend implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {


    private RabbitTemplate rabbitTemplate;


    @Autowired
    public RabbitSend(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }


    public void send(String a, Object o){

//        this.rabbitTemplate.convertAndSend(a,o);
        this.rabbitTemplate.convertAndSend(RabbitMQ.DIRECT_EXCHANGE,RabbitMQ.DIRECT_QUEUE_A,"1111");
        this.rabbitTemplate.convertAndSend(RabbitMQ.DIRECT_EXCHANGE,RabbitMQ.DIRECT_QUEUE_B,"2222");
        this.rabbitTemplate.convertAndSend(RabbitMQ.DIRECT_EXCHANGE,RabbitMQ.DIRECT_QUEUE_C,"3333");
        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_A,"4444");
        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_B,"5555");
        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_C,"6666");
        this.rabbitTemplate.convertAndSend(RabbitMQ.FANOUT_EXCHANGE,"","Fanout");  //广播模式

    }


    public void send2(){
        for (int i = 0; i < 1000; i++) {
            String context = "hi, i am messages " + i;
            System.out.println("Sender : " + context);
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            System.out.println("callbackSender UUID: " + correlationData.getId());
            this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context, correlationData);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 回调
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean b, @Nullable String s) {
        if (b) {
            System.out.println("消息发送成功:" + correlationData);
        } else {
            System.out.println("消息发送失败:" + s);
        }
    }


    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println(message.getMessageProperties() + " 发送失败");
    }
}
