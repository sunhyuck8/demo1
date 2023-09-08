package com.bhome.demo.controller;

import com.bhome.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{boardType}/regist")
    public String registPost(@PathVariable("boardType")String boardType, HttpServletRequest request, Model model){
        log.info("PostController--registPost() 글등록 페이지 getMapping");

        List subList = postService.getSubList(boardType);

        model.addAttribute("boardType",boardType);
        model.addAttribute("subCategoryList", subList);
        log.info("boardType = {}", boardType);
        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
        return "post/test_post_registForm";
    }


}
