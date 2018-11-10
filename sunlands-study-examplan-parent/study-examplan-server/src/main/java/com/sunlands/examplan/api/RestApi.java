package com.sunlands.examplan.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunlands.examplan.ExamPlanServerApplication;
import com.sunlands.examplan.base.controller.BaseController;
import com.sunlands.examplan.entity.SchLocalProvinceEntity;
import com.sunlands.examplan.service.SchLocalProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class RestApi extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExamPlanServerApplication.class);

    @Autowired
    private SchLocalProvinceService schLocalProvinceService;

    @HystrixCommand(fallbackMethod = "hiError")
    @GetMapping("rest")
    public void rest(HttpServletResponse response){
        try {
            response.getWriter().print("hello world !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hiError(HttpServletResponse response) {
        try {
            response.getWriter().print("hi,please wait ! sorry,error!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *  获取省市列表
     */
    @GetMapping(value = "province", produces = "application/json; charset=UTF-8")
    public void province(HttpServletResponse response){
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("IndexApi.indexPackage.post invoked!");
        }
        try {
            List<SchLocalProvinceEntity> list = schLocalProvinceService.findList(null);
            renderSuccess(response, list);
        } catch (Exception e) {
            renderError(response, null);
            LOGGER.error("获取省市列表时发生异常：" + e.getMessage(), e);
        }
    }

}
