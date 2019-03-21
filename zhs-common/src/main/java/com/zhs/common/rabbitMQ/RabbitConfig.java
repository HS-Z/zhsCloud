package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Zhang on 2019/3/20.
 */
@Configuration
public class RabbitConfig {


    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer configure;


    /*
     * ***********************************************************************
     * 队列 Queue
     * ************************************************************************
     */


    @Bean
    public Queue queueMessage(){
        return new Queue(RabbitMQ.QUEUE_MESSAGE);
    }


    @Bean
    public Queue queueMessages(){
        return new Queue(RabbitMQ.QUEUE_MESSAGES);
    }


    /**
     * Fanout 队列测试
     * @return
     */
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }



    /*
     * ***********************************************************************
     * 交换机 Exchange
     * ************************************************************************
     */


    /**
     * topic
     * 最常用
     * @return
     */
    @Bean
    public TopicExchange registerTopicExchange() {
        return new TopicExchange(RabbitMQ.TOPIC_EXCHANGE);
    }

    @Bean
    public Binding registerBinding(Queue queueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("queue.message");
    }

    @Bean
    public Binding registerBindings(Queue queueMessages,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("queue.#");
    }


    /**
     * 广播模式、订阅模式
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQ.FANOUT_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }



    /**
     * 并发消费配置
     * @return
     */
    @Bean("pointTaskContainerFactory")
    public SimpleRabbitListenerContainerFactory pointTaskContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(RabbitMQ.DEFAULT_CONCURRENT);
        factory.setConcurrentConsumers(RabbitMQ.DEFAULT_PREFETCH_COUNT);
        configure.configure(factory, connectionFactory);
        return factory;
    }





}
