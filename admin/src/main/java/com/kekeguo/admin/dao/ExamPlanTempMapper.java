package com.kekeguo.admin.dao;

import com.kekeguo.admin.model.ExamPlanTemp;

public interface ExamPlanTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPlanTemp record);

    int insertSelective(ExamPlanTemp record);

    ExamPlanTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPlanTemp record);

    int updateByPrimaryKey(ExamPlanTemp record);
}