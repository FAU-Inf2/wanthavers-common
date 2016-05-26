package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Chat extends AbstractParseModel implements Serializable {
    private long user1;
    private long user2;
    private long desireId;

    private User userObject1;
    private User userObject2;
    private Desire desire;


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

    @JsonProperty
    public User getUserObject1() {
        return userObject1;
    }

    public void setUserObject1(User userObject1) {
        this.userObject1 = userObject1;
    }

    @JsonProperty
    public User getUserObject2() {
        return userObject2;
    }

    public void setUserObject2(User userObject2) {
        this.userObject2 = userObject2;
    }

    @JsonProperty
    public Desire getDesire() {
        return desire;
    }

    public void setDesire(Desire desire) {
        this.desire = desire;
    }
}