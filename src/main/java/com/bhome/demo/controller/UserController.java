package com.bhome.demo.controller;

import com.bhome.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserController {
    @GetMapping("myInfo/loginForm")
    public String loginForm(HttpServletRequest request){
        return "user/userLoginForm";
    }

    @GetMapping("/myInfo/registForm")
    public String registForm(HttpServletRequest request,Model model){
        model.addAttribute("userDto", new UserDto());//th:object를 쓰기 위함
        return "user/userRegistForm";
    }

    @RequestMapping(value = "/user/regist1", method = RequestMethod.POST)
    public String userRegist(HttpServletRequest request,  UserDto userDto) throws JsonProcessingException {

//        log.info("id와 password {}, {}",userDto.getUser_id(),userDto.getUser_pass());
//        log.info("userdto 내용{}",request.getParameter("user_id"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userDto);
        log.info("userdto 내용{}",json);
        return "/test";
    }

}
