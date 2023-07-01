package com.bhome.demo.controller;

import com.bhome.demo.dto.AppleMapperDTO;
import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.service.BoardService;
import com.bhome.demo.service.ServiceTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
//@RequiredArgsConstructor는 인터페이스를 주입 받을때 사용 Lombok으로 스프링에서 DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션이다.
//참고 https://dreamcoding.tistory.com/83
public class HomeController {

    //    private final ServiceTest serviceTest;
    private final BoardService boardService;





    //페이지의 main   index.html
    @GetMapping("/")
    public String test(HttpServletRequest request){
//        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
//        session.setAttribute("loginFlag", false);

//        AppleMapperDTO apple = serviceTest.selectApple();
        List<BoardDto> list = boardService.boardSelectAll();
        System.out.println(list.get(1));

        return "index/index";
    }
    //community 페이지  사진을 위주로 올리는 게시판
    @GetMapping("/community")
    public String idx_community(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("loginFlag", true);
        return "community/index_community";
    }
    //cs 고객센터 불편한 내용들을 컨펌받는 게시판
    @GetMapping("/cs")
    public String idx_cs(HttpServletRequest request){
//        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
//        session.setAttribute("loginFlag", false);
        return "cs/index_cs";
    }
    // 질문 게시판 이것저것 질문하는 사이트
    @GetMapping("/question")
    public String idx_question(){
        return "question/index_question";
    }
    //나의 정보를 볼 수 있는 사이트
    @GetMapping("/myinfo")
    public String idx_myinfo(HttpServletRequest request){
//        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
//        session.setAttribute("loginFlag", false);
        return "myinfo/index_myinfo";
    }
    @GetMapping("/test")
    public String testForm(HttpServletRequest request){
//        HttpSession session = request.getSession();//이부분은 세션에 관련해서 header를 변화 시키기 위해 임시로 넣은 값
//        session.setAttribute("loginFlag", false);
        return "test";
    }

}
