package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

import static de.fau.cs.mad.wanthavers.common.User.USER_ID;

@Entity
public class Rating extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: change to UUID
    private long id;

    @Column(name = USER_ID, nullable = false)
    private long userId;

    @Column
    private Date ratedTime;

    @Column(nullable = false)
    private float stars;

    @Column
    private String comment;

    @ManyToOne(targetEntity = User.class, cascade=CascadeType.ALL)
    private User rater;

    @ManyToOne(targetEntity = Desire.class, cascade=CascadeType.ALL)
    private Desire ratedTransaction;


    public Rating() {}

    public Rating(long userId, float stars) {
        this.userId = userId;
        this.stars = stars;
    }

    public Rating(long userId, Date ratedTime, float stars, String comment, User rater, Desire ratedTransaction) {
        this.userId = userId;
        this.ratedTime = ratedTime;
        this.stars = stars;
        this.comment = comment;
        this.rater = rater;
        this.ratedTransaction = ratedTransaction;
    }


    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty
    public Date getRatedTime() {
        return ratedTime;
    }

    public void setRatedTime(Date ratedTime) {
        this.ratedTime = ratedTime;
    }

    @JsonProperty
    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonProperty
    public User getRater() {
        return rater;
    }

    public void setRater(User rater) {
        this.rater = rater;
    }

    @JsonProperty
    public Desire getRatedTransaction() {
        return ratedTransaction;
    }

    public void setRatedTransaction(Desire ratedTransaction) {
        this.ratedTransaction = ratedTransaction;
    }

}
