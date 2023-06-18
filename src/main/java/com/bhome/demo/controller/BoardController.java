package com.bhome.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class BoardController {

    //글등록하는 폼으로 이동
    @GetMapping("/{boardType}/{subType}/regist")
    public String registBoard(@PathVariable("boardType")String boardType, @PathVariable("subType") String subType, HttpServletRequest request){
        log.info("boardType = {},subType = {}", boardType,subType);
        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
        session.setAttribute("loginFlag", false);
        return "board/registForm";
    }
}
