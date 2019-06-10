package com.dm.example.util;

import com.alibaba.fastjson.JSONObject;
import com.dm.example.constants.ApiCodeConsts;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.Random;

public class StringUtils {


    public static final String MD5 = "MD5";

    //加密次数
    public static final Integer encryNum = 1024;

    /**
     * 生成随机数当作getItemID
     * n ： 需要的长度
     * @return
     */
    public static String getItemID( int n )
    {
        String val = "";
        Random random = new Random();
        for ( int i = 0; i < n; i++ )
        {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) ( nextInt + random.nextInt( 26 ) );
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
                val += String.valueOf( random.nextInt( 10 ) );
            }
        }
        return val;
    }

    public static String md5(String code,String salt){
        //加密方式、密码、盐值、加密次数
        return String.valueOf(new SimpleHash(MD5, code, ByteSource.Util.bytes(salt), encryNum));
    }

    /**
     * 自定义JSON数据
     */
    public static String formatCommonJson(int code,String msg,Object info){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        if(Objects.nonNull(info)){
            jsonObject.put("info",info);
        }
        return jsonObject.toJSONString();
    }

    public static String formatCommonJson(int code,String msg){
        return StringUtils.formatCommonJson(code,msg,null);
    }

    /**
     * 成功JSON数据
     */
    public static String formatSuccessJson(String msg,Object info){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ApiCodeConsts.success);
        jsonObject.put("msg",msg);
        if(Objects.nonNull(info)){
            jsonObject.put("info",info);
        }
        return jsonObject.toJSONString();
    }

    public static String formatSuccessJson(String msg){
        return StringUtils.formatSuccessJson(msg,null);
    }

    /**
     * 失败JSON数据
     */
    public static String formatFailJson(String msg,Object info){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ApiCodeConsts.fail);
        jsonObject.put("msg",msg);
        if(Objects.nonNull(info)){
            jsonObject.put("info",info);
        }
        return jsonObject.toJSONString();
    }

    public static String formatFailJson(String msg){
        return StringUtils.formatFailJson(msg,null);
    }

}
