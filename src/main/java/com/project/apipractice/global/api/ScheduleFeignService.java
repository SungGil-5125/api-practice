package com.project.apipractice.global.api;

import com.project.apipractice.domain.schedule.Schedule;
import com.project.apipractice.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleFeignService {
    private final ScheduleListFeign scheduleListFeign;
    private final ScheduleRepository scheduleRepository;

    public void executeAll() {

        ArrayList<Schedule> schedules = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        scheduleListFeign.execute("json", "F10", "7380292","20221019", "20221019")
                .getBody().getItems().forEach(it -> {

                    log.info(it.getSCHUL_NM());

                    Schedule schedule = Schedule.builder()
                            .schoolName(it.getSCHUL_NM())
                            .dish(it.getDDISH_NM())
                            .kcal(it.getCAL_INFO())
                            .build();

                    schedules.add(schedule);
                });

        scheduleRepository.saveAll(schedules);
    }


}
