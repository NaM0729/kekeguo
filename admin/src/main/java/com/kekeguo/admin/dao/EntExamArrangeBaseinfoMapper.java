package com.kekeguo.admin.dao;

import com.kekeguo.admin.model.EntExamArrangeBaseinfo;
import com.kekeguo.admin.model.ExamSessionTempBiz;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntExamArrangeBaseinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EntExamArrangeBaseinfo record);

    int insertSelective(EntExamArrangeBaseinfo record);

    EntExamArrangeBaseinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntExamArrangeBaseinfo record);

    int updateByPrimaryKey(EntExamArrangeBaseinfo record);

    List<ExamSessionTempBiz> getData (@Param("session") String session ,@Param("name") String name,@Param("area") String area,@Param("courseName") String courseName);
}