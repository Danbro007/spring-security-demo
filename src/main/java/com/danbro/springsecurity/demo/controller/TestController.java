package com.danbro.springsecurity.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/10/26 15:16
 * @Author Danrbo
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/add")
    private String add(){
        return "hello SpringSecurity!";
    }
}
