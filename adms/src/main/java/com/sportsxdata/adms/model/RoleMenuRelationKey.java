package com.sportsxdata.adms.model;

public class RoleMenuRelationKey {
    private String admsSystemRoleId;

    private String admsSystemMenuId;

    public String getAdmsSystemRoleId() {
        return admsSystemRoleId;
    }

    public void setAdmsSystemRoleId(String admsSystemRoleId) {
        this.admsSystemRoleId = admsSystemRoleId == null ? null : admsSystemRoleId.trim();
    }

    public String getAdmsSystemMenuId() {
        return admsSystemMenuId;
    }

    public void setAdmsSystemMenuId(String admsSystemMenuId) {
        this.admsSystemMenuId = admsSystemMenuId == null ? null : admsSystemMenuId.trim();
    }
}