package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.security.Principal;
import java.util.Date;
import java.util.UUID;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "userseq")
public class User extends AbstractModel implements Principal {
    public static final String USER_ID = "userId";
    private static final long TOKEN_VALID_DURATION = 1000*60*60; //token is valid for 1h

    public static class DefaultUserImage {
        public static final String lowRes = "https://s3.eu-central-1.amazonaws.com/whimages/571509e0-c381-430b-b123-0f01c103d15d.png";
        public static final String mediumRes = "https://s3.eu-central-1.amazonaws.com/whimages/55c5efbc-5ae7-4c91-9c52-f70a57d3356c.png";
        public static final String fullRes = "https://s3.eu-central-1.amazonaws.com/whimages/0f6e92b1-4500-422b-91f9-ea760f492718.png";

        public static Media get() {
            Media ret = new Media();
            ret.setLowRes(lowRes);
            ret.setMediumRes(mediumRes);
            ret.setFullRes(fullRes);
            return ret;
        }
    }

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String passwordToken;

    @Column(nullable = true)
    private long tokenCreationTimestamp;

    @DatabaseField
    @Column(nullable = false)
    private String name;

    @DatabaseField
    @Column(nullable = false, unique = true)
    private String email;

    @DatabaseField
    @Column(nullable = true)
    private Date birthday;

    @DatabaseField
    @Column
    private float avgRating;

    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = Media.class)
    private Media image;

    @DatabaseField
    @Column
    private String langCode;

    @Column
    private String role;

    @Column
    private int status;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @JsonProperty
    @Column(name = USER_ID)
    @Override
    public long getId() {
        return id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }

    @JsonProperty
    public float getRating() {
        return this.avgRating;
    }

    public void setRating(float rating) {
        this.avgRating = rating;
    }

    @JsonProperty
    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }

    @JsonIgnore
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonIgnore
    public String createPasswordToken() {
        String uuid = UUID.randomUUID().toString();
        this.passwordToken = uuid.replace("-","");
        this.tokenCreationTimestamp = System.currentTimeMillis();
        return this.passwordToken;
    }

    @JsonIgnore
    public boolean checkPasswordToken(String passwordToken) {
        if(!isPasswordTokenStillValid()){
            return false;
        }

        if(this.passwordToken.equals(passwordToken)){
            return true;
        }

        return false;
    }

    private boolean isPasswordTokenStillValid(){
        if((System.currentTimeMillis()-this.tokenCreationTimestamp) > TOKEN_VALID_DURATION){
            return false;
        }
        return true;
    }

    @JsonProperty
    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
