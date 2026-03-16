package com.learnscheduling.learnscheduling.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FixedDelayScheduler {

    @Scheduled(fixedDelay = 2000)
    public void runTask() throws InterruptedException {

        log.info("Job started");
        Thread.sleep(3000);
        log.info("Job finished");

    }
}