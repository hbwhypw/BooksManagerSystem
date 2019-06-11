package com.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping(value = "main")
    public String toMain() {
        return "book/list";
    }
}







