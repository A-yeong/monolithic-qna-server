package com.example.monolithic.qna.server.user.adapter.out.db;

import com.example.monolithic.qna.server.user.application.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> 유저 영속성 어댑터 </b>
 * <p>
 * - 유저의 아이디, 비밀번호, 역할만 관리하는 출력 어댑터
 * </p>
 */
@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter {
    private final Map<String, User> users = new HashMap<>();
    private int autoIncrement = 1;

    /**
     * <b> 유저의 정보 저장 </b>
     * <p>
     * - 아이디, 비밀번호, 역할만 저장
     * </p>
     */
    public void saveUser(User user) {
        if (users.containsKey(user.getId())) {
            users.replace(user.getId(), user);
            return;
        }
        String id = getStringId();
        users.put(id, user);
        user.save(id);

        autoIncrement++;
    }

    /**
     * <b> id로 유저가 존재하는지 확인 </b>
     * @return 조회한 유저 아이디를 가지고 있는 유저
     */
    public User findById(String id) {
        return users.get(id);
    }

    /**
     * <b> userId로 유저가 존재하는지 확인 </b>
     * @return 유저 존재 여부
     */
    public boolean existsById(String userId) {
        return users.values().stream()
                .anyMatch(user -> user.getUserId().equals(userId));
    }

    private String getStringId() {
        return String.valueOf(autoIncrement);
    }
}

