package com.bhome.demo.controller;

import com.bhome.demo.dto.UserLoginDto;
import com.bhome.demo.dto.UserRegistDto;
import com.bhome.demo.service.UserService;
import com.bhome.demo.util.FileManager;
import com.bhome.demo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService ) {
        this.userService = userService;
    }
    @Autowired
    private FileManager fileManager;


    @GetMapping("myInfo/loginForm")
    public String loginForm(HttpServletRequest request){
        return "user/userLoginForm";
    }

    @GetMapping("/myInfo/registForm")
    public String registForm(HttpServletRequest request,Model model){
        model.addAttribute("userRegistDto", new UserRegistDto());//th:object를 쓰기 위함
        String referrer = request.getHeader("referer");
        log.info("ref={}",referrer);
        HttpSession session = request.getSession();
        session.setAttribute("ref", referrer);

        return "user/userRegistForm";
    }

    @RequestMapping(value = "/user/regist", method = RequestMethod.POST)
    public String userRegist(HttpServletRequest request,  UserRegistDto userRegistDto, Model model) throws IOException {

            model.addAttribute("userLoginDto", new UserLoginDto());
            userService.userRegistInfo(userRegistDto);

        return "redirect:/user/loginForm";
    }

    @RequestMapping(value = "/user/loginForm", method = RequestMethod.GET)
    public String userLoginForm(HttpServletRequest request,Model model){
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "user/userLoginForm";
    }
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request, UserLoginDto userLoginDto){
        log.info("아이디, 패스워드 = {}, {}",userLoginDto.getUser_id(),userLoginDto.getUser_pass());
        UserVo userVo = userService.userLogin(userLoginDto);
        log.info("vo 는 {}",userVo);
        if(userVo!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",userVo);
            return "redirect:/";
        }

        return "user/userLoginForm";
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String userLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

}
