package com.project.apipractice.global.api;

import com.project.apipractice.global.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "scheduleList", url = "https://open.neis.go.kr/hub/mealServiceDietInfo", configuration = FeignClientConfig.class)
public interface ScheduleListFeign {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ScheduleListResponse execute(
            @RequestParam(value = "Type") String Type,
            @RequestParam(value = "ATPT_OFCDC_SC_CODE") String ATPT_OFCDC_SC_CODE,
            @RequestParam(value = "SD_SCHUL_CODE") String SD_SCHUL_CODE,
            @RequestParam(value = "MLSV_FROM_YMD") String TI_FROM_YMD,
            @RequestParam(value = "MLSV_TO_YMD") String TI_TO_YMD
    );
}
