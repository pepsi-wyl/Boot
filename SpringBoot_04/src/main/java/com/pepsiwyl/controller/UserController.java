package com.pepsiwyl.controller;

import com.pepsiwyl.pojo.User;
import com.pepsiwyl.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-03-18 16:22
 */

@RestController
public class UserController {
    final UserService userService;

    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> json() {
        return userService.getUserList();
    }
}
