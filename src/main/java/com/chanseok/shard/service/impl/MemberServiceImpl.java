package com.chanseok.shard.service.impl;

import com.chanseok.shard.config.Sharding;
import com.chanseok.shard.domain.Member;
import com.chanseok.shard.dto.MemberDto;
import com.chanseok.shard.dto.repository.MemberRepository;
import com.chanseok.shard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Sharding
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> findByUserNo(String userNo) {
        return memberRepository.findById(userNo);
    }

    @Transactional
    public void save(String userNo, MemberDto memberDto) {
        Member member = Member.builder()
                .no(memberDto.getNo())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .age(memberDto.getAge())
                .build();
        memberRepository.save(member);
    }
}
