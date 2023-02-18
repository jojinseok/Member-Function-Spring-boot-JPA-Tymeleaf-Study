package com.example.springstudy.repository;

import com.example.springstudy.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional //JPA 를 쓰려면 선언해야됨
public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em; //현재 db랑 연결해줌, DB 정보 다 가지고 있음
    public JpaMemberRepository(EntityManager em) { //DI 받는것
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name=:name", Member.class).setParameter("name", name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
       return em.createQuery("select m from Member m",Member.class).getResultList();
       //JPQL - 객체(Entity)를 대상으로 쿼리를 날리면 query로 변환됨, m은 as 된 것,
    }

}
