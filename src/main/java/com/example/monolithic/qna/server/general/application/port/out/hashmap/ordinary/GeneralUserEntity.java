package com.example.monolithic.qna.server.general.application.port.out.hashmap.ordinary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> HashMap을 위한 GeneralUser Entity </b>
 */
@Getter
@Setter
@AllArgsConstructor
public class GeneralUserEntity {
    private String email;
    private int age;
}
