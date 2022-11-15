package com.example.ncta_project.member.controller;

import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequiredArgsConstructor
@SessionAttributes("memberId")
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/idCheck")
    boolean duplicateMemberIdCheck(String memberId){return memberService.duplicateMemberIdCheck(memberId);}

    @PostMapping("/pwCheck")
    boolean passwordCheck(@ModelAttribute("memberId") String memberId, String password){
        return memberService.passwordCheck(memberId, password);
    }
}
