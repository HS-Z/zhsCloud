package com.zhs.common.constant;

/**
 * 字典表配置
 */
public enum DictionaryConstant {

    USER_TYPE("用户类型"),

    ROLE_TYPE("角色类型"),

    JOB_TYPE("职业类型"),

    MESSAGE_TYPE("消息类型");


    private String value;

    public String getValue(){
        return value;
    }

    DictionaryConstant(String value) {
        this.value = value;
    }
}
