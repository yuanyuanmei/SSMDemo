package com.dm.example.service.impl;

import com.dm.example.base.BaseServiceImpl;
import com.dm.example.beans.UserBaseBean;
import com.dm.example.dao.UserBaseDao;
import com.dm.example.dto.PageDto;
import com.dm.example.service.UserBaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户基础业务实现类
 */
@Service
public class UserBaseServiceImpl extends BaseServiceImpl<UserBaseBean> implements UserBaseService {

    @Autowired
    private UserBaseDao baseDao;

}
