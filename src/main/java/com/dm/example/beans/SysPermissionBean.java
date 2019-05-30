package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
* AccountSysPermission 实体类
* Created by auto generator on Thu May 30 20:50:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysPermissionBean extends BaseEntity{
        /**
        * 上级id
        */
        private Integer parentId;
        /**
        * 菜单名称
        */
        private String name;
        /**
        * 菜单级别
        */
        private Integer level;
        /**
        * 权限
        */
        private String permission;
        /**
        * 排序序号
        */
        private Integer sort;
}