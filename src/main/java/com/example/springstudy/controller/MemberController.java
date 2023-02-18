package com.example.springstudy.controller;

import com.example.springstudy.domain.Member;
import com.example.springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService= memberService;
        System.out.println("MemberService DI 확인 : "+memberService.getClass());
    }


    @GetMapping("/members/new") //조회할때 주로 사용
    public String createForm(Model model){

        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //데이터를 FORM 같은 곳에 넣어서 전달할때 주로 사용
    public String create(@RequestParam String name){
        Member member=new Member();
        member.setName(name);
        memberService.join(member);
        System.out.println(name);
        return "redirect:/";        //처리가 끝나면 해당 화면으로 보내기
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members=memberService.findMembers();
//        System.out.println(members.get(0).getName());
//        System.out.println(members.get(0).getId());

        model.addAttribute("members",members);
        return "members/memberList";
    }
}
