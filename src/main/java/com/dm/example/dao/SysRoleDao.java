package com.dm.example.dao;

import com.dm.example.base.BaseDao;
import com.dm.example.beans.SysRoleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleDao extends BaseDao<SysRoleBean> {

    /**
     * 根据用户ID查询角色集合
     * @param userId
     * @return
     */
    List<SysRoleDao> getRolesByUserId(@Param("userId") Long userId);


}