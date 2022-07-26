package com.pepsiwyl.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author by pepsi-wyl
 * @date 2022-03-11 16:34
 */

@RestController
public class UserController {

    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {
        return "GET查询";
    }

    //    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "POST保存";
    }


    //    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {
        return "PUT修改";
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser() {
        return "DELETE删除";
    }

}
