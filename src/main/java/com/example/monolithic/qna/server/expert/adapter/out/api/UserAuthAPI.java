package com.example.monolithic.qna.server.expert.adapter.out.api;

import com.example.monolithic.qna.server.user.adapter.in.other.UserAdapter;
import com.example.monolithic.qna.server.user.adapter.in.other.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <b> 회원관리 API 요청 </b>
 */
@RequiredArgsConstructor
@Component
public class UserAuthAPI {
    private final UserAdapter userInputAdapter;

    /**
     * <b> 회원가입을 다른 도메인에 요청 </b>
     *
     * @param id 아이디
     * @param pw 비밀번호
     * @param role 역할
     * @return 응답
     */
    public String requestUserSignUp(String id, String pw, String role) {
        MessageResponse messageResponse = userInputAdapter.signUp(SignUpDTO.to(id, pw, role));
        return messageResponse.getResult();
    }
}
