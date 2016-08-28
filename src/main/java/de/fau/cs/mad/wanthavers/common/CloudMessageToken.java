package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

import javax.persistence.*;

import static de.fau.cs.mad.wanthavers.common.User.USER_ID;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "cloudmessagetokenseq")
public class CloudMessageToken extends AbstractModel {
    public static final String IOS_TOKEN = "iOS";
    public static final String ANDROID_TOKEN = "Android";

    @DatabaseField
    @Column(name = USER_ID, nullable = false)
    private long userId;

    @DatabaseField
    @Column(nullable = false)
    private String token;

    @DatabaseField
    @Column(nullable = false)
    private String tokenType;

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

    @JsonProperty
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
