package com.dm.example.shiro;

import com.dm.example.beans.UserAccountBean;
import com.dm.example.dao.UserAccountDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * shiro数据源
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserAccountDao userAccountDao;
    /**
     * 赋予权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        //根据帐号查找
        UserAccountBean bean = userAccountDao.findByAccount(account);
        if(Objects.nonNull(bean)){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(bean.getAccount(),bean.getPassword(),getName());
            return authenticationInfo;
        }
        return null;
    }






}
