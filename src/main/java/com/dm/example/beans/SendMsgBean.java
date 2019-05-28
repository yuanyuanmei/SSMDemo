package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


/**
* SendMsgBean 实体类
* Created by auto generator on Sat May 25 13:15:16 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SendMsgBean extends BaseEntity{
        /**
        * 发送对象(手机号码或邮箱)
        */
        private String account;
        /**
        * 验证码
        */
        private String code;
        /**
        * 过期时间
        */
        private Date expiresTime;
        /**
        * 发送状态(1.成功2.失败)
        */
        private Integer successStatus;
        /**
        * 发送信息
        */
        private String msg;
        /**
        * 对象类型
        */
        private Integer type;
        private Integer userId;
}