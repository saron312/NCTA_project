package com.example.ncta_project.member.service;

import com.example.ncta_project.member.dto.JoinDTO;
import com.example.ncta_project.member.dto.LoginDTO;
import com.example.ncta_project.member.dto.MemberDTO;

public interface MemberService {

    boolean duplicateMemberIdCheck(String memberId);
    void join(JoinDTO joinDTO);
    MemberDTO memberInfo(String memberId) throws Exception;

    String login(LoginDTO loginDTO);
}
