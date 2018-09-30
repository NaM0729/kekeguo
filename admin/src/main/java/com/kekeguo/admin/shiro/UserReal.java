package com.kekeguo.admin.shiro;

import com.kekeguo.admin.model.UserModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyuna
 * @date 2018年09月30日09:56:36
 * 编写用户权限Realm管理
 */
public class UserReal extends AuthorizingRealm{

    private final String token="";

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户信息
        UserModel user = (UserModel) SecurityUtils.getSubject().getPrincipals();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();

        // 获取用户角色
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);

        //获取用户权限
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);

        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        if(StringUtils.isEmpty(username)){
           throw new UnknownAccountException();
        }

        String password = String.valueOf(usernamePasswordToken.getPassword());
        if(StringUtils.isEmpty(password)){
            throw new IncorrectCredentialsException();
        }
// 保存token
        token = token;
        AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
