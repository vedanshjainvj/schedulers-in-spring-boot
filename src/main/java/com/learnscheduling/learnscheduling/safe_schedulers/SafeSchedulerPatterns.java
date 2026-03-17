package com.learnscheduling.learnscheduling.safe_schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
public class SafeSchedulerPatterns {

    private final AtomicBoolean lock = new AtomicBoolean(false);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    // ==============================
    // 1. FIXED DELAY (SAFE DEFAULT)
    // ==============================
    @Scheduled(fixedDelay = 10000)
    public void fixedDelaySafeJob() {
        // Runs after previous execution completes + 10s delay (no overlap)

        long start = System.currentTimeMillis();

        log.info("fixedDelaySafeJob START on {}", Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long duration = System.currentTimeMillis() - start;
        log.info("fixedDelaySafeJob END duration={}ms", duration);
    }

    // ==============================
    // 2. PREVENT OVERLAP (LOCK)
    // ==============================
    @Scheduled(fixedRate = 5000)
    public void nonOverlappingJob() {
        // Ensures only one execution at a time using AtomicBoolean lock

        if (!lock.compareAndSet(false, true)) {
            log.warn("nonOverlappingJob SKIPPED (already running)");
            return;
        }

        try {
            log.info("nonOverlappingJob START");

            Thread.sleep(8000);

            log.info("nonOverlappingJob END");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.set(false);
        }
    }

    // ==============================
    // 3. IDEMPOTENT JOB SIMULATION
    // ==============================
    @Scheduled(cron = "0 */1 * * * *")
    public void idempotentJob() {
        // Safe to run multiple times (simulating idempotent behavior)

        log.info("idempotentJob START");

        // Simulating DB-safe update
        log.info("Updating records WHERE status=PENDING → COMPLETED");

        log.info("idempotentJob END");
    }

    // ==============================
    // 4. BATCH PROCESSING
    // ==============================
    @Scheduled(fixedDelay = 20000)
    public void batchProcessingJob() {
        // Processes data in chunks instead of loading everything at once

        log.info("batchProcessingJob START");

        int batchSize = 5;

        while (true) {

            List<Integer> batch = fetchBatch(batchSize);

            if (batch.isEmpty()) {
                break;
            }

            processBatch(batch);
        }

        log.info("batchProcessingJob END");
    }

    private List<Integer> fetchBatch(int size) {
        // Simulated batch fetch (replace with DB call)
        return List.of(1, 2, 3);
    }

    private void processBatch(List<Integer> batch) {
        log.info("Processing batch: {}", batch);
    }

    // ==============================
    // 5. FAILURE HANDLING
    // ==============================
    @Scheduled(fixedDelay = 15000)
    public void failureHandlingJob() {
        // Proper try-catch to prevent scheduler crash

        log.info("failureHandlingJob START");

        try {

            simulateFailure();

        } catch (Exception e) {
            log.error("failureHandlingJob FAILED", e);
        }

        log.info("failureHandlingJob END");
    }

    private void simulateFailure() {
        throw new RuntimeException("Simulated failure");
    }

    // ==============================
    // 6. TIMEOUT HANDLING
    // ==============================
    @Scheduled(fixedDelay = 20000)
    public void timeoutProtectedJob() {
        // Cancels job if it exceeds allowed time

        log.info("timeoutProtectedJob START");

        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        try {
            future.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            log.error("timeoutProtectedJob TIMEOUT - cancelling task");
            future.cancel(true);
        } catch (Exception e) {
            log.error("timeoutProtectedJob ERROR", e);
        }

        log.info("timeoutProtectedJob END");
    }

    // ==============================
    // 7. METRICS / DURATION TRACKING
    // ==============================
    @Scheduled(fixedDelay = 12000)
    public void metricsJob() {
        // Tracks execution time for monitoring

        long start = System.currentTimeMillis();

        log.info("metricsJob START");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long duration = System.currentTimeMillis() - start;

        log.info("metricsJob END duration={}ms", duration);
    }

}