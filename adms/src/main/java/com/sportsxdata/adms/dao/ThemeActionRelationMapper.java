package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.ThemeActionRelationKey;

public interface ThemeActionRelationMapper {
    int deleteByPrimaryKey(ThemeActionRelationKey key);

    int insert(ThemeActionRelationKey record);

    int insertSelective(ThemeActionRelationKey record);
}