package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


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
         * 主键id
         */
        private Long id;
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

        /**
         * 昵称
         */
        private String nickname;

        /**
         * 角色列表
         */
        private List<SysRoleBean> roleBeans;

        /**
         * 权限列表
         */
        private List<SysPermissionBean> permissionBeans = new ArrayList<>();

        public UserBaseBean(String username){
            super();
            this.username = username;
        }

        public List<SysPermissionBean> getPermissionBeans() {
            for(int i =0;roleBeans!=null && i<roleBeans.size();i++){
                SysRoleBean roleBean = roleBeans.get(i);
                    permissionBeans.addAll(roleBean.getPermissionBeans());
                }
                return permissionBeans;
        }
}