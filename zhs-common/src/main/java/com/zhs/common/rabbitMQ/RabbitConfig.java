package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Zhang on 2019/3/20.
 */
@Configuration
public class RabbitConfig {


    /*
     * ***********************************************************************
     * Direct 交换机队列
     * ************************************************************************
     */

    @Bean
    public Queue directQueueA(){
        return new Queue(RabbitMQ.DIRECT_QUEUE_A,true);   //开启队列持久化（其实默认已开启）
    }

    @Bean
    public Queue directQueueB(){
        return new Queue(RabbitMQ.DIRECT_QUEUE_B,true);   //开启队列持久化（其实默认已开启）
    }



    /*
     * ***********************************************************************
     * Topic 交换机队列
     * ************************************************************************
     */

    @Bean
    public Queue topicQueueA(){
        return new Queue(RabbitMQ.TOPIC_QUEUE_A,true);   //开启队列持久化（其实默认已开启）
    }

    @Bean
    public Queue topicQueueB(){
        return new Queue(RabbitMQ.TOPIC_QUEUE_B,true);   //开启队列持久化（其实默认已开启）
    }



    /*
     * ***********************************************************************
     * Fanout 交换机队列
     * ************************************************************************
     */

    @Bean
    public Queue fanoutQueueA(){
        return new Queue(RabbitMQ.FANOUT_QUEUE_A,true);   //开启队列持久化（其实默认已开启）
    }

    @Bean
    public Queue fanoutQueueB(){
        return new Queue(RabbitMQ.FANOUT_QUEUE_B,true);   //开启队列持久化（其实默认已开启）
    }



    /*
     * ***********************************************************************
     * Direct 交换机
     * ************************************************************************
     */

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMQ.DIRECT_EXCHANGE,true,false);   //开启交换机持久化（其实默认已开启）
    }

    @Bean
    public Binding bindingDirectExchangeA(Queue directQueueA, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueA).to(directExchange).with(RabbitMQ.DIRECT_QUEUE_A);
    }

    @Bean
    public Binding bindingDirectExchangeB(Queue directQueueB, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with(RabbitMQ.DIRECT_QUEUE_B);
    }



    /*
     * ***********************************************************************
     * Topic 交换机（最常用）
     * ************************************************************************
     */

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQ.TOPIC_EXCHANGE,true,false);  //开启交换机持久化（其实默认已开启）
    }

    @Bean
    public Binding bindingTopicExchangeA(Queue topicQueueA, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with(RabbitMQ.TOPIC_QUEUE_A);
    }


    @Bean
    public Binding bindingTopicExchangeB(Queue topicQueueB,TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with("topic.queue.#");  //*表示一个词，#表示零个或多个词
    }



    /*
     * ***********************************************************************
     * Fanout 交换机（广播模式、订阅模式）
     * ************************************************************************
     */

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQ.FANOUT_EXCHANGE,true,false);  //开启交换机持久化（其实默认已开启）
    }

    @Bean
    public Binding bindingFanoutExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }



    /**
     * 解决两次ack的问题
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

}
