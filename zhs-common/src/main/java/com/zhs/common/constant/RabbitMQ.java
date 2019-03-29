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

    public static final String DIRECT_QUEUE_C = "direct.queue.c";



    public static final String TOPIC_QUEUE_A = "topic.queue.a";

    public static final String TOPIC_QUEUE_B = "topic.queue.b";

    public static final String TOPIC_QUEUE_C = "topic.queue.c";



    public static final String FANOUT_QUEUE_A = "fanout.queue.a";

    public static final String FANOUT_QUEUE_B = "fanout.queue.b";

    public static final String FANOUT_QUEUE_C = "fanout.queue.c";


}
