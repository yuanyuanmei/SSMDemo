package com.dm.example.service.impl;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.dao.SysPermissionDao;
import com.dm.example.dto.PageDto;
import com.dm.example.service.SysPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao permsDao;
    @Override
    public PageInfo<SysPermissionBean> pageList(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<SysPermissionBean> list = permsDao.list();
        return new PageInfo<>(list);
    }
}
