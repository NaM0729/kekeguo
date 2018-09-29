package com.kekeguo.admin.controller;

import com.kekeguo.admin.util.DataResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@ResponseBody
public class LoginController {

    @RequestMapping("/login")
    public DataResult Login(@RequestParam("username") String username) {
        return DataResult.success(username);
    }
}
