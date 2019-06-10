package com.dm.example.service.impl;

import com.dm.example.beans.UserAccountBean;
import com.dm.example.beans.UserBaseBean;
import com.dm.example.dao.UserAccountDao;
import com.dm.example.dao.UserBaseDao;
import com.dm.example.service.UserAccountService;
import com.dm.example.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountDao accountDao;

    @Autowired
    private UserBaseDao baseDao;

    @Transactional
    @Override
    public String save(UserAccountBean paramBean){
        int result = 0;
        //根据帐号查找是否存在
        if(Objects.nonNull(accountDao.findByAccount(paramBean.getAccount()))){
            return StringUtils.formatFailJson("账号已存在");
        }
        if(Objects.isNull(paramBean.getId())){
            //生成7位数随机用户名
            String username = StringUtils.getItemID(7);
            UserBaseBean baseBean = new UserBaseBean(username);
            //新增用户基础表
            baseDao.insert(baseBean);
            //获取usr_id
            paramBean.setUserId(baseBean.getId());
            //密码加盐,md5加密
            String salt = StringUtils.getItemID(4);
            paramBean.setSalt(salt);
            paramBean.setOpenPwd(paramBean.getPassword());
            paramBean.setPassword(StringUtils.md5(paramBean.getPassword(),salt));
            //新增用户帐号表
            result = accountDao.insert(paramBean);
        }else{
            result = accountDao.update(paramBean);
        }
        if(result > 0){
            return StringUtils.formatSuccessJson("更新成功",paramBean);
        }
        return StringUtils.formatFailJson("更新失败");
    }


}
