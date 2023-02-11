package com.example.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello") // URL 매핑
    public String hello(Model model){ //Model 로 값 이동
        model.addAttribute("data","hello"); //Model에 속성 추가
        return "hello"; //hello.html 호출
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value="name",required = false) String name, Model model){
        //URL 뒤에 ?하고 넘어오는 파라매터 값 변수에 저장, required= false 하면 파라매터 안넘겨도 오류 안남
        model.addAttribute("name",name);
        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody //http 통신 프로토콜 body에 이 데이터를 넣겠다는 뜻, html 작동 X, 값만 리턴
    public String helloString(@RequestParam(required = false) String name){
        return "Responsebody 연습 (Return 타입 클래스면 사용불가) "+name; //html 태그 없이 그냥 http body 내용만 출력함
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        Hello hello=new Hello();
        hello.setname(name);
        return hello; // 객체로 넘기면 JSON 방식(Key Value 구조)으로 나옴
    }

    static class Hello{
        private String name;
        public String getNmae(){
            return name;
        }
        public void setname(String name){
            this.name=name;
        }
    }
}
