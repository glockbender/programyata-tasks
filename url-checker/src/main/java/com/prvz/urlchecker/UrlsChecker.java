package com.prvz.urlchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UrlsChecker {

    private static final Logger logger = LoggerFactory.getLogger(UrlsChecker.class);

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private final UrlsRepository repository;

    public UrlsChecker(
        UrlsRepository repository,
        AppProperties appProperties
    ) {
        this.repository = repository;

        executorService.scheduleAtFixedRate(
            this::check,
            appProperties.checker.startDelaySeconds,
            appProperties.checker.periodSeconds,
            TimeUnit.SECONDS
        );
    }

    private void check() {

        Instant now = Instant.now();

        logger.debug("Start urls checking at: {}", now);
    }
}
