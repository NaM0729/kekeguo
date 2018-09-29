package com.sportsxdata.adms.shiro;

import com.sportsxdata.adms.dao.SystemMenuMapper;
import com.sportsxdata.adms.dao.SystemPermissionMapper;
import com.sportsxdata.adms.dao.SystemRoleMapper;
import com.sportsxdata.adms.dao.SystemUserMapper;
import com.sportsxdata.adms.model.SystemPermission;
import com.sportsxdata.adms.model.SystemRole;
import com.sportsxdata.adms.model.SystemUser;
import com.sportsxdata.adms.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AdmsRealm extends AuthorizingRealm {

    @Autowired
    private SystemUserMapper systemUserMapper;
    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        log.info("准备授权用户:{}",username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SystemUser systemUser = systemUserMapper.selectUserByName(username);
        Set<SystemRole> systemRoles = systemUser.getSystemRoles();
        List<String> role_sb = new ArrayList<>();
        Set<SystemPermission> permissionSet = new HashSet<>();
        for(SystemRole r : systemRoles){
            role_sb.add(r.getRoleName());
            for(SystemPermission p : systemUser.getSystemPermissions()){
                permissionSet.add(p);
            }
        }
        simpleAuthorizationInfo.addRoles(role_sb);
        StringBuffer permission_sb = new StringBuffer();
        for(SystemPermission p : permissionSet){
            permission_sb.append(p.getPermissionCode()).append(",");
        }
        Set<String> permission = new HashSet<>(Arrays.asList(permission_sb.substring(0,permission_sb.length()-1).split(",")));
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        log.info("登录token:{}",token);
        // 解密获得username，用于和数据库进行对比
        String jwt_username = JWTUtil.getUsername(token);
        log.info("获取jwt_username:{}",jwt_username);
        if (jwt_username == null) {
            throw new AuthenticationException("token invalid");
        }
        SystemUser byUsername = systemUserMapper.selectUserByName(jwt_username);
        if (byUsername == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, jwt_username, byUsername.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "adms_realm");
    }
}
