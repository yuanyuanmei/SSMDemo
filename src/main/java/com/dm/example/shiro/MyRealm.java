package com.dm.example.shiro;

import com.dm.example.beans.UserAccountBean;
import com.dm.example.dao.UserAccountDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
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
        if(Objects.isNull(bean)){
            throw new UnknownAccountException();
        }
        if(Objects.nonNull(bean)){
            ByteSource credentialsSalt = ByteSource.Util.bytes(bean.getSalt());
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(bean.getAccount(),bean.getPassword(),credentialsSalt,getName());
            return authenticationInfo;
        }
        return null;
    }






}
