package com.prvz.urlchecker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public class AddUrlRequest {

    public final String url;
    public final Integer periodMinutes;
    @Nullable
    public final OffsetDateTime startAt;

    @JsonCreator
    public AddUrlRequest(
        @JsonProperty("url") String url,
        @JsonProperty("periodMinutes") Integer periodMinutes,
        @JsonProperty("startAt") @Nullable OffsetDateTime startAt
    ) {
        this.url = url;
        this.periodMinutes = periodMinutes;
        this.startAt = startAt;
    }
}