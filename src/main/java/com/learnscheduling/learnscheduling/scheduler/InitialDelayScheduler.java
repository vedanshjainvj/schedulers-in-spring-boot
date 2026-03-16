package com.learnscheduling.learnscheduling.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitialDelayScheduler {

    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void startLater() {
        log.info("Scheduler started after delay");
    }
}
