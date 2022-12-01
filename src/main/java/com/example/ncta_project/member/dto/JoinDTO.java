package com.example.ncta_project.member.dto;

import com.example.ncta_project.member.Member;
import com.example.ncta_project.member.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

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
    public Member toEntity(PasswordEncoder passwordEncoder){
        return Member.builder()
                .memberId(memberId)
                .password(passwordEncoder.encode(password))
                .phoneNumber(phoneNumber)
                .email(email.replace(",","@"))
                .role(Role.MEMBER)
                .build();
    }
}
