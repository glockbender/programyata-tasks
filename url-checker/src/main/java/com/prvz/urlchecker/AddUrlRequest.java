package com.prvz.urlchecker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUrlRequest {

    public final String url;

    @JsonCreator
    public AddUrlRequest(
        @JsonProperty("url") String url
    ) {
        this.url = url;
    }
}
