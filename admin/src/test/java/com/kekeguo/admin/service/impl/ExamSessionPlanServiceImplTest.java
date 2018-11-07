package com.kekeguo.admin.service.impl;

import com.kekeguo.admin.AdminApplicationTest;
import com.kekeguo.admin.model.ExamSessionPlan;
import com.kekeguo.admin.service.ExamSessionPlanService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ExamSessionPlanServiceImplTest extends AdminApplicationTest {

    @Autowired
    private ExamSessionPlanService examSessionPlanService;
    @Test
    public void getList() {
        List<ExamSessionPlan> list = examSessionPlanService.getList();
        System.out.println(list.size());
    }
}