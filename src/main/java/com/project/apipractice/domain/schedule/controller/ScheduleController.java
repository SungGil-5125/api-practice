package com.project.apipractice.domain.schedule.controller;

import com.project.apipractice.global.api.ScheduleFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleFeignService scheduleFeignService;

    @GetMapping()
    public String execute() {
        scheduleFeignService.executeAll();
        return "성공";
    }
}
