package inflearn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //template  밑에 있는 hello.html을 실행하는 것임
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";

    }

    @GetMapping("hello-string")
    @ResponseBody   //http응답에 데이터를 그대로 넘김 -> return이 string 형식이라 string데이터만 넘김
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody   //http응답에 데이터를 그대로 넘김 -> return이 객체형식 -> JSon방식으로 데이터를 넘김
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(String name) {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
