package com.sportsxdata.adms.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class SystemUser {
    private String id;

    private String username;

    private String password;

    private String salt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    private String admsSystemUsercol;

    Set<SystemRole> systemRoles;

    TreeSet<SystemMenu> systemMenus;

    Set<SystemPermission> systemPermissions;

    public TreeSet<SystemMenu> getSystemMenus() {
        return systemMenus;
    }

    public void setSystemMenus(TreeSet<SystemMenu> systemMenus) {
        this.systemMenus = systemMenus;
    }

    public Set<SystemPermission> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(Set<SystemPermission> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }

    public Set<SystemRole> getSystemRoles() {
        return systemRoles;
    }

    public void setSystemRoles(Set<SystemRole> systemRoles) {
        this.systemRoles = systemRoles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
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

    public String getAdmsSystemUsercol() {
        return admsSystemUsercol;
    }

    public void setAdmsSystemUsercol(String admsSystemUsercol) {
        this.admsSystemUsercol = admsSystemUsercol == null ? null : admsSystemUsercol.trim();
    }
}