package com.example.springstudy;

import com.example.springstudy.repository.MemberRepository;
import com.example.springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //bean 직접 설정
public class SpringConfig {

    @Autowired // MemberRepository는 지금 ioc 컨테이너에 적재되지 않았음, 근데 의존성 주입이 됨
    //이유 : SpringDataJPA 인터페이스(extends JpaRepository<클래스,기본키 속성>)가 구현체인 hibernate를 만들어주고 자동으로 스프링 빈으로 등록해줌
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private MemberRepository memberRepository;


    @Bean //직접 스프링 빈 등록
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TraceAop tracAop(){
//        return new TraceAop();
//    }

//    private EntityManager em;
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository(em);
//    }

//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em=em;
//    }

}
