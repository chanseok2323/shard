package com.chanseok.shard.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Member {
    @Id
    @Column(name = "user_no", length = 20, unique = true)
    private String no;
    private String email;
    private String name;
    private String password;
    private Integer age;

    protected Member() {
    }

    @Builder
    public Member(String no, String email, String name, String password, Integer age) {
        this.no = no;
        this.email = email;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
