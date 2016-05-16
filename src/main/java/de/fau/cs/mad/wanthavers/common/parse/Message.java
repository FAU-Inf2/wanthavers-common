package de.fau.cs.mad.wanthavers.common.parse;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Message")
public class Message extends ParseObject {

    private String from      = "from";
    private String chatId    = "chatId";
    private String body      = "body";

    public void setFrom(Long value) {
        put(this.from, value);
    }

    @JsonProperty
    public Long getFrom() {
        return getLong(this.from);
    }

    public void setChatId(String value) {
        put(this.chatId, ParseObject.createWithoutData("Chat", value));
    }

    @JsonProperty
    public String getChatId() {
        return getString(this.chatId);
    }

    public void setBody(String value) {
        put(this.body, value);
    }

    @JsonProperty
    public String getBody() {
        return getString(this.body);
    }
}