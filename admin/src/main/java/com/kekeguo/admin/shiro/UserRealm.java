package com.kekeguo.admin.shiro;

import com.kekeguo.admin.data.SessionData;
import com.kekeguo.admin.model.UserModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
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

    private static Map<String, UserModel> userMap = new HashMap<String, UserModel>();

    static {
        //使用Map模拟数据库获取User表信息
        userMap.put("administrator", new UserModel("zhang", "123"));
        userMap.put("jack", new UserModel("jack", "123"));
        userMap.put("jean", new UserModel("jean", "123"));
    }


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户信息
        UserModel user = (UserModel) SecurityUtils.getSubject().getPrincipals();

        // 从数据库中查找用户的权限列表
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if ("zhang".equals(user.username)) {
            // 获取用户角色
            Set<String> roleSet = new HashSet<String>();
            roleSet.add("admin");
            info.setRoles(roleSet);

            //获取用户权限
            Set<String> permissionSet = new HashSet<String>();
            permissionSet.add("user:update");
            info.setStringPermissions(permissionSet);
        }

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
        // 数据库中比对用户是否存在

        if (StringUtils.isEmpty(username)) {
            throw new UnknownAccountException();
        }
        String password = String.valueOf(usernamePasswordToken.getPassword());
        if (StringUtils.isEmpty(password)) {
            throw new IncorrectCredentialsException();
        }

        AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
