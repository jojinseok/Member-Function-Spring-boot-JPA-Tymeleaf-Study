package com.example.springstudy.controller;

public class MemberForm {

    private String name; //Form 태그에 변수명과 같은 이름이 있으면 자동으로 세팅
    public String getName() {
        return name;
    }

    public void setName(String name) { //Spring 컨테이너가 자동으로 호출
        this.name = name;
    }


}
