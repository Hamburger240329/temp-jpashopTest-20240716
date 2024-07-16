package com.gyojincompany.jpashopTest_20240716.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jpa_membertbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    @Id //매핑될 테이블의 기본키 필드로 설정
    @Column(name = "membernum") //실제 DB 테이블의 필드이름을 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membernum;//회원번호(1부터 1씩증가하고 기본키로 설정)

    @Column(name = "memberid", length = 20, nullable = false, unique = true)
    private String memberid;//회원아이디

    @Column(name = "memberpw", length = 20, nullable = false)
    private String memberpw;//회원비밀번호

    @Column(name = "membername", length = 20, nullable = false)
    private String membername;//회원이름

    @Column(name = "memberage") //실제 DB 테이블의 필드->memberage
    private int age;//회원나이

}
