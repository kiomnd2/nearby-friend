package com.example.nearbyfriend.interfaces.member;

import com.example.nearbyfriend.domain.member.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberStore memberStore;

    public void registerMember(@RequestBody MemberDto.RegisterMember registerMember) {
        memberStore.store(registerMember.toEntity());
    }
}
