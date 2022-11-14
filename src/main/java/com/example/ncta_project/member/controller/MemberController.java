package com.example.ncta_project.member.controller;

import com.example.ncta_project.member.Member;
import com.example.ncta_project.member.repository.MemberRepository;
import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@SessionAttributes("memberId")
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;


    @GetMapping("memberInfo")
    public String memberInfo(@ModelAttribute("memberId") String memberId, Model model){
        Member member = memberRepository.findById(memberId).get();
        model.addAttribute("memberId",memberId);
        model.addAttribute("memberEmail",member.getEmail());
        model.addAttribute("memberPhoneNumber",member.getPhoneNumber());
        return "memberInfo";
    }
}
