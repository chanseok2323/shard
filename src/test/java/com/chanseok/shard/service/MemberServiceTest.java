package com.chanseok.shard.service;

import com.chanseok.shard.config.UserContextHolder;
import com.chanseok.shard.domain.Member;
import com.chanseok.shard.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveMember() {
        Member member = Member.builder().email("chanseok2323@gmail.com")
                .name("chanseok")
                .password("qq12345")
                .age(30)
                .build();

        System.out.println(member.getNo());

        memberRepository.save(member);

        Member findMember = memberRepository.findMemberByName("chanseok");

        Assertions.assertThat(member.getNo()).isEqualTo(findMember.getNo());
    }

}