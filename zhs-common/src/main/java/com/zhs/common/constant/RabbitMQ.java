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
     * 消息广播的模式，不管路由键或者是路由模式，会把消息发给绑定给它的全部队列，如果配置了routingKey会被忽略。
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
    public static final String DIRECT_QUEUE_A = "direct_queue_a";

    public static final String DIRECT_QUEUE_B = "direct_queue_b";



    public static final String TOPIC_QUEUE_A = "topic_queue_a";

    public static final String TOPIC_QUEUE_B = "topic_queue_b";



    public static final String FANOUT_QUEUE_A = "fanout_queue_a";

    public static final String FANOUT_QUEUE_B = "fanout_queue_b";


    /*
     * ************************************************************************
     * routingKey
     * ************************************************************************
     */

    public static final String DIRECT_ROUTINGKEY_A = "direct.routingKey.a";

    public static final String DIRECT_ROUTINGKEY_B = "direct.routingKey.b";

    public static final String TOPIC_ROUTINGKEY_A = "topic.routingKey.a";

    public static final String TOPIC_ROUTINGKEY_B = "topic.routingKey.b";



    /**
     * 定义死信队列相关信息
     */
    public final static String DEAD_EXCHANGE = "dead_exchange";

    public final static String DEAD_QUEUE = "dead_queue";

    public final static String DEAD_ROUTING_KEY = "dead.routingKey";

}
