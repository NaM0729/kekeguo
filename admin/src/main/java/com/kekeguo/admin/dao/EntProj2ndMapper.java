package com.kekeguo.admin.dao;

import com.kekeguo.admin.model.EntProj2nd;

public interface EntProj2ndMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EntProj2nd record);

    int insertSelective(EntProj2nd record);

    EntProj2nd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntProj2nd record);

    int updateByPrimaryKey(EntProj2nd record);
}