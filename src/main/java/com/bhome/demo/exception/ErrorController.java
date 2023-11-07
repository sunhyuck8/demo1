package com.bhome.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
@Slf4j
public class ErrorController {

    @GetMapping("/error-ex")
    public void errorEx(){
        throw new RuntimeException("예외ex");
    }

    @GetMapping("/error-404")
    public void error404(HttpServletResponse response) throws IOException {
        response.sendError(404,"오류 404");
    }

    @GetMapping("/error-400")
    public void error400(HttpServletResponse response) throws IOException {
        response.sendError(400,"오류 400");
    }

    @GetMapping("/error-500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500,"오류 500");
    }

    @GetMapping("/error-302")
    public void error302(HttpServletResponse response) throws IOException {
        response.sendError(302,"오류 302");
    }

    @GetMapping("/error-200")
    public void error200(HttpServletResponse response) throws IOException {
        response.sendError(200,"오류 200");
    }
}
