package com.prvz.urlchecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
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

        OffsetDateTime now = OffsetDateTime.now();

        List<AddUrlResponse> responseList = repository.findAllByNextCheckAtBefore(now);
        for (AddUrlResponse response : responseList) {
            try {
                boolean checkResult = checkUrlByStatus(new URL(response.url));


                if (checkResult) {
                 // TODO
                }
            } catch (MalformedURLException e) {
                logger.error("Unexpected error. Url string is incorrect", e);
            }
        }

        logger.debug("Start urls checking at: {}", now);
    }

    private boolean checkUrlByStatus(URL url) {
        logger.debug("CHECKING URL: {}", url);
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            boolean ok = false;
            try {
                conn.setRequestMethod("GET");
                conn.connect();
                conn.setConnectTimeout(500);
                conn.setReadTimeout(500);
                int status = conn.getResponseCode();
                logger.debug("RESPONSE STATUS: {} URL: {}", status, url);
                if (status >= 200 && status < 400) {
                    ok = true;
                }
            } catch (UnknownHostException ex) {
                logger.debug("UNKNOWN HOST: {}", url);
            } finally {
                conn.disconnect();
                logger.debug("CONNECTION TO URL: {} DISCONNECTED", url);
            }
            return ok;
        } catch (Throwable ex) {
            logger.warn("Oops! Something went wrong =((", ex);
            return false;
        }
    }
}
