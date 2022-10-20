package com.project.apipractice.global.api;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleListResponse {

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Row {

        private String SCHUL_NM;
        private String ALL_TI_YMD;
        private String DDDEP_NM;
        private String GRADE;
        private String CLASS_NM;
        private String PERIO;
        private String ITRT_CNTNT;

    }


    private List<Row> row;
}
