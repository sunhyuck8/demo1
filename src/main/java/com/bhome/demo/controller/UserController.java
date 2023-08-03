package com.bhome.demo.controller;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.dto.UserRegistDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
public class UserController {
    @Value("${file.dir}")
    private String fileDir;
    private final ServletContext context;
    private ResourceLoader resourceLoader;
    @Autowired
    public UserController(ServletContext context, ResourceLoader resourceLoader) {
        this.context = context;
        this.resourceLoader = resourceLoader;
    }



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
        String folder = request.getServletContext().getRealPath("/");
        log.info("루트의 리얼 패스는 ?  ={}",folder);

        MultipartFile file = userRegistDto.getPhoto();
        String fileName = userRegistDto.getPhoto().getOriginalFilename();
        Path path = Paths.get("C:/work/eximage/user/",fileName);
        file.transferTo(path.toFile());
//        ClassPathResource resource = new ClassPathResource();


        return "test";
    }

}
