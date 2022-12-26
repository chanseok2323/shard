package com.chanseok.shard.web;

import com.chanseok.shard.dto.MemberDto;
import com.chanseok.shard.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/save")
    public void save(@RequestBody MemberDto memberDto) {
        String userNo = memberDto.generateMemberNo();
        log.info("userNo = {}", userNo);
        memberService.save(userNo.substring(0, 1), memberDto);
    }
}
