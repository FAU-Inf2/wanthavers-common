package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.security.Principal;
import java.util.Date;

@Entity
public class User implements Principal {
    public static final String USER_ID = "userId";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: change to UUID
    @Column(name = USER_ID)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private Date birthday;

    private double avgRating;

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
}
