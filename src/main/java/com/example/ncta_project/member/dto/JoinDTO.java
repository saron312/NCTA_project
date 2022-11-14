package com.example.ncta_project.member.dto;

import com.example.ncta_project.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class JoinDTO {
    @NotBlank
    private String memberId;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .phoneNumber(phoneNumber)
                .email(email.replace(",","@"))
                .build();
    }
}
