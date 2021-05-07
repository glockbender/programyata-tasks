package com.prvz.lesson4_4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

public class Binding {

    private final String id;

    private final URL longUrl;

    @JsonCreator
    public Binding(@JsonProperty("id") String id, @JsonProperty("longUrl") URL longUrl) {
        this.id = id;
        this.longUrl = longUrl;
    }

    public String getId() {
        return id;
    }

    public URL getLongUrl() {
        return longUrl;
    }
}
