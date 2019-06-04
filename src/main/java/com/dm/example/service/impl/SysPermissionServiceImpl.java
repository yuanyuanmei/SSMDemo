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
import java.util.List;

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
}
