package com.bhome.demo.controller;

import com.bhome.demo.dto.UserDto;
import com.bhome.demo.dto.UserRegistDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@Slf4j
@Controller
public class UserController {
    @Value("${file.dir}")
    private String fileDir;
    private final ServletContext context;
    @Autowired
    public UserController(ServletContext context) {
        this.context = context;
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

    @RequestMapping(value = "/user/regist1", method = RequestMethod.POST)
    public String userRegist(HttpServletRequest request,  UserRegistDto userRegistDto, Model model) throws IOException {
        log.info("리얼 패스 궁금해 {}",context.getRealPath("/image/user/"));
        //디렉토리 찾기
        String abDir = context.getRealPath("/user/");
        //없을시 만들기
        File directory = new File(abDir);
        if(!directory.exists()){
            directory.mkdirs();
        }

        MultipartFile photo = userRegistDto.getPhoto();

        String filename = photo.getOriginalFilename();
        int lastIndex = filename.lastIndexOf(".");


        if(!photo.isEmpty()){
            String fullPath = fileDir + filename;
            log.info("filedir{},path{}",fileDir,fullPath);
            String serverStorePath = abDir + photo.getOriginalFilename();
            photo.transferTo(new File(serverStorePath));
        }

        model.addAttribute("testVo", userRegistDto);
        String ref = (String) request.getSession().getAttribute("ref");
        log.info("ref = {}",ref);
//        return "redirect:"+ref;
        String contextPath = request.getContextPath();
        log.info("contextPath = {}",contextPath);

        return "test";
    }

}
