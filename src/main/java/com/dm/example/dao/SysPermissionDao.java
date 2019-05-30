package com.dm.example.dao;

import com.dm.example.base.BaseDao;
import com.dm.example.beans.SysPermissionBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限接口
 */
public interface SysPermissionDao extends BaseDao<SysPermissionBean> {

    /**
     * 根据权限ID查询角色集合
     * @param roleId
     * @return
     */
    List<SysPermissionBean> getPermissionsByRoleId(@Param("roleId") Integer roleId);
}