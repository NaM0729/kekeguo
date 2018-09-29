package com.sportsxdata.adms.service.impl;

import com.sportsxdata.adms.dao.AthleteMapper;
import com.sportsxdata.adms.dao.CoachMapper;
import com.sportsxdata.adms.dao.SystemUserMapper;
import com.sportsxdata.adms.model.*;
import com.sportsxdata.adms.service.LoginService;
import com.sportsxdata.adms.utils.JWTUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private AthleteMapper athleteMapper;

    @Override
    public DataResult login(String username,String password) {
        if (username == null || "".equals(username) || password == null || "".equals(password)){
            return DataResult.fail("用户名为空!");
        }
        HashMap<String, Object> map = new HashMap<>();
        SystemUser userByUsername = systemUserMapper.selectUserByName(username);
        if (userByUsername == null){
            return DataResult.fail("用户名错误!");
        }
        if (!userByUsername.getPassword().equals(new Md5Hash(password,userByUsername.getSalt()).toString())){
            return DataResult.fail("密码错误!");
        }
        Set<SystemRole> systemRoles = userByUsername.getSystemRoles();
        Iterator<SystemRole> iterator = systemRoles.iterator();
        String token = JWTUtil.sign(username, userByUsername.getPassword());
        SystemRole s;
        while (iterator.hasNext()){
            s = iterator.next();
            if ("7".equals(s.getRoleCode())){
                Coach coach = coachMapper.selectByCode(username);
                map.put("coach",coach);
                map.put("role",s);
                map.put("menu",userByUsername.getSystemMenus());
                map.put("token",token);
                return DataResult.success(map);
            }else if ("8".equals(s.getRoleCode())){
                Athlete athlete = athleteMapper.selectByCode(username);
                map.put("athlete",athlete);
                map.put("role",s);
                map.put("menu",userByUsername.getSystemMenus());
                map.put("token",token);
                return DataResult.success(map);
            }else{
                return DataResult.fail("服务器错误!");
            }
        }
        return DataResult.success(map);

    }
}
