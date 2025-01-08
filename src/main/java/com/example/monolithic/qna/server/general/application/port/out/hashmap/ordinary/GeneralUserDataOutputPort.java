package com.example.monolithic.qna.server.general.application.port.out.hashmap.ordinary;

/**
 * <b> 일반 유저 정보 관리 출력 포트 </b>
 */
public interface GeneralUserDataOutputPort {
    void saveGeneralUser(String userId, String email, int age);
}
