package com.kekeguo.admin.service.impl;

import com.kekeguo.admin.dao.ExamSessionPlanMapper;
import com.kekeguo.admin.model.ExamSessionPlan;
import com.kekeguo.admin.service.ExamSessionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyuna
 * @date 2018年11月07日13:48:19
 */
@Service
public class ExamSessionPlanServiceImpl implements ExamSessionPlanService {

    @Autowired
    private ExamSessionPlanMapper examSessionPlanMapper;

    public List<ExamSessionPlan> getList() {
        List<ExamSessionPlan> list = examSessionPlanMapper.getList();
        return list;
    }
}
