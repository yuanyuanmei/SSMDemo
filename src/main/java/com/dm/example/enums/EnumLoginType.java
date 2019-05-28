package com.dm.example.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 登录类型枚举
 */
public enum EnumLoginType {

    ACCOUNT_TYPE(1,"普通账号"), PHONE_TYPE(2,"手机号"), MAIL_TYPE(3,"邮箱");

    //枚举的变量类型为final 防止被修改
    private final Integer key;
    private final String value;

    private EnumLoginType(Integer key,String value){
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    //枚举的变量必须为static静态
    public static List<EnumLoginType> list = Arrays.asList(values());

}
