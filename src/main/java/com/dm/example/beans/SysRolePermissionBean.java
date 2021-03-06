package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
* AccountSysRolePermission 实体类
* Created by auto generator on Thu May 30 20:50:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRolePermissionBean extends BaseEntity{
        /**
        * 角色ID
        */
        private Integer roleId;
        /**
        * 权限ID
        */
        private Integer permissionId;
}