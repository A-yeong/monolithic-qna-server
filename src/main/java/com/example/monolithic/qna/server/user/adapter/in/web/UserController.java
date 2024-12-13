package com.example.monolithic.qna.server.user.adapter.in.web;

import com.example.monolithic.qna.server.user.adapter.in.web.request.UserSignInRequest;
import com.example.monolithic.qna.server.user.adapter.in.web.response.MessageResponse;
import com.example.monolithic.qna.server.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b> 유저 컨트롤러 </b>
 * <p>
 * - 유저 정보 관리
 * </p>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/user/sign-in")
    public ResponseEntity<MessageResponse> signIn(@RequestBody UserSignInRequest body) {
        boolean signInSuccess = userService.signIn(body.getUserId(), body.getPw());

        if (!signInSuccess) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("로그인 실패 : 잘못된 ID 또는 비밀번호"));
        }
        return new ResponseEntity<>(new MessageResponse("로그인 성공"), HttpStatus.OK);
    }
}