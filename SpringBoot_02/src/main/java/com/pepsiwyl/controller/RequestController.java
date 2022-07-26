package com.pepsiwyl.controller;

import com.pepsiwyl.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by pepsi-wyl
 * @date 2022-03-12 9:01
 */
@Controller
public class RequestController {

    @GetMapping(value = "/goTo")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        System.out.println("test1");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping(value = "/success")
    public Map<String, Object> success
            (
                    //@RequestAttribute 转发参数
                    @RequestAttribute("msg") String msg, //
                    @RequestAttribute("code") Integer code,
                    HttpServletRequest request
            ) {
        System.out.println("test2");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", code);
        hashMap.put("msg", msg);
        hashMap.put("HttpServletRequest", request.getAttribute("code") + " " + request.getAttribute("msg"));
        return hashMap;
    }


    //http://127.0.0.1:8080/params
    @GetMapping(value = "/params")
    public String param_T(
            Map<String, Object> map,
            Model model,
            ModelAndView modelAndView,
            ModelMap modelMap,
            // BindingAwareModelMap  (map+model)
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        map.put("map", "mapParam");
        model.addAttribute("model", "modelParam");
        modelAndView.addObject("modelAndView", "modelAndViewParam");
        modelMap.put("modelMap","modelMapParam");
        request.setAttribute("request", "requestParam");
        response.addCookie(new Cookie("cookie", "cookieParam"));
        return "forward:/successParams";
    }

    @ResponseBody
    @GetMapping(value = "/successParams")
    public Map<String, Object> successParams(
            HttpServletRequest request
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("map", request.getAttribute("map"));
        hashMap.put("model", request.getAttribute("model"));
        hashMap.put("modelAndView", request.getAttribute("modelAndView"));
        hashMap.put("modelMap", request.getAttribute("modelMap"));
        hashMap.put("request", request.getAttribute("request"));
        hashMap.put("cookie", request.getCookies());
        return hashMap;
    }


}
