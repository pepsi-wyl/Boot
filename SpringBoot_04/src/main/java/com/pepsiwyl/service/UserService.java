package com.pepsiwyl.service;

import com.pepsiwyl.pojo.User;

import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-05-03 21:08
 */

public interface UserService {
    // 得到所有用户信息
    List<User> getUserList();
}
