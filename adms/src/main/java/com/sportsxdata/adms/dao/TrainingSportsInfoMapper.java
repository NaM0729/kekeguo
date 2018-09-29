package com.sportsxdata.adms.dao;

import com.sportsxdata.adms.model.TrainingSportsInfo;

public interface TrainingSportsInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TrainingSportsInfo record);

    int insertSelective(TrainingSportsInfo record);

    TrainingSportsInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TrainingSportsInfo record);

    int updateByPrimaryKey(TrainingSportsInfo record);
}