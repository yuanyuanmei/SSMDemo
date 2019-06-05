package com.dm.example.service;

import com.dm.example.base.BaseService;
import com.dm.example.beans.SysPermissionBean;
import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 权限业务处理
 */
public interface SysPermissionService extends BaseService<SysPermissionBean> {
  List<SysPermissionBean> breadCrumbs(List<SysPermissionBean> permsBeanList,SysPermissionBean paramBean);
}
