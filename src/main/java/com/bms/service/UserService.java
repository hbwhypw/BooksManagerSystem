package com.bms.service;

import com.bms.common.Result;
import com.bms.domain.User;
import com.bms.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        List<String> strings = FileUtil.readFileList(getClass().getResource("/").getPath() + "user.txt");
        for (String content : strings) {
            String[] split = content.split(",");
            if (split.length == 3) {
                list.add(new User(split[0], split[1], Integer.parseInt(split[2])));
            }
        }
        return list;
    }

    public Boolean login(String username, String password) {
        List<String> strings = FileUtil.readFileList(getClass().getResource("/").getPath() + "user.txt");
        for (String content : strings) {
            String[] split = content.split(",");
            if (split.length == 4) {
                if (username.equals(split[0]) && password.equals(split[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Result register(User user) {
        String path = getClass().getResource("/").getPath() + "user.txt";

        List<User> list = getUserList();
        for (User userTemp : list) {
            if (userTemp.getUsername().equals(user.getUsername())) {
                return Result.fail(1, "用户名不可重复！");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(user.getUsername()).append(",").append(user.getPassword()).append(",").append(user.getGender());
        FileUtil.writeAppendFile(path, sb.toString());
        return Result.success();
    }
}
