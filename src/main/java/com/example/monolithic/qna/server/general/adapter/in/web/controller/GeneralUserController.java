package com.example.monolithic.qna.server.general.adapter.in.web.controller;

import com.example.monolithic.qna.server.general.adapter.in.web.dto.request.GeneralSignUpRequest;
import com.example.monolithic.qna.server.general.adapter.in.web.dto.response.GeneralSignUpResponse;
import com.example.monolithic.qna.server.general.application.port.in.web.GeneralUserDataInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b> 일반 유저 컨트롤러 </b>
 * <p>
 * - 일반 유저 정보 관리 <br>
 * </p>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GeneralUserController {
    private final GeneralUserDataInputPort generalService;

    @PostMapping("/v1/general/sign-up")
    public ResponseEntity<GeneralSignUpResponse> signUp(@RequestBody GeneralSignUpRequest body) {
        boolean signUpSuccess = generalService.signUp(body.getId(), body.getPw(), body.getRole());

        if (signUpSuccess) {
            return ResponseEntity.ok(new GeneralSignUpResponse("회원가입 성공"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GeneralSignUpResponse("회원가입 실패"));
    }
}
