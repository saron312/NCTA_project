package com.example.ncta_project.member.service;

import com.example.ncta_project.member.dto.JoinDTO;
import com.example.ncta_project.member.dto.MemberDTO;
import com.example.ncta_project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean duplicateMemberIdCheck(String memberId) {return memberRepository.existsById(memberId);}

    @Override
    public void join(JoinDTO joinDTO){memberRepository.save(joinDTO.toEntity(passwordEncoder));}

    @Override
    public MemberDTO memberInfo(String memberId) throws Exception {
        return MemberDTO.fromEntity(memberRepository.findById(memberId)
                        .orElseThrow(() -> new Exception(memberId + " -> 데이터베이스에서 찾을 수 없습니다.")));
    }
    @Override
    public boolean passwordCheck(String memberId, String password){
        return passwordEncoder.matches(password,memberRepository.passwordCheck(memberId));
    }

    @Override
    public void deleteMember(String memberId) {memberRepository.deleteById(memberId);}
}
