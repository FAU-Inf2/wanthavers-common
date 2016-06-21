package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "messageseq")
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
        byte[] utf8 = null;

        try {
            utf8 = body.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return body;
        }
        
        return new String(utf8);
    }

    public void setBody(String body) {
        this.body = body;
    }

}