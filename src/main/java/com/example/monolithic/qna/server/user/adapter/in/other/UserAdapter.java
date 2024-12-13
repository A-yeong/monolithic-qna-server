package com.example.monolithic.qna.server.user.adapter.in.other;

import com.example.monolithic.qna.server.user.adapter.in.other.request.UserSignUpRequest;
import com.example.monolithic.qna.server.user.adapter.in.other.response.MessageResponse;
import com.example.monolithic.qna.server.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <b> 유저 입력 어댑터 </b>
 * <p>
 * - 유저 정보 관리
 * </p>
 */
@RequiredArgsConstructor
@Component
public class UserAdapter {
    private final UserService userService;

    public MessageResponse signUp(UserSignUpRequest body) {
        boolean signUpSuccess = userService.signUp(body.getUserId(), body.getPw(), body.getRole());

        if (!signUpSuccess) {
            return new MessageResponse("회원가입 실패");
        }
        return new MessageResponse("회원가입 성공");
    }
}
