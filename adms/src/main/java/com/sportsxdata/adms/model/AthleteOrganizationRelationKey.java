package com.sportsxdata.adms.model;

public class AthleteOrganizationRelationKey {
    private String athleteId;

    private String organizationId;

    public String getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId == null ? null : athleteId.trim();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }
}