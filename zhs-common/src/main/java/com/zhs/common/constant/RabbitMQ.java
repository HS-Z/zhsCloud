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
    public static final String DIRECT_QUEUE_A = "direct.queue.a";

    public static final String DIRECT_QUEUE_B = "direct.queue.b";



    public static final String TOPIC_QUEUE_A = "topic.queue.a";

    public static final String TOPIC_QUEUE_B = "topic.queue.b";



    public static final String FANOUT_QUEUE_A = "fanout.queue.a";

    public static final String FANOUT_QUEUE_B = "fanout.queue.b";


    /**
     * 定义死信队列相关信息
     */
    public final static String DEAD_EXCHANGE = "dead_exchange";

    public final static String DEAD_QUEUE = "dead_queue";

    public final static String DEAD_ROUTING_KEY = "dead_routing_key";

    /**
     * 死信队列 交换机标识符
     */
    public static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    /**
     * 死信队列交换机绑定键标识符
     */
    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

}
