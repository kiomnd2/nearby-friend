package com.example.nearbyfriend.domain.member;

import java.util.List;

public interface MemberReader {
    List<String> readMemberFriends(String userId);
}
