package com.zhs.common.constant;

/**
 * 消息队列
 */
public class RabbitMQ {


    /**
     * 测试内容
     */
    public static final String TEST = "test";


    /**
     * 邮件
     */
    public static final String EMAIL = "email";


    /**
     * 短信
     */
    public static final String SMS = "sms";


    /**
     * 消息
     */
    public static final String MESSAGE = "message";


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
