package com.project.apipractice.global.api;

import com.project.apipractice.global.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "scheduleList", url = "https://open.neis.go.kr/hub/hisTimetable", configuration = FeignClientConfig.class)
public interface ScheduleListFeign {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ScheduleListResponse execute(
            @RequestParam(name = "Key") String key,
            @RequestParam(name="ATPT_OFCDC_SC_CODE") String cityCode,
            @RequestParam(name="SD_SCHUL_CODE") Integer schoolCode,
            @RequestParam(name = "AY") Integer year,
            @RequestParam(name = "SEM") Integer season,
            @RequestParam(name = "GRADE") Integer grade,
            @RequestParam(name = "CLRM_NM") Integer className,
            @RequestParam(name = "TI_FROM_YMD") Integer startDate,
            @RequestParam(name = "TI_TO_YMD") Integer endDate
    );
}
