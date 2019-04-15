package com.zhs.basic.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Created by Zhang on 2019/3/20.
 * 消息生产者
 */
@Component
public class RabbitSend implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);// 指定 ConfirmCallback
        rabbitTemplate.setReturnCallback(this);// 指定 ReturnCallback
    }


    public void send(String a, Object o){

        CorrelationData correlationData1 = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData2 = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData3 = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData4 = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData5 = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData6 = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData7 = new CorrelationData(UUID.randomUUID().toString());

//        System.out.println("correlationData1---->"+ correlationData1);
//        System.out.println("correlationData2---->"+ correlationData2);
//        System.out.println("correlationData3---->"+ correlationData3);
//        System.out.println("correlationData4---->"+ correlationData4);
//        System.out.println("correlationData5---->"+ correlationData5);
//        System.out.println("correlationData6---->"+ correlationData6);
//        System.out.println("correlationData7---->"+ correlationData7);

//        this.rabbitTemplate.convertAndSend(a,o);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.DIRECT_EXCHANGE,RabbitMQ.DIRECT_QUEUE_A,"DIRECT_QUEUE_A------1111",correlationData1);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.DIRECT_EXCHANGE,RabbitMQ.DIRECT_QUEUE_B,"DIRECT_QUEUE_B------2222",correlationData2);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.DIRECT_EXCHANGE,RabbitMQ.DIRECT_QUEUE_C,"DIRECT_QUEUE_C------3333",correlationData3);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_A,"TOPIC_QUEUE_A------4444",correlationData4);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_B,"TOPIC_QUEUE_B------5555",correlationData5);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_C,"TOPIC_QUEUE_C------6666",correlationData6);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,"lklkll","TOPIC_QUEUE_C------6666",correlationData6);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.FANOUT_EXCHANGE,"","Fanout--------77777",correlationData7);  //广播模式

//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,RabbitMQ.TOPIC_QUEUE_A,"TOPIC_QUEUE_A------4444",correlationData4);
        this.rabbitTemplate.convertAndSend("aaaaa",RabbitMQ.TOPIC_QUEUE_A,"dfdferresaaaa",correlationData3);
        System.out.println("correlationData3-------->"+correlationData3);
        System.out.println("correlationData4-------->"+correlationData4);
        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,"uyyydf","yyudfdfdfdf",correlationData4);


    }


    /**
     * 用于监听Server端给我们返回的确认请求,消息到了exchange，ack 就返回true
     * 该方法是确认消息是否成功发送到交换机
     * @param correlationData  hh
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
        System.out.println("confirm模式---" + correlationData);
        if (ack) {
            System.out.println("路由到交换机成功:" + correlationData);
        } else {
            System.out.println("路由到交换机失败:" + correlationData);
        }
    }


    /**
     * 监听对不可达的消息进行后续处理;
     * 不可达消息：指定的路由key路由不到。
     * 该方法是确定消息是否成功路由到队列
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("==============returnedMessage 开始 ==============");
        System.out.println(replyCode);
        System.out.println(replyText);
        System.out.println(exchange);
        System.out.println(routingKey);
        System.out.println(message.getMessageProperties());
        System.out.println("==============returnedMessage 结束 ==============");

    }

}
