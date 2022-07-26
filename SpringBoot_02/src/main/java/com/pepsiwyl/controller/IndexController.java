package com.pepsiwyl.controller;

import com.pepsiwyl.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

/**
 * @author by pepsi-wyl
 * @date 2022-03-10 21:30
 */

@Controller
public class IndexController {
    @GetMapping({"/index", "/"})
    public String index(HttpServletResponse resp) {
        CookieUtils.creatCookie("cookieName", "cookieName", resp);
        return "index";
    }
}
