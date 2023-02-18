package com.example.springstudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect //AOP 사용 어노테이션
@Component //빈으로 등록해줘야됨 (@Component로 bean 추가, SpringConfig에 추가하면 스프링 빈 순환 참조 오류 발생해서 다시 Component로 바꿈)
public class TraceAop {

    @Around("execution(* com.example.springstudy..*(..))")  //공통 관심 사항을 어디에 적용할 거냐 물어보는 어노테이션 (해당 패키지 안에 있는 곳에는 다 적용하라는 뜻, 이 부분을 원하는대로 바꿔쓰면 됨)
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
                            //JoinPoint는 인터셉터와 유사함
        long start= System.currentTimeMillis();
        System.out.println("START JOINPOINT : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish=System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("END JOINPOINT : "+joinPoint.toLongString()+" "+ timeMs + "ms");
        }

    }
}
