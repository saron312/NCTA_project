package com.example.ncta_project.member.repository;

import com.example.ncta_project.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,String> {

    @Query("select m.memberId from Member m where m.memberId=:memberId and m.password=:password")
    Optional<String> loginId(String memberId, String password);
}
