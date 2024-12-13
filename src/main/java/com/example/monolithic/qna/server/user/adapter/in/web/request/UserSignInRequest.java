package com.example.monolithic.qna.server.user.adapter.in.web.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <b> 역할: 유저 로그인 요청 DTO </b>
 */
@Getter
@NoArgsConstructor
public class UserSignInRequest {
    private String userId;
    private String pw;

    public UserSignInRequest(String userId, String pw) {
        this.userId = userId;
        this.pw = pw;
    }
}