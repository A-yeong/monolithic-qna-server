package com.example.monolithic.qna.server.general.application.service;

import com.example.monolithic.qna.server.general.adapter.out.api.UserAuthAPI;
import com.example.monolithic.qna.server.general.application.port.in.web.GeneralUserDataInputPort;
import com.example.monolithic.qna.server.general.application.port.out.hashmap.ordinary.GeneralUserDataOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b> 일반 유저 서비스 </b>
 */
@Service
@RequiredArgsConstructor
public class GeneralUserService implements GeneralUserDataInputPort {
    private static final Logger logger = Logger.getLogger(GeneralUserService.class.getName());

    private final UserAuthAPI userAuthAPI;
    private final GeneralUserDataOutputPort persistenceAdapter;

    /**
     * <b> 일반 유저 회원가입 로직 수행 </b>
     *
     * @param id 아이디
     * @param pw 비밀번호
     * @param role 역할
     * @return 회원가입 성공 여부
     */
    public boolean signUp(String id, String pw, String role) {
        // User 도메인에 회원가입 요청
        final String response = userAuthAPI.requestUserSignUp(id, pw, role);

        // User 도메인 응답에 따라 처리
        if (response.equals("회원가입 성공")) {
            persistenceAdapter.saveGeneralUser(id, "email", 19);
            return true;
        } else {
            logger.log(Level.WARNING, "회원가입 실패, 메시지: " + response);
            return false;
        }
    }
}
