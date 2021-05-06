package com.prvz.lesson4_4.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.time.LocalDateTime;

public class IdToUrlBinding {

    @NotNull
    private final String id;

    @NotNull
    private final URL longUrl;

    @NotNull
    private final LocalDateTime createdAt;

    @JsonCreator
    public IdToUrlBinding(
        @JsonProperty("id") @NotNull String id,
        @JsonProperty("longUrl") @NotNull URL longUrl,
        @JsonProperty("createdAt") @NotNull LocalDateTime createdAt
    ) {
        this.id = id;
        this.longUrl = longUrl;
        this.createdAt = createdAt;
    }

    public @NotNull String getId() {
        return id;
    }

    public @NotNull URL getLongUrl() {
        return longUrl;
    }

    public @NotNull LocalDateTime getCreatedAt() {
        return createdAt;
    }


}
