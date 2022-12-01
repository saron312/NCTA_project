package com.example.ncta_project.member.controller;

import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/myInfo")
    public String info(Principal principal, Model model) throws Exception {
        model.addAttribute("memberDTO", memberService.memberInfo(principal.getName()));
        return "memberInfo";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(Principal principal) {
        memberService.deleteMember(principal.getName());
        return "redirect:/logout";
    }


}
