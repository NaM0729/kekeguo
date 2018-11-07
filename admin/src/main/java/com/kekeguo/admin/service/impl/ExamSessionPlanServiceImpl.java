package com.kekeguo.admin.service.impl;

import com.kekeguo.admin.config.DS;
import com.kekeguo.admin.dao.ExamSessionPlanMapper;
import com.kekeguo.admin.model.ExamSessionPlan;
import com.kekeguo.admin.service.EntExamArrangeBaseinfoService;
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
    @Autowired
    private EntExamArrangeBaseinfoService entExamArrangeBaseinfoService;

    @DS("studyplan")
    public void getList() {
        List<ExamSessionPlan> list = examSessionPlanMapper.getList();
        for (int i=0;i<list.size();i++){
            ExamSessionPlan examSessionPlan = list.get(i);
            String session = "1904";
            if(examSessionPlan.getExamSessionNum()%2 == 0 ){
                session = "1810";
            }
            entExamArrangeBaseinfoService.getData(session,examSessionPlan.getProjectName(),
                    String.valueOf(examSessionPlan.getAreaId()),examSessionPlan.getCourseName());
        }
    }
}
