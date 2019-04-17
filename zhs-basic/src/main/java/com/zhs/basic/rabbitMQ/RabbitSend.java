package com.zhs.basic.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

        MessageProperties messageProperties=new MessageProperties();

        messageProperties.setContentType(MessageProperties.DEFAULT_CONTENT_TYPE);
        messageProperties.setDeliveryMode(MessageProperties.DEFAULT_DELIVERY_MODE);//持久化设置
//        messageProperties.setExpiration("2019-12-15 23:23:23");//设置到期时间

        Message message = new Message("hello".getBytes(),messageProperties);

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
//        this.rabbitTemplate.convertAndSend("aaaaa",RabbitMQ.TOPIC_QUEUE_A,"dfdferresaaaa",correlationData3);
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE,"uyyydf","yyudfdfdfdf",correlationData4);

        //exchange，queue 都正确，confirm 被回调，ack=true
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE, RabbitMQ.TOPIC_QUEUE_A, message);
        //exchange错误，queue 正确，confirm 被回调，ack=false，cause=channel error;
//        this.rabbitTemplate.convertAndSend("kitzhs", RabbitMQ.TOPIC_QUEUE_A, message);
        //exchange正确，queue 错误，confirm 被回调，ack=true；returnedMessage 被回调，replyText=NO_ROUTE
//        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE, "kitzhs", message);
        //exchange，queue 都错误，confirm 被回调，ack=false，cause=channel error;
        this.rabbitTemplate.convertAndSend(RabbitMQ.TOPIC_EXCHANGE, RabbitMQ.TOPIC_QUEUE_A, message);


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
            System.out.println("路由到交换机成功:" + correlationData + "----------ack:" + ack + "-----------cause:"+cause);
        } else {
            System.out.println("路由到交换机失败:" + correlationData + "----------ack:" + ack + "-----------cause:"+cause);
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
