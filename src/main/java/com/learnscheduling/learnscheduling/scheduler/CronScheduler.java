package com.learnscheduling.learnscheduling.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CronScheduler {
    @Scheduled(cron= "0 */1 * * * *")
    public void runEveryMinute() {
        log.info("cron job running every minute");
    }
}
