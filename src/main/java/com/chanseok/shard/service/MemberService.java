package com.chanseok.shard.service;

import com.chanseok.shard.config.Sharding;
import com.chanseok.shard.domain.Member;
import com.chanseok.shard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Sharding
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Optional<Member> findByUserNo(String userNo) {
        return memberRepository.findById(userNo);
    }

    @Transactional
    public void save(String userNo, Member member) {
        memberRepository.save(member);
    }
}
