package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Set;

public class SystemRole {
    private String id;

    private String roleName;

    private String roleCode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

//    Set<SystemPermission> systemPermissions;

//    Set<SystemMenu> systemMenus;

//    public Set<SystemMenu> getSystemMenus() {
//        return systemMenus;
//    }

//    public void setSystemMenus(Set<SystemMenu> systemMenus) {
//        this.systemMenus = systemMenus;
//    }

//    public Set<SystemPermission> getSystemPermissions() {
//        return systemPermissions;
//    }
//
//    public void setSystemPermissions(Set<SystemPermission> systemPermissions) {
//        this.systemPermissions = systemPermissions;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}