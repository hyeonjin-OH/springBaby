package inflearn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")    //기본 경로
    public String home(){
        return "home";
    }


}
