package com.kekeguo.admin.controller;

import com.kekeguo.admin.service.ClassifyByExcel;
import com.kekeguo.admin.util.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyuna
 * @date 2018年10月24日16:27:19
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/index";
    }
    @Autowired
    private ClassifyByExcel classifyByExcel;

}
