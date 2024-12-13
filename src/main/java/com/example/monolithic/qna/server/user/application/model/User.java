package com.example.monolithic.qna.server.user.application.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private String id;
    private String userId;
    private String pw;
    private String role;

    private User(String userId, String pw, String role) {
        this.userId = userId;
        this.pw = pw;
        this.role = role;
    }

    public static User createUser(String userId, String pw, String role) {
        return new User(userId, pw, role);
    }

    public void save(String id) {
        this.id = id;
    }
}
