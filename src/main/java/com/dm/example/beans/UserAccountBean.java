package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;


/**
* UserAccountBean 实体类
* Created by auto generator on Sat May 25 13:15:16 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAccountBean extends BaseEntity{
        /**
        * 账号
        */
        @NotBlank(message = "账号不能为空")
        private String account;
        /**
        * 明文密码
        */
        private String openPwd;
        /**
        * 密码
        */
        @NotBlank(message = "密码不能为空")
        private String password;
        /**
        * 盐值
        */
        private String salt;
        /**
        * 关联用户ID
        */
        private Integer userId;

        /**
         * 最后一次登录IP
         */
        private String lastLoginIp;
        /**
         * 最后一次登录时间
         */
        private Date lastLoginTime;

        /**
         * 关联用户基础类
         */
        private UserBaseBean userBaseBean;

        /**
         * 方便构造对象
         */
        public UserAccountBean(String account,String password){
                this.account = account;
                this.password = password;
        }

}