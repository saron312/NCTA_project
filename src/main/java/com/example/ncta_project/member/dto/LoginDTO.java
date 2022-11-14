package com.example.ncta_project.member.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LoginDTO {

    @NotBlank
    private String memberId;

    @NotBlank
    private String password;
}
