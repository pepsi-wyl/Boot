package com.pepsiwyl.service;

import com.pepsiwyl.mapper.UserMapper;
import com.pepsiwyl.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-05-03 21:08
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return null;
    }
}
