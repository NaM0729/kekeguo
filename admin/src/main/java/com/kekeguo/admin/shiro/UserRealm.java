package com.kekeguo.admin.shiro;

import com.kekeguo.admin.model.UserModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
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
@Component
public class UserRealm extends AuthorizingRealm {

    private static Map<String, String> userMap = new HashMap<String, String>();

    static {
        //使用Map模拟数据库获取User表信息
        userMap.put("zhang","123");
        userMap.put("li","123");
        userMap.put("zhao","123");
        userMap.put("gao","123");
    }


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户信息
//        String user = SecurityUtils.getSubject().getPrincipals();
        String username = (String) principals.getPrimaryPrincipal();

        // 从数据库中查找用户的权限列表
        Set<String> roles = getRolesByUserName(username);
        Set<String> permissions = getPermissionsByUserName(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    private Set<String> getPermissionsByUserName(String username) {
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("user:update");
        return permissionSet;
    }

    private Set<String> getRolesByUserName(String username) {
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("admin");
        return roleSet;
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

        // 数据库中比对用户是否存在
        String password = checkPasswordByUserName(username);
        if (StringUtils.isEmpty(password)) {
            throw new IncorrectCredentialsException();
        }

        AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }

    private String checkPasswordByUserName(String username) {
        return userMap.get(username);
    }
}
