package com.example.ncta_project.member.controller;

import com.example.ncta_project.member.dto.JoinDTO;
import com.example.ncta_project.member.dto.LoginDTO;
import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@SessionAttributes("memberId")
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(@ModelAttribute("memberId") String memberId, Model model) {
        model.addAttribute("memberId", memberId);
        return "index";
    }

    //로그인 및 로그아웃
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "아이디 또는 비밀번호를 정확하게 입력해주세요.");
            return "login";
        }
        if (memberService.login(loginDTO) == "0") {
            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "login";
        }
        model.addAttribute("memberId", memberService.login(loginDTO));
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }


    //회원가입
    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/join")
    public String joinSuccess(@Valid JoinDTO joinDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/join";
        }
        memberService.join(joinDTO);
        return "login";
    }

    @GetMapping("/myInfo")
    public String info(@ModelAttribute("memberId") String memberId, Model model) throws Exception {
        model.addAttribute("memberDTO", memberService.memberInfo(memberId));
        return "memberInfo";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(@ModelAttribute("memberId") String memberId, SessionStatus status) {
        memberService.deleteMember(memberId);
        status.setComplete();
        return "redirect:/";
    }


}
