package com.dm.example.service.impl;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.SysRoleBean;
import com.dm.example.beans.UserBaseBean;
import com.dm.example.dao.UserBaseDao;
import com.dm.example.service.SysPermissionService;
import com.dm.example.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private UserBaseDao baseDao;
}
