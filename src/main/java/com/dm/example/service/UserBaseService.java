package com.dm.example.service;

import com.dm.example.beans.UserBaseBean;
import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageInfo;

/**
 * 用户基础业务类
 */
public interface UserBaseService {

    /**
     * 分页查询用户列表
     */
    PageInfo<UserBaseBean> pageList(PageDto pageDto);

}
