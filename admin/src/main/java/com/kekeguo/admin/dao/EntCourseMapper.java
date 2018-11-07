package com.kekeguo.admin.dao;

import com.kekeguo.admin.model.EntCourse;

public interface EntCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EntCourse record);

    int insertSelective(EntCourse record);

    EntCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntCourse record);

    int updateByPrimaryKey(EntCourse record);
}