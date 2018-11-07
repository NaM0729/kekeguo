package com.kekeguo.admin.service;

import com.kekeguo.admin.model.ExamSessionTempBiz;

import java.util.List;

/**
 * @author zhangyuna
 * @date 2018年11月07日16:33:56
 */
public interface EntExamArrangeBaseinfoService {
    List<ExamSessionTempBiz> getData(String session,String name,String area,String courseName);
}
