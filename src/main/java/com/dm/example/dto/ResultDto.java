package com.dm.example.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 结果工具类
 */
@Data
@ToString
public class ResultDto {

    private Integer code;

    private String message;

    private Object o;


    private ResultDto(Integer code, String message, Object o){
        this.code = code;
        this.message =message;
        this.o = o;
    }

    private ResultDto(Integer code, String message){
        this.code = code;
        this.message =message;
    }

    //成功方法
    public static ResultDto success(String message, Object o){
        return new ResultDto(200,message,o);
    }

    //失败方法
    public static ResultDto fail(String message){
        return new ResultDto(400,message);
    }
}
