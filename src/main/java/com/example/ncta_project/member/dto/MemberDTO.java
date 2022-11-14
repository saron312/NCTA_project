package com.example.ncta_project.member.dto;

import com.example.ncta_project.member.Member;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class MemberDTO {
    private String memberId;
    private String phoneNumber;
//    private List<String> email;
    private String email;

    public static MemberDTO fromEntity(Member member) {
        return MemberDTO.builder()
                .memberId(member.getMemberId())
                .phoneNumber(member.getPhoneNumber())
//                .email(Arrays.asList(member.getEmail().split("@")))
                .email(member.getEmail())
                .build();
    }
}
