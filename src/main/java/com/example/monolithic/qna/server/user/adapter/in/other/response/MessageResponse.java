package com.example.monolithic.qna.server.user.adapter.in.other.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b> 역할: 유저 회원가입 응답 </b>
 */
@Getter
@Setter
@NoArgsConstructor
public class MessageResponse {
    private String result;

    public MessageResponse(String result) {
        this.result = result;
    }
}
