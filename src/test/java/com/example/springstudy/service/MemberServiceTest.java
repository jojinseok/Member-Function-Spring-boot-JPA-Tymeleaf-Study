package com.example.springstudy.service;

import com.example.springstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MemberServiceTest {


        @Autowired
        MemberService memberService;
    @Test
    void join() {
        //given  이러한 상황이 주어졌을 때
        Member member = new Member();
        member.setName("hello");
        //when 이것을 실행했을때
        Long saveId=memberService.join(member);

        //then 결과가 이게 나와야됨
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
        Member member1=new Member();
        member1.setName("spring");

        Member member2=new Member();
        member2.setName("spring");

        memberService.join(member1);


    }

    @Test
    void findOne() {
    }
}