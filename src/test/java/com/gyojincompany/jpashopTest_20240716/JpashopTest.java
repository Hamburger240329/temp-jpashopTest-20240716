package com.gyojincompany.jpashopTest_20240716;

import com.gyojincompany.jpashopTest_20240716.entity.Member;
import com.gyojincompany.jpashopTest_20240716.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JpashopTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입 기능 테스트")
    public void joinMember() {

        Member member = new Member();
        member.setMemberid("blackcat2");
        member.setMemberpw("12345");
        member.setMembername("김고양");
        member.setAge(22);
        
        Member savedMember = memberRepository.save(member);//insert sql문이 실행됨
        System.out.println(savedMember.toString());//저장된 레코드의 내용을 출력
        
    }

    @Test
    @DisplayName("회원번호(기본키)로 검색 테스트")
    public void memberNumSearch() {
        Optional<Member> memberOptional = memberRepository.findById(2L);//회원번호(기본키)로 검색
        //Optional 타입으로 반환을 받으면 null 값으로 반환되었을때도 에러가 안나고 null 값 그대로 저장됨
        assertTrue(memberOptional.isPresent());
        //null값 확인->null값 false, 레코드가 들어있으면 true->테스트에서만 사용
        Member member = memberOptional.get();//memberOptional 내에 들어있는 member 객체를 반환
        System.out.println(member.getMembername());//회원번호로 검색한 회원의 이름을 출력

    }

    @Test
    @DisplayName("회원이름으로 검색 테스트")
    public void memberNameSearch() {
        List<Member> memberList = memberRepository.findByMembername("김고양");

        for (Member member:memberList) {
            System.out.println(member.getMemberid());
            System.out.println(member.getMembername());
        }
    }

    @Test
    @DisplayName("모든 회원목록 검색 테스트")
    public void allMemberList() {
        List<Member> allMemberList = memberRepository.findAll();//모든 레코드 가져오기

        for (Member member :allMemberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getAge() + " / ");
        }
    }

    @Test
    @DisplayName("특정글자 포함 회원 검색 테스트")
    public void firstNameSearch() {
        List<Member> memberList = memberRepository.findByMembernameLike("%김%");

        for (Member member : memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getAge() + " / ");
        }

    }

    @Test
    @DisplayName("회원이름으로 검색 후 나이의 내림차순 정렬")
    public void nameSearch2() {
        List<Member> memberList = memberRepository.findByMembernameOrderByAgeDesc("김고양");
        for (Member member : memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getAge() + " / ");
        }

    }

    @Test
    @DisplayName("회원목록 검색 후 나이의 내림차순 정렬")
    public void memberSearch2() {
        List<Member> memberList = memberRepository.findAllAndOrderByAgeDesc();
        for (Member member : memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getMemberid() + " / ");
            System.out.print(member.getMembername() + " / ");
            System.out.println(member.getAge() + " / ");
        }

    }

}
