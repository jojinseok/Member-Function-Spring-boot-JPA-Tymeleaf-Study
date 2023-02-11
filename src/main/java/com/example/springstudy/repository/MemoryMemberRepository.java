package com.example.springstudy.repository;

import com.example.springstudy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryMemberRepository implements MemberRepository{
//저장소에 관여하는 repository
    private static Map<Long,Member> store= new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //반복되면서 파라매터와 같은 경우에만 필터링 >  쵲으면 리턴
        return store.values().
                stream().
                filter(member->member.getName().equals(name)).
                findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //value = Member 반환
    }

    @Override
    public void clearStore(){ //@AfterEach 테스트케이스 작성시 Memory 값 정리를 위한 메소드
        store.clear();
    }
}
