package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
* UserBaseBean 实体类
* Created by auto generator on Sat May 25 13:15:16 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBaseBean extends BaseEntity{
        /**
        * 邮箱
        */
        private String email;
        /**
        * 账户头像
        */
        private String headerUrl;
        /**
        * 手机号
        */
        private String phone;
        /**
        * 用户类型(1.超级管理员,2.普通用户)
        */
        private Integer type;
        /**
        * 用户名
        */
        private String username;

        public UserBaseBean(String username,Integer type){
                super();
                this.username = username;
                this.type = type;
        }
}