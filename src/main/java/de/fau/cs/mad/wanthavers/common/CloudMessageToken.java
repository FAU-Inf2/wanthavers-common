package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

import javax.persistence.*;

import static de.fau.cs.mad.wanthavers.common.User.USER_ID;

@Entity
public class CloudMessageToken extends AbstractModel {

    @DatabaseField
    @Column(name = USER_ID, nullable = false)
    private long userId;

    @DatabaseField
    @Column(nullable = false)
    private String token;

    @JsonProperty
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
