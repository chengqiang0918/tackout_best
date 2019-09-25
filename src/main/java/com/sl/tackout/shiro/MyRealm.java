package com.sl.tackout.shiro;

import com.sl.tackout.pojo.PermissionTable;
import com.sl.tackout.pojo.UserTable;
import com.sl.tackout.service.BusinessService;
import com.sl.tackout.service.PermissionService;
import com.sl.tackout.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by happy on 2019/8/21.
 */

public class MyRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private BusinessService businessService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        Object principal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String userName = (String) principal;
            List<PermissionTable> allPermissionByUna = permissionService.findAllPermissionByUna(userName);
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //权限去重
            Set<String> pers = new HashSet<>();
            for (PermissionTable p:allPermissionByUna) {
                String pmenuUrl = p.getPmenuUrl();
                pers.add(pmenuUrl);

            }
            simpleAuthorizationInfo.setStringPermissions(pers);
            return simpleAuthorizationInfo;
        }

        return null;
    }
    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1,获取身份信息（用户名）
        Object principal = authenticationToken.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String loginName = (String)principal;
            UserTable userByLoginName = userService.findUserByLoginName(loginName);
            if (userByLoginName!=null){
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, userByLoginName.getUserPwd(), getName());
                return authenticationInfo;
            }
        }
        return null;
    }
}
