package com.dm.example.beans;

import com.dm.example.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


/**
* AccountSysRole 实体类
* Created by auto generator on Thu May 30 20:50:32 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRoleBean extends BaseEntity{
        /**
         * 主键id
         */
        private Integer id;
        /**
        * 角色名称
        */
        @NotBlank(message = "角色名称不能为空")
        private String name;
        /**
        * 描述
        */
        private String desc;

        /**
         * 菜单集合
         */
        private List<SysPermissionBean> permissionBeans;
}
