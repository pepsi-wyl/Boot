package com.pepsiwyl.mapper;

import com.pepsiwyl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-03-14 19:52
 */

@Mapper // 标注注解 mapper
@Repository(value = "userMapper")
public interface UserMapper {
    // 得到所有用户信息
    List<User> getUserList();
}
