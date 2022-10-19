package com.project.apipractice.global.api;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleListResponse {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class Body {
        private ArrayList<Item> items;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {

        private String SCHUL_NM; // 학교명
        private String DDISH_NM; // 요리명
        private String CAL_INFO; // 칼로리 정보

    }

    private Body body;

}
