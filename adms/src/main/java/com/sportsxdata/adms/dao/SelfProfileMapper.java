package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.SelfProfile;

public interface SelfProfileMapper {
    int deleteByPrimaryKey(String id);

    int insert(SelfProfile record);

    int insertSelective(SelfProfile record);

    SelfProfile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SelfProfile record);

    int updateByPrimaryKey(SelfProfile record);
}