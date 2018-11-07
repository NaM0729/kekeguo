package com.kekeguo.admin.service.impl;

import com.kekeguo.admin.dao.EntExamArrangeBaseinfoMapper;
import com.kekeguo.admin.model.ExamSessionTempBiz;
import com.kekeguo.admin.service.EntExamArrangeBaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangyuna
 * @date 2018年11月07日16:34:48
 */
public class EntExamArrangeBaseinfoServiceImpl implements EntExamArrangeBaseinfoService {
    @Autowired
    EntExamArrangeBaseinfoMapper entExamArrangeBaseinfoMapper;

    @Override
    public List<ExamSessionTempBiz> getData(String session,String name,String area,String courseName) {
        return entExamArrangeBaseinfoMapper.getData(session,name,area,courseName);
    }
}
