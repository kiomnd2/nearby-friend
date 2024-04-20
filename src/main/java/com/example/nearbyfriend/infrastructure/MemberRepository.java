package com.example.nearbyfriend.infrastructure;

import com.example.nearbyfriend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
