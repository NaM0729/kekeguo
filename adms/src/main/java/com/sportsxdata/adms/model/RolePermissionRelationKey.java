package com.sportsxdata.adms.model;

public class RolePermissionRelationKey {
    private String systemRoleId;

    private String systemPermissionId;

    public String getSystemRoleId() {
        return systemRoleId;
    }

    public void setSystemRoleId(String systemRoleId) {
        this.systemRoleId = systemRoleId == null ? null : systemRoleId.trim();
    }

    public String getSystemPermissionId() {
        return systemPermissionId;
    }

    public void setSystemPermissionId(String systemPermissionId) {
        this.systemPermissionId = systemPermissionId == null ? null : systemPermissionId.trim();
    }
}