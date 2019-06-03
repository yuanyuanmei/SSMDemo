package com.dm.example.service.impl;

import com.dm.example.beans.SysRoleBean;
import com.dm.example.dao.SysRoleDao;
import com.dm.example.dto.PageDto;
import com.dm.example.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao roleDao;
    @Override
    public PageInfo<SysRoleBean> pageList(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<SysRoleBean> list = roleDao.list();
        return new PageInfo<>(list);
    }

}
