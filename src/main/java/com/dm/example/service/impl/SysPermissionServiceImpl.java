package com.dm.example.service.impl;

import com.dm.example.base.BaseServiceImpl;
import com.dm.example.beans.SysPermissionBean;
import com.dm.example.dao.SysPermissionDao;
import com.dm.example.dto.PageDto;
import com.dm.example.enums.EnumPermsType;
import com.dm.example.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionBean> implements SysPermissionService {

    @Autowired
    private SysPermissionDao permsDao;

    
    @Override
    public PageInfo<SysPermissionBean> pageList(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<SysPermissionBean> list = permsDao.list();
        list.forEach(item -> {
            item.setTypeName(EnumPermsType.keyOf(item.getType()));
        });
        return new PageInfo<>(list);
    }

    @Override
    public List<SysPermissionBean> breadCrumbs(List<SysPermissionBean> templist,List<SysPermissionBean> permsBeanList,SysPermissionBean paramBean){
        if(paramBean!=null){
            templist.add(paramBean);
            List<SysPermissionBean> collect = permsBeanList.stream().filter(item -> item.getId().equals(paramBean.getParentId())).collect(Collectors.toList());
            SysPermissionBean parentBean = collect.size() > 0 ? collect.get(0) : null;
            breadCrumbs(templist,permsBeanList,parentBean);
        }
        Collections.reverse(templist);
        return templist;
    }

    @Override
    public SysPermissionBean getPermsBeanByUrl(String url) {
        return permsDao.getPermsBeanByUrl(url);
    }
}
