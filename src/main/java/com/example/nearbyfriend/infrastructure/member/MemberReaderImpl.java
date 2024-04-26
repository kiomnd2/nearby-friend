package com.example.nearbyfriend.infrastructure.member;

import com.example.nearbyfriend.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;
    @Override
    public List<String> readMemberFriends(String userId) {
        return memberRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("찾을 수 없음."))
                .getRelationList();
    }
}
