package com.project.apipractice.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "api.key")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ScheduleApiProperties {

    private String key;
}
