package com.bhome.demo.controller;

import com.bhome.demo.dto.AppleMapperDTO;
import com.bhome.demo.dto.BoardDto;
import com.bhome.demo.dto.BoardNDto;
import com.bhome.demo.service.BoardService;
import com.bhome.demo.service.PostService;
import com.bhome.demo.service.ServiceTest;
import com.bhome.demo.util.Paging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
//@RequiredArgsConstructor는 인터페이스를 주입 받을때 사용 Lombok으로 스프링에서 DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션이다.
//참고 https://dreamcoding.tistory.com/83
public class HomeController {

    //    private final ServiceTest serviceTest;
    private final PostService postService;
    private final Paging paging;




    //페이지의 main   index.html
    @GetMapping("/")
    public String test(HttpServletRequest request){


        return "index/index";
    }
    //community 페이지  사진을 위주로 올리는 게시판
    @GetMapping("/community")
    public String idx_community(HttpServletRequest request){






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
    public String testForm(HttpServletRequest request, Model model){
        String as =  "<img class=\"img-fluid\" th:src=\"@{/templates/img/media-1.jpg}\" alt=\"\">";
        model.addAttribute("escape", as);

//<img class="img-fluid" th:src="@{/templates/img/media-1.jpg}">
        return "test";
    }

    @GetMapping("/Crawling")
    @ResponseBody
    public String testCrawling(HttpServletRequest request) throws IOException {
        String url = "https://smartstore.naver.com/health365/products/4730685086?n_media=11068&n_query=%EC%87%BC%ED%8C%8C&n_rank=1&n_ad_group=grp-a001-02-000000024850701&n_ad=nad-a001-02-000000164271318&n_campaign_type=2&n_mall_id=hymedi&n_mall_pid=4730685086&n_ad_group_type=2&n_match=3&NaPm=ct%3Dlnqkxun4%7Cci%3D0z00000q3MHzFhUIlvnU%7Ctr%3Dpla%7Chk%3Db47fab3d3087438a30a3079e2e8bdf23baaf4ea3";
        Document doc = Jsoup.connect(url).get();
        String text ="";
        Elements eles = doc.select(".TsOLil1PRz");
        for(Element ele : eles){
            text += ele.text();
        }

        return text;
    }
}
