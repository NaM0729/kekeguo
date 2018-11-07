package com.kekeguo.admin.dao;

import com.kekeguo.admin.model.ExamSessionPlan;

import java.util.List;

public interface ExamSessionPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamSessionPlan record);

    int insertSelective(ExamSessionPlan record);

    ExamSessionPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamSessionPlan record);

    int updateByPrimaryKey(ExamSessionPlan record);

    List<ExamSessionPlan> getList ();
}