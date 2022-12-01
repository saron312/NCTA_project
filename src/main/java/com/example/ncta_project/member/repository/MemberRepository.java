package com.example.ncta_project.member.repository;

import com.example.ncta_project.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,String> {


//    @Query("select m.password from Member m where m.memberId=:memberId")
//    boolean findPw(String memberId);
    boolean existsMemberByMemberIdAndPassword(String memberId, String password);

    @Query("select m.password from Member m where m.memberId = :memberId")
    String passwordCheck(String memberId);
}
