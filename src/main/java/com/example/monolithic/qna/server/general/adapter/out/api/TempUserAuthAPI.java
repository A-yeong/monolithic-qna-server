package com.example.monolithic.qna.server.general.adapter.out.api;

import com.example.monolithic.qna.server.user.adapter.in.other.UserAdapter;
import com.example.monolithic.qna.server.user.adapter.in.other.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <b> 회원관리 API 요청 </b>
 * <p>
 * - 빈 이름 충돌로 temp를 prefix로 작성
 * - 모듈 분리 시 expert의 UserAuthAPI 재사용 계획
 * </p>
 */
@Component
@RequiredArgsConstructor
public class TempUserAuthAPI {
    private final UserAdapter userInputAdapter;

    /**
     * <b> 회원가입을 다른 도메인에 요청 </b>
     *
     * @param userId 아이디
     * @param pw 비밀번호
     * @param role 역할
     * @return 응답
     */
    public String requestUserSignUp(String userId, String pw, String role) {
        MessageResponse messageResponse = userInputAdapter.signUp(SignUpDTO.to(userId, pw, role));
        return messageResponse.getResult();
    }
}
