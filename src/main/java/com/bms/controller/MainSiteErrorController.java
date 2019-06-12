package com.bms.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 杨彭伟
 * @date 2019-06-12 17:16
 */
@Controller
public class MainSiteErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 404) {
            return "errors/404";
        } else {
            return "errors/500";
        }
    }

    @Override
    public String getErrorPath() {
        return "index";
    }
}