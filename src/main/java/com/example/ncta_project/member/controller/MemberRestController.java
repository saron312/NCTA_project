package com.example.ncta_project.member.controller;

import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/idCheck")
    boolean duplicateMemberIdCheck(String memberId){
        return memberService.duplicateMemberIdCheck(memberId);
    }
}
