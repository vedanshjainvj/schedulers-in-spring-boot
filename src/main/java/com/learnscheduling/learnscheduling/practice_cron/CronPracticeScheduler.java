package com.learnscheduling.learnscheduling.practice_cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class CronPracticeScheduler {

    @Scheduled(cron = "0 * * * * *")
    public void everyMinute() {
        // Runs every minute at second 0
        log.info("everyMinute {}", LocalDateTime.now());
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void every10Seconds() {
        // Runs every 10 seconds
        log.info("every10Seconds {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void every5Minutes() {
        // Runs every 5 minutes
        log.info("every5Minutes {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 * * * *")
    public void everyHour() {
        // Runs at the start of every hour
        log.info("everyHour {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 30 * * * *")
    public void everyHourAt30Minutes() {
        // Runs every hour at minute 30
        log.info("everyHourAt30Minutes {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void everyDay9AM() {
        // Runs every day at 9 AM
        log.info("everyDay9AM {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void everyDayNoon() {
        // Runs every day at 12 PM
        log.info("everyDayNoon {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void midnightJob() {
        // Runs every day at midnight
        log.info("midnightJob {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 15 10 * * *")
    public void everyDay1015AM() {
        // Runs every day at 10:15 AM
        log.info("everyDay1015AM {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 8 * * MON-FRI")
    public void weekdayMorningJob() {
        // Runs every weekday at 8 AM
        log.info("weekdayMorningJob {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 10 * * MON")
    public void everyMonday10AM() {
        // Runs every Monday at 10 AM
        log.info("everyMonday10AM {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 10 ? * TUE")
    public void everyTuesday10AM() {
        // Runs every Tuesday at 10 AM
        log.info("everyTuesday10AM {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 1 * *")
    public void firstDayOfMonth() {
        // Runs at 9 AM on the first day of every month
        log.info("firstDayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 0 L * *")
    public void lastDayOfMonth() {
        // Runs at midnight on the last day of every month
        log.info("lastDayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 15 * *")
    public void fifteenthDayOfMonth() {
        // Runs at 9 AM on the 15th of every month
        log.info("fifteenthDayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 15W * *")
    public void nearestWeekdayTo15() {
        // Runs at 9 AM on the weekday closest to the 15th
        log.info("nearestWeekdayTo15 {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 ? * MON#1")
    public void firstMondayOfMonth() {
        // Runs at 9 AM on the first Monday of every month
        log.info("firstMondayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 ? * MON#2")
    public void secondMondayOfMonth() {
        // Runs at 9 AM on the second Monday of every month
        log.info("secondMondayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 ? * MON#3")
    public void thirdMondayOfMonth() {
        // Runs at 9 AM on the third Monday of every month
        log.info("thirdMondayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 ? * MON#4")
    public void fourthMondayOfMonth() {
        // Runs at 9 AM on the fourth Monday of every month
        log.info("fourthMondayOfMonth {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 * JAN *")
    public void everyDayInJanuary() {
        // Runs every day at 9 AM during January
        log.info("everyDayInJanuary {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 1 JAN *")
    public void newYearMorning() {
        // Runs at 9 AM on January 1st
        log.info("newYearMorning {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 18 * * MON-FRI")
    public void weekdayEveningJob() {
        // Runs every weekday at 6 PM
        log.info("weekdayEveningJob {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 */15 * * * *")
    public void every15Minutes() {
        // Runs every 15 minutes
        log.info("every15Minutes {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0/30 * * * *")
    public void every30Minutes() {
        // Runs every 30 minutes
        log.info("every30Minutes {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9-17 * * MON-FRI")
    public void businessHoursJob() {
        // Runs every hour from 9 AM to 5 PM on weekdays
        log.info("businessHoursJob {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 3 * * *", zone = "UTC")
    public void utcThreeAM() {
        // Runs every day at 3 AM UTC
        log.info("utcThreeAM {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 3 * * *", zone = "Asia/Kolkata")
    public void istThreeAM() {
        // Runs every day at 3 AM in Asia/Kolkata timezone
        log.info("istThreeAM {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 0 1 */3 *")
    public void everyQuarterStart() {
        // Runs at midnight on the first day of every 3rd month
        log.info("everyQuarterStart {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 23 * * SUN")
    public void sundayNightJob() {
        // Runs every Sunday at 11 PM
        log.info("sundayNightJob {}", LocalDateTime.now());
    }

}