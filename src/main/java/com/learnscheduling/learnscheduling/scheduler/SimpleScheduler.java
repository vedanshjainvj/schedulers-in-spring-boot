package com.learnscheduling.learnscheduling.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class SimpleScheduler {

    @Scheduled(fixedRate = 5000)
    public void runJob() {
        log.info("Job running at {}", LocalDateTime.now());
    }

}