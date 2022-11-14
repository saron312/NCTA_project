package com.example.ncta_project.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private String memberId;
    private String phoneNumber;
    private String email;
}
