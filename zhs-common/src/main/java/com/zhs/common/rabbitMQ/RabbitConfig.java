package com.zhs.common.rabbitMQ;

import com.zhs.common.constant.RabbitMQ;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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


    @Bean(name = "helloQueue")
    public Queue helloQueue(){
        return new Queue(RabbitMQ.TEST);
    }


    @Bean(name = "emailQueue")
    public Queue emailQueue(){
        return new Queue(RabbitMQ.EMAIL);
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


    @Bean
    public TopicExchange registerTopicExchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding registerBinding(Queue helloQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(helloQueue).to(topicExchange).with("zfjk_queue.#");
    }


    @Bean
    public Binding registerBindings(Queue emailQueue,TopicExchange topicExchange) {
        return BindingBuilder.bind(emailQueue).to(topicExchange).with("zfjk_queues.#");
    }


}
