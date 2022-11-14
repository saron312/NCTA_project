package com.example.ncta_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("memberId")
@Controller
public class IntroduceController {

    @GetMapping("/informIntroduce")
    public String informIntroducePage(){
        return "/informIntroduce";
    }

    @GetMapping("/electricIntroduce")
    public String electricIntroducePage(){
        return "/electricIntroduce";
    }
}
