package com.dm.example.shiro;

import com.dm.example.beans.SysPermissionBean;
import com.dm.example.beans.SysRoleBean;
import com.dm.example.beans.UserAccountBean;
import com.dm.example.dao.UserAccountDao;
import com.dm.example.util.UserUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
        String account = (String) principalCollection.getPrimaryPrincipal();
        //根据帐号查找
        UserAccountBean bean = userAccountDao.findByAccount(account);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取角色名称集合
        List<SysRoleBean> roles = bean.getUserBaseBean().getRoleBeans();
        Set<String> roleNames = roles.stream().map(SysRoleBean::getName).collect(Collectors.toSet());
        authorizationInfo.setRoles(roleNames);
        //获取权限名称集合
        List<SysPermissionBean> permissionList = bean.getUserBaseBean().getPermissionBeans();
        Set<String> permissions = permissionList.stream().filter(p -> !Objects.isNull(p.getPermission()))
                .map(SysPermissionBean::getPermission).collect(Collectors.toSet());
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
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
            UserUtils.setUserSession(bean.getUserBaseBean());
            UserUtils.setNavSession(bean.getUserBaseBean().getPermissionBeans());
            return authenticationInfo;
        }
        return null;
    }






}
