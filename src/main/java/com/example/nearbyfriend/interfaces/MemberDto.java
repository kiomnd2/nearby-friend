package com.example.nearbyfriend.interfaces;

import com.example.nearbyfriend.domain.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class MemberDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterMember {
        private String username;
        private List<String> friendsList;

        public Member toEntity() {
            return Member.builder()
                    .username(username)
                    .relationList(friendsList)
                    .build();
        }
    }
}
