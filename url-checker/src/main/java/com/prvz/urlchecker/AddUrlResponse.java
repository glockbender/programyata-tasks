package com.prvz.urlchecker;

import java.time.OffsetDateTime;

public class AddUrlResponse {

    public final String url;
    public final Integer periodMinutes;
    public final OffsetDateTime startAt;

    public AddUrlResponse(String url, Integer periodMinutes, OffsetDateTime startAt) {
        this.url = url;
        this.periodMinutes = periodMinutes;
        this.startAt = startAt;
    }
}
