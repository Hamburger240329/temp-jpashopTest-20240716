package com.gyojincompany.jpashopTest_20240716.repository;

import com.gyojincompany.jpashopTest_20240716.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByMembername(String membername);//회원 이름으로 검색
    public List<Member> findByMembernameLike(String membername);
    public List<Member> findByMembernameOrderByAgeDesc(String membername);//회원 이름으로 검색 후 나이 내림차순 정렬
    public List<Member> findAllByOrderByAgeDesc();

    @Transactional
    public void deleteAllByMembername(String membername);


}
