package com.example.ncta_project;

import com.example.ncta_project.member.Member;
import com.example.ncta_project.member.dto.JoinDTO;
import com.example.ncta_project.member.dto.LoginDTO;
import com.example.ncta_project.member.dto.MemberDTO;
import com.example.ncta_project.member.repository.MemberRepository;
import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
@SessionAttributes("memberId")

public class HomeController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index(){return "index";}

    @PostMapping("/")
    public String checkLogin(@ModelAttribute("memberId")String memberId, Model model){
        if(memberId == null) {
            model.addAttribute("memberId", null);
        }else{
            model.addAttribute("memberId",memberId);
        }
        return "index";
    }

    //로그인 및 로그아웃
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

//    @PostMapping("/login")
//    public String login(LoginDTO loginDTO, Model model){
//        MemberDTO memberDTO = memberService.login(loginDTO.getMemberId(),loginDTO.getMemberId());
//
//        if(!member.isPresent()){
//            model.addAttribute("error","존재하지 않는 아이디입니다.");
//            return "/login";
//        }
//        if(!member.get().getPassword().equals(password)) {
//            model.addAttribute("error", "아이디와 비밀번호가 일치하지 않습니다.");
//            return "/login";
//        }
//        model.addAttribute("memberId",member.get().getMemberId());
//        return "redirect:/";
//    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }


    //회원가입
    @GetMapping("/join")
    public String joinPage(){
        return "join";
    }

    @PostMapping("/join")
    public String joinSuccess(JoinDTO joinDTO){
        memberService.join(joinDTO);
        return "login";
    }


}
