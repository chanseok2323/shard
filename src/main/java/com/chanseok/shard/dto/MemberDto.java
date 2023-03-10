package com.chanseok.shard.dto;

import com.chanseok.shard.common.MemberIdentityGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private String no;
    private String email;
    private String name;
    private String password;
    private Integer age;

    public String generateMemberNo() {
        String userNo = getMemberNo();
        return userNo;
    }

    private String getMemberNo() {
        String userNo = MemberIdentityGenerator.generateUserIdentity();
        this.setNo(userNo);
        return userNo;
    }

    private void setNo(String no) {
        this.no = no;
    }

    @Builder
    public MemberDto(String no, String email, String name, String password, Integer age) {
        this.no = no;
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
