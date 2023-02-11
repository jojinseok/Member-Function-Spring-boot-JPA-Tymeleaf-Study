package com.example.springstudy.repository;

import com.example.springstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemberRepository repository= new MemoryMemberRepository();

    @AfterEach //Test 메소드가 끝날때마다 해당 메소드 실행 (Memory 정리)
    public void afterEach(){
    repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result=repository.findById(member.getId()).get();
        //Assertions.assertEquals(member,result); //기댓값은 member 실제값은 result
        Assertions.assertThat(member).isEqualTo(result); //위 테스트와 동일
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result=repository.findByName("spring").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }


}
