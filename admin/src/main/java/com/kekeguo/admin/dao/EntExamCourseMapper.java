package com.kekeguo.admin.dao;

import com.kekeguo.admin.model.EntExamCourse;

public interface EntExamCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EntExamCourse record);

    int insertSelective(EntExamCourse record);

    EntExamCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntExamCourse record);

    int updateByPrimaryKey(EntExamCourse record);
}