package com.shuang.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Value("${spring.profiles.active}")
    private String evn;

    @Autowired
    private Environment evnirorn;

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld"+ "  " + evn + "  " + evnirorn.getProperty("spring.profiles.active");
    }

    @GetMapping("/helloworld2")
    public String helloworld2(Map<String, Object> model) {
        model.put("message",evn);
        return "welcome";
    }
}
