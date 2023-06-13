package com.example.ncta_project;

import com.example.ncta_project.member.dto.JoinDTO;
import com.example.ncta_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index() {return "index";}

    @GetMapping("/login")
    public String loginPage(Principal principal) {
        if(principal != null) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/join")
    public String joinPage(Principal principal) {
        if(principal != null) {
            return "redirect:/";
        }
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

    @GetMapping("/informIntroduce")
    public String informIntroducePage(){
        return "/informIntroduce";
    }

    @GetMapping("/electricIntroduce")
    public String electricIntroducePage(){
        return "/electricIntroduce";
    }


}
