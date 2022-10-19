package com.project.apipractice.domain.schedule.repository;

import com.project.apipractice.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
