//package com.example.springstudy;
//
//import com.example.springstudy.repository.MemberRepository;
//import com.example.springstudy.repository.MemoryMemberRepository;
//import com.example.springstudy.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    @Bean //직접 스프링 빈 등록
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
