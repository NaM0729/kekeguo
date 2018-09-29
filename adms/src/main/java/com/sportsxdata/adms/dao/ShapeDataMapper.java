package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.ShapeData;

public interface ShapeDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShapeData record);

    int insertSelective(ShapeData record);

    ShapeData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShapeData record);

    int updateByPrimaryKey(ShapeData record);
}