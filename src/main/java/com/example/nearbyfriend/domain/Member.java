package com.example.nearbyfriend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String username;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> relationList;

    @Builder
    public Member(String username, List<String> relationList) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
        this.relationList = relationList;
    }
}
