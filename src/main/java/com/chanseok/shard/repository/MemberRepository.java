package com.chanseok.shard.repository;

import com.chanseok.shard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Member findMemberByName(String name);
}
