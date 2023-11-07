package com.bhome.demo.controller;

import com.bhome.demo.dto.PostCategoryDto;
import com.bhome.demo.dto.PostDetailtDto;
import com.bhome.demo.dto.PostFormRegistDto;
import com.bhome.demo.service.PostService;
import com.bhome.demo.vo.PostDetailVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

        List<PostCategoryDto> subList = postService.getSubList(boardType);
        PostFormRegistDto postFormRegistDto = new PostFormRegistDto();

        model.addAttribute("boardType",boardType);
        model.addAttribute("subCategoryList", subList);
        model.addAttribute("postFormRegistDto", postFormRegistDto);
        log.info("boardType = {}", boardType);

        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            throw new ResponseStatusException(HttpStatus.OK, "로그인을 해주세요");
        }
        return "/post/post-regist-form";
    }
    @PostMapping("/{boardType}/regist")
    public String registPost(@PathVariable("boardType")String boardType, HttpServletRequest request, PostFormRegistDto postFormRegistDto,Model model) throws IOException {
        log.info("postFormRegsotDto ={}",postFormRegistDto);
        int post_pk = postService.registPost(postFormRegistDto);
        log.info("post pk  = {}",post_pk);
        return "redirect:/"+boardType+"/detail?post_pk="+post_pk;
    }

    @GetMapping("/{boardType}/detail")
    public String showDetailPost(HttpServletRequest request, Model model){
        //pk가져오기
        int post_pk = Integer.parseInt(request.getParameter("post_pk"));
        log.info("1 pk가져오기 pk={}",post_pk);

        PostDetailVo vo = postService.showDetailPost(post_pk);
        log.info("받은값 {}",vo);
        return "/";
    }
//    @GetMapping()
//    public String showListPost(){
//        return "";
//    }
//    @GetMapping()
//    public String showListPostByItem(){
//        return "";
//    }



}
