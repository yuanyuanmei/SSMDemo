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
  /**
   * 获取面包屑
   * @param permsBeanList
   * @param paramBean
   * @return
   */
  List<SysPermissionBean> breadCrumbs(List<SysPermissionBean> templist,List<SysPermissionBean> permsBeanList,SysPermissionBean paramBean);

  /**
   * 根据url查找
   * @param url
   * @return
   */
  SysPermissionBean getPermsBeanByUrl(String url);


}
