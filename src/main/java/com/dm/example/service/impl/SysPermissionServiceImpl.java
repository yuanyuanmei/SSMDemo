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
    /**
     * 根据用户ID查询菜单
     * @param userId
     * @return
     */
    @Override
    public List<SysPermissionBean> getNavByUserId(Long userId) {
        UserBaseBean baseBean = baseDao.selectByPrimaryKey(userId);
        List<SysPermissionBean> templist = new ArrayList<>();
        for(int i =0;baseBean.getRoleBeans()!=null && i<baseBean.getRoleBeans().size();i++){
            SysRoleBean roleBean = baseBean.getRoleBeans().get(i);
            templist.addAll(roleBean.getPermissionBeans());
        }
        templist = TreeUtils.convertToTree(templist,0);
        return templist;
    }
}
