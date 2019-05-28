package com.dm.example.dao;

import com.dm.example.base.BaseDao;
import com.dm.example.beans.UserAccountBean;

public interface UserAccountDao extends BaseDao<UserAccountBean> {

    /**
     * 根据帐号查询
     */
    UserAccountBean findByAccount(String account);

}