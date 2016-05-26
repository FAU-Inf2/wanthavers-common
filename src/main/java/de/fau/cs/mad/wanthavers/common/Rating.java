package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static de.fau.cs.mad.wanthavers.common.User.USER_ID;

@DatabaseTable
@Entity
public class Rating extends AbstractModel implements Serializable {

    @DatabaseField(id = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: change to UUID
    private long id;

    @DatabaseField
    @Column(name = USER_ID, nullable = false)
    private long userId;

    @DatabaseField
    @Column
    private Date ratedTime;

    @DatabaseField
    @Column(nullable = false)
    private float stars;

    @DatabaseField
    @Column
    private String comment;

    @DatabaseField(foreign = true)
    @ManyToOne(targetEntity = User.class, cascade=CascadeType.ALL)
    private User rater;

    @DatabaseField(foreign = true)
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
