package com.example.ncta_project.member.service;

import com.example.ncta_project.member.dto.JoinDTO;
import com.example.ncta_project.member.dto.MemberDTO;
import com.example.ncta_project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Override
    public boolean duplicateMemberIdCheck(String memberId) {
        return memberRepository.existsById(memberId);
    }

    @Override
    public MemberDTO memberInfo(String memberId) {
        return null;
    }

    @Override
    public void join(JoinDTO joinDTO) {
//        Member member = Member.builder().memberId(joinDTO.getMemberId()).password(password).email(email).phoneNumber(phoneNumber).build();
//        memberRepository.save(member);
    }


}
