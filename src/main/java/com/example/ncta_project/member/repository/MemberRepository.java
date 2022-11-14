package com.example.ncta_project.member.repository;

import com.example.ncta_project.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {

}
