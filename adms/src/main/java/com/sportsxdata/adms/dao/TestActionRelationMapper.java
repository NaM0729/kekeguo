package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.TestActionRelation;

public interface TestActionRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(TestActionRelation record);

    int insertSelective(TestActionRelation record);

    TestActionRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestActionRelation record);

    int updateByPrimaryKey(TestActionRelation record);
}