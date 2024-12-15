package com.example.monolithic.qna.server.expert.adapter.out.api;

import com.example.monolithic.qna.server.user.adapter.in.other.request.UserSignUpRequest;

/**
 * <b> 회원가입 DTO </b>
 */
public record SignUpDTO(String id, String pw, String role) {
    public static UserSignUpRequest to(String id, String pw, String role) {
        return new UserSignUpRequest(id, pw, role);
    }
}
