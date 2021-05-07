package com.prvz.urlchecker;

import java.time.OffsetDateTime;

public class AddUrlResponse {

    public final String url;
    public final Integer periodMinutes;
    public final OffsetDateTime nextCheckAt;

    public AddUrlResponse(String url, Integer periodMinutes, OffsetDateTime nextCheckAt) {
        this.url = url;
        this.periodMinutes = periodMinutes;
        this.nextCheckAt = nextCheckAt;
    }
}
