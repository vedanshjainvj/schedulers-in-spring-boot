package com.learnscheduling.learnscheduling.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FixedRateScheduler {

    @Scheduled(fixedRate = 5000)
    public void processTask() throws InterruptedException {
        log.info("Task started");
        Thread.sleep(7000);
        log.info("Task finished");
    }
}
