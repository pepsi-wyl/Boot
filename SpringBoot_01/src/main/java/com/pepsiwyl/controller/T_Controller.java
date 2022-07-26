package com.pepsiwyl.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by pepsi-wyl
 * @date 2022-03-06 14:23
 */

@RestController
public class T_Controller {
    @GetMapping("/t")
    public String T() {
        return "success";
    }
}
