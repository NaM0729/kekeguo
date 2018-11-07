package com.kekeguo.admin.controller;

import com.kekeguo.admin.model.ExamSessionPlan;
import com.kekeguo.admin.service.ExamSessionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangyuna
 * @date 2018年11月07日16:06:59
 */
@RestController
public class ExamSessionPlanController {
    @Autowired
    ExamSessionPlanService examSessionPlanService;

    @RequestMapping("test")
    public void getList() {
        List<ExamSessionPlan> list = examSessionPlanService.getList();
        System.out.println(list.size());
    }

}
