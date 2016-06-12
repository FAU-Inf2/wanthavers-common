package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Message extends AbstractParseModel {
    private long from;
    private String body;

    @JsonProperty
    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    @JsonProperty
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}