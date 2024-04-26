package com.example.nearbyfriend.infrastructure.member;

import com.example.nearbyfriend.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
