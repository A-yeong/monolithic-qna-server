package com.example.monolithic.qna.server.user.application.service;

import com.example.monolithic.qna.server.user.adapter.out.db.UserPersistenceAdapter;
import com.example.monolithic.qna.server.user.application.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b> 유저 서비스 </b>
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    private final UserPersistenceAdapter persistenceAdapter;

    /**
     * <b> 유저 회원가입 로직 수행 </b>
     *
     * @param userId 유저 아이디
     * @param pw 비밀번호
     * @param role 역할
     * @return 회원가입 성공 여부
     */
    public boolean signUp(String userId, String pw, String role) {
        if (persistenceAdapter.existsById(userId)) {
            logger.log(Level.WARNING, "회원가입 실패");
            return false;
        }
        User user = User.createUser(userId, pw, role);
        persistenceAdapter.saveUser(user);
        return true;
    }

    /**
     * <b> 유저 로그인 로직 수행 </b>
     *
     * @param userId 유저 아이디
     * @param pw 비밀번호
     * @return 로그인 성공 여부
     */
    public boolean signIn(String userId, String pw) {
        User user = persistenceAdapter.findById(userId);
        if (user == null || !user.getPw().equals(pw)) {
            logger.log(Level.WARNING, "로그인 실패 : 잘못된 ID 또는 비밀번호");
            return false;
        }
        return true;
    }
}
