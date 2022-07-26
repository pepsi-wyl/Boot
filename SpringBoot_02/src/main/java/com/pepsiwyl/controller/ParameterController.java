package com.pepsiwyl.controller;

import com.pepsiwyl.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by pepsi-wyl
 * @date 2022-03-11 19:45
 */

@RestController
public class ParameterController {

    /**
     * 获取参数值
     * http://127.0.0.1:8080/get/1/pepsi-wyl/zhazha?age=20&inters=java&inters=sql
     */
    @GetMapping("/get/{id}/pepsi-wyl/{name}")
    public Map<String, Object> get(

            // 路径变量   @PathVariable
            @PathVariable("id") String id,
            @PathVariable("name") String name,
            @PathVariable Map<String, String> pv,

            // 获取请求头  @RequestHeader
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> headers,

            // 获取请求参数 @RequestParam
            @RequestParam("age") Integer age,
            @RequestParam("inters") List<String> inters,
            @RequestParam Map<String, String> params,

            //获取Cookie的值
            @CookieValue("cookieName") String cookieString,
            @CookieValue("cookieName") Cookie cookieCookie

    ) {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("id", id);
        hashMap.put("name", name);
        hashMap.put("pv", pv);

        hashMap.put("User-Agent", userAgent);
        hashMap.put("headers", headers);

        hashMap.put("age", age);
        hashMap.put("inters", inters);
        hashMap.put("params", params);

        hashMap.put("cookieString", cookieString);
        hashMap.put("cookieCookie", cookieCookie.getName() + cookieCookie.getValue());
        return hashMap;
    }


    /**
     * 获取请求体
     */
    @PostMapping("/save")
    public Map<String, Object> save
    (
            @RequestBody String form
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("form", form);
        return hashMap;
    }

    /**
     * 矩阵变量
     * 页面开发过程中，Cookie被禁用，把Cookie的值实验矩阵变量的方式进行传递
     * 默认关闭   需要手动开启   removeSemicolonContent(移除分号内容)
     * 必须要有URL路径变量
     */
    //http://127.0.0.1:8080/cars/1;name=pepsi-wyl;password=888888;password=999999
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public Map<String, Object> MatrixVariable
    (
            @PathVariable("id") String id,         // 必须要有URL路径变量
            @MatrixVariable("name") String name,
            @MatrixVariable("password") List<String> password
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("name", name);
        hashMap.put("password", password);
        return hashMap;
    }

    //http://127.0.0.1:8080/cars/sell1;low1=1;rand1=byd,aodi/sell2;low2=2;rand2=yd
    @RequestMapping(value = "/cars/{parameter1}/{parameter2}", method = RequestMethod.GET)
    public Map<String, Object> MatrixVariable2
    (
            @PathVariable("parameter1") String parameter1,
            @PathVariable("parameter2") String parameter2,
            @MatrixVariable(value = "low1", pathVar = "parameter1") Integer low1,
            @MatrixVariable(value = "rand1", pathVar = "parameter1") List<String> brand1,
            @MatrixVariable(value = "low2", pathVar = "parameter2") Integer low2,
            @MatrixVariable(value = "rand2", pathVar = "parameter2") List<String> brand2
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("low1", low1);
        hashMap.put("rand1", brand1);
        hashMap.put("low2", low2);
        hashMap.put("rand2", brand2);
        hashMap.put("parameter1", parameter1);
        hashMap.put("parameter2", parameter2);
        return hashMap;
    }


    @PostMapping("/pojo")
    public Person savePerson(Person person) {
        return person;
    }

}
