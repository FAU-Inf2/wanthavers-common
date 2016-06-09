package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@DatabaseTable
@Entity
public class User extends AbstractModel implements Principal, Serializable {
    public static final String USER_ID = "userId";
    private static final long TOKEN_VALID_DURATION = 1000*60*60; //token is valid for 1h

    @DatabaseField(id = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: change to UUID
    @Column(name = USER_ID)
    private long id;

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
    private double avgRating;

    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = Media.class)
    private Media image;

    @Column
    @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
    private Set<String> roles;

    @Column
    private int status;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @JsonProperty
    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public double getRating() {
        return this.avgRating;
    }

    public void setRating(double rating) {
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
    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
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


}
