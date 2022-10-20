package com.project.apipractice.global.api;

import com.project.apipractice.domain.schedule.Schedule;
import com.project.apipractice.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Event.F10;

@Log4j2
@Component
@RequiredArgsConstructor
public class ScheduleFeignService {
    private final ScheduleListFeign scheduleListFeign;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void executeAll() {

        List<Schedule> schedules = new ArrayList<>();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        scheduleListFeign.execute(
                "bd0702be7c1f4a45a571e9841a86010d", "F10", 7380292, 2022, 2, 2, 3, 20221020, 20221020
        ).getRow().forEach(it -> {
            Schedule schedule = Schedule.builder()
                    .schoolName(it.getSCHUL_NM())
                    .date(LocalDate.parse(it.getALL_TI_YMD(), formatter))
                    .department(it.getDDDEP_NM())
                    .grade(it.getGRADE())
                    .className(it.getCLASS_NM())
                    .period(it.getPERIO())
                    .subject(it.getITRT_CNTNT())
                    .build();

            schedules.add(schedule);
        });

        scheduleRepository.saveAll(schedules);


    }






}
