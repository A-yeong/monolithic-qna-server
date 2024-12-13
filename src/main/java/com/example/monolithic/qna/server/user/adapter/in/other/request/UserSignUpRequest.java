package com.example.monolithic.qna.server.user.adapter.in.other.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <b> 역할: 유저 회원가입 요청 DTO </b>
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequest {
    private String userId;
    private String pw;
    private String role;
}
