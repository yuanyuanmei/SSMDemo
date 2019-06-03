package com.dm.example.service;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 权限业务处理
 */
public interface SysPermissionService {
    /**
     * 分页查询
     */
    PageInfo<SysPermissionBean> pageList(PageDto pageDto);
}
