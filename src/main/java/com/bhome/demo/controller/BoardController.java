package com.bhome.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    //글등록하는 폼으로 이동
//    @GetMapping("/{boardType}/regist")
//    public String registPost(@PathVariable("boardType")String boardType, HttpServletRequest request){
//        log.info("boardType = {},subType = {}", boardType);
//        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
//        return "post/test_post_registForm";
//    }
//    @PostMapping("/{boardType}/{subType}/regist")
//    public String registBoard(@PathVariable("boardType")String boardType, @PathVariable("subType")String subType, HttpServletRequest request, PostRegistDto postRegistDto){
//
//        return "";
//    }



}
