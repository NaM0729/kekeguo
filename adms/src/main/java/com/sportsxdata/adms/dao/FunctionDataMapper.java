package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.FunctionData;

public interface FunctionDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(FunctionData record);

    int insertSelective(FunctionData record);

    FunctionData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FunctionData record);

    int updateByPrimaryKey(FunctionData record);
}