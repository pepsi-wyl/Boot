package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author by pepsi-wyl
 * @date 2022-03-13 13:40
 */

@Controller("indexController")
public class IndexController {
    @GetMapping(path = {"/", "/index", "/index.html", "/main", "/main.html"})
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
