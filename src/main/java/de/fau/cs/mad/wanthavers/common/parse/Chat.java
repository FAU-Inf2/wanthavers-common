package de.fau.cs.mad.wanthavers.common.parse;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Chat")
public class Chat extends ParseObject {
    private String user1      = "user1";
    private String user2      = "user2";
    private String desireId   = "desireId";


    public void setUser1(Long value) {
        put(this.user1, value);
    }

    @JsonProperty
    public Long getUser1() {
        return getLong(this.user1);
    }

    public void setUser2(Long value) {
        put(this.user2, value);
    }

    @JsonProperty
    public Long getUser2() {
        return getLong(this.user2);
    }

    public void setDesireId(Long value) {
        put(this.desireId, value);
    }

    @JsonProperty
    public Long getDesireId() {
        return getLong(this.desireId);
    }


}