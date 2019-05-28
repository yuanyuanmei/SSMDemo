package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


/**
* LogLoginBean 实体类
* Created by auto generator on Sat May 25 13:15:16 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogLoginBean extends BaseEntity {
        /**
        * 账号
        */
        private String account;
        /**
        * 登录状态(1.成功,2.失败)
        */
        private Integer successStatus;
        /**
        * 登录IP
        */
        private String loginIp;
        /**
        * 登录时间
        */
        private Date loginTime;
        /**
        * 登录类型(1.帐号登录，2.手机登录)
        */
        private Integer loginType;
        /**
        * 备注
        */
        private String memo;
        /**
        * 密码
        */
        private String password;
        /**
        * 关联用户ID
        */
        private Integer userId;
}