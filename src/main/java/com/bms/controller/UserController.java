package com.bms.controller;


import com.bms.common.Result;
import com.bms.domain.User;
import com.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getList")
    public Result<List<User>> getList() {
        return Result.success(userService.getUserList());
    }

    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        //获取用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        //些处横板从数据库中获取对用户名和密码后进行判断
        if (username == null && password == null) {
            model.addAttribute("msg", "用户名和密码，不可为空！");
        }
        if (userService.login(username, password)) {
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION", user);
            //重定向到主页面，调用toMain方法
            return "redirect:main";
        } else {
            model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        }
        return "login";
    }

    @RequestMapping(value = "/main")
    public String toMain() {
        return "main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:user/login";
    }

    @RequestMapping("register")
    public Result register(String username, String password, Integer gender) {
        return Result.success(userService.register(new User(username, password, gender)));
    }


}
