package com.example.nearbyfriend.infrastructure.member;

import com.example.nearbyfriend.domain.member.Member;
import com.example.nearbyfriend.domain.member.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;
    @Override
    public Member store(Member member) {
        return memberRepository.save(member);
    }
}
