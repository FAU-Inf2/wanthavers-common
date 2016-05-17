package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Chat extends AbstractParseModel{
    private long user1;
    private long user2;
    private long desireId;


    @JsonProperty
    public long getUser1() {
        return user1;
    }

    public void setUser1(long user1) {
        this.user1 = user1;
    }

    @JsonProperty
    public long getUser2() {
        return user2;
    }

    public void setUser2(long user2) {
        this.user2 = user2;
    }

    @JsonProperty
    public long getDesireId() {
        return desireId;
    }

    public void setDesireId(long desireId) {
        this.desireId = desireId;
    }


}