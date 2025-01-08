package com.example.monolithic.qna.server.expert.adapter.out.api;

import com.example.monolithic.qna.server.user.adapter.in.other.request.UserSignUpRequest;

/**
 * <b> 회원가입 DTO </b>
 */
public record SignUpDTO(String userId, String pw, String role) {
    public static UserSignUpRequest to(String userId, String pw, String role) {
        return new UserSignUpRequest(userId, pw, role);
    }
}
