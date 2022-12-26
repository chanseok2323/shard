package com.chanseok.shard.service;

import com.chanseok.shard.domain.Member;
import com.chanseok.shard.dto.MemberDto;

import java.util.Optional;


public interface MemberService {
    Optional<Member> findByUserNo(String userNo);
    void save(String userNo, MemberDto memberDto);
}
