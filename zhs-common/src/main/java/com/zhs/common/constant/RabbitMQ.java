package com.zhs.common.constant;

/**
 * 消息队列
 */
public class RabbitMQ {


    /*
     * ************************************************************************
     * 交换机 Exchange
     * ************************************************************************
     */

    /**
     * 根据key全文匹配
     */
    public static final String DIRECT_EXCHANGE = "direct_exchange";

    /**
     * 按规则转发消息
     */
    public static final String TOPIC_EXCHANGE = "topic_exchange";


    /**
     * 消息广播的模式，不管路由键或者是路由模式，会把消息发给绑定给它的全部队列，如果配置了routing_key会被忽略。
     */
    public static final String FANOUT_EXCHANGE = "fanout_exchange";



    /*
     * ************************************************************************
     * 队列 Queue
     * ************************************************************************
     */


    /**
     * 测试内容
     */
    public static final String QUEUE_MESSAGE = "queue.message";


    public static final String QUEUE_MESSAGES = "queue.messages";



    /*
     * ************************************************************************
     * ************************************************************************
     */


    /**
     * 消费者数量，默认10
     */
    public static final int DEFAULT_CONCURRENT = 10;


    /**
     * 每个消费者获取最大投递数量 默认50
     */
    public static final int DEFAULT_PREFETCH_COUNT = 50;


}
