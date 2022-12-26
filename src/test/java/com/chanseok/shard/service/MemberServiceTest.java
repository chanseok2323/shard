package com.chanseok.shard.service;

import com.chanseok.shard.common.MemberIdentityGenerator;
import com.chanseok.shard.domain.Member;
import com.chanseok.shard.dto.MemberDto;
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

    @Test
    void saveMember() {
        String userNo = MemberIdentityGenerator.generateUserIdentity();
        MemberDto memberDto = MemberDto.builder()
                .no(userNo)
                .email("chanseok2323@gmail.com")
                .name("test111122")
                .password("qq12345")
                .age(30)
                .build();

        memberService.save(memberDto.getNo(), memberDto);

        Member findMember = memberService.findByUserNo(userNo).get();

        Assertions.assertThat(memberDto.getNo()).isEqualTo(findMember.getNo());
    }

}