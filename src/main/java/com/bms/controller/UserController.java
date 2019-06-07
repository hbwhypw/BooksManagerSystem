package com.bms.controller;


import com.bms.common.Result;
import com.bms.domain.User;
import com.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getList")
    public Result<List<User>> getList() {
        return Result.success(userService.getUserList());
    }

    @RequestMapping("login")
    public Result<Boolean> login(String username, String password) {
        return Result.success(userService.login(username, password));
    }

    @RequestMapping("register")
    public Result register(String username, String password, Integer gender) {
        return Result.success(userService.register(new User(username, password, gender)));
    }


}
