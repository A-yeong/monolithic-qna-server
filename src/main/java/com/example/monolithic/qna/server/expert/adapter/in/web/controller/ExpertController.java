package com.example.monolithic.qna.server.expert.adapter.in.web.controller;

import com.example.monolithic.qna.server.expert.adapter.in.web.dto.request.ExpertSignUpRequest;
import com.example.monolithic.qna.server.expert.adapter.in.web.dto.response.ExpertSignUpResponse;
import com.example.monolithic.qna.server.expert.application.service.ExpertUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <b> 전문가 유저 컨트롤러 </b>
 * <p>
 * - 전문가 유저 정보 관리 <br>
 * </p>
 */
@CrossOrigin(origins = "http://localhost:8077")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ExpertController {
    private final ExpertUserService expertService;

    @PostMapping("/v1/expert/sign-up")
    public ResponseEntity<ExpertSignUpResponse> signUp(@RequestBody ExpertSignUpRequest body) {
        boolean signUpSuccess = expertService.signUp(body.getUserId(), body.getPw(), body.getRole());

        if (signUpSuccess) {
            return ResponseEntity.ok(new ExpertSignUpResponse("회원가입 성공"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExpertSignUpResponse("회원가입 실패"));
    }
}
