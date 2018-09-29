package com.sportsxdata.adms.model;

public class ThemeActionRelationKey {
    private String admsThemeId;

    private String admsActionId;

    public String getAdmsThemeId() {
        return admsThemeId;
    }

    public void setAdmsThemeId(String admsThemeId) {
        this.admsThemeId = admsThemeId == null ? null : admsThemeId.trim();
    }

    public String getAdmsActionId() {
        return admsActionId;
    }

    public void setAdmsActionId(String admsActionId) {
        this.admsActionId = admsActionId == null ? null : admsActionId.trim();
    }
}