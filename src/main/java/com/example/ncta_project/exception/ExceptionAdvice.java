package com.example.ncta_project.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    @ExceptionHandler(HttpSessionRequiredException.class)
    public Object loginException(Exception e, Model model) {
        System.err.println(e.getClass());
        model.addAttribute("memberId","0");
        return "index";
    }
}
