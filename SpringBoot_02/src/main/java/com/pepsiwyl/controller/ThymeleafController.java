package com.pepsiwyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author by pepsi-wyl
 * @date 2022-03-12 19:09
 */

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("msg", "thymeleaf");
        model.addAttribute("link", "https://www.thymeleaf.org/");
        return "thymeleaf";
    }
}
