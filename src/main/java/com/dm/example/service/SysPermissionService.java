package com.dm.example.service;

import com.dm.example.beans.SysPermissionBean;

import java.util.List;

/**
 * 权限菜单接口
 */
public interface SysPermissionService {

    /**
     * 根据用户ID查询菜单
     * @param userId
     * @return
     */
    List<SysPermissionBean> getNavByUserId(Long userId);
}
