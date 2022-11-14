package com.example.ncta_project.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinDTO {

    private String memberId;

    private String password;

    private String phoneNumber;

    private String email;
}
