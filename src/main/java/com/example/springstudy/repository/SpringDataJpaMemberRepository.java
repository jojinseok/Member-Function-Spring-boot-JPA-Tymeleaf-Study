package com.example.springstudy.repository;

import com.example.springstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//SpringDataJPA - 자동으로 구현체 넣어줌 ( Hibernate )
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
