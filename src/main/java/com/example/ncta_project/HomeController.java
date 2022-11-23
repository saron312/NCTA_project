package com.example.ncta_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/informIntroduce")
    public String informIntroducePage(){
        return "/informIntroduce";
    }

    @GetMapping("/electricIntroduce")
    public String electricIntroducePage(){
        return "/electricIntroduce";
    }
}
