package com.bhome.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserController {
    @GetMapping("myInfo/loginForm")
    public String loginForm(HttpServletRequest request){
        return "user/userLoginForm";
    }

    @GetMapping("myInfo/registForm")
    public String registForm(HttpServletRequest request){
        return "user/userRegistForm";
    }

}
