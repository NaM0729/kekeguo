package com.sportsxdata.adms.model;

public class UserRoleRelationKey {
    private String systemUserId;

    private String systemRoleId;

    public String getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(String systemUserId) {
        this.systemUserId = systemUserId == null ? null : systemUserId.trim();
    }

    public String getSystemRoleId() {
        return systemRoleId;
    }

    public void setSystemRoleId(String systemRoleId) {
        this.systemRoleId = systemRoleId == null ? null : systemRoleId.trim();
    }
}