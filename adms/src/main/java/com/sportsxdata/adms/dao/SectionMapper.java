package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.Section;

public interface SectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}