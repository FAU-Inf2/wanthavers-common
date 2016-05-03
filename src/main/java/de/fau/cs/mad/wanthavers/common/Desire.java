package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Desire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //TODO: change to UUID
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne(targetEntity = User.class, cascade=CascadeType.ALL)
    private User creator;

    @Column(nullable = false)
    private double price;

    @Column(nullable = true)
    private double reward;

    @Column(nullable = true)
    private Date creation_time;

    @Column(nullable = true)
    private String dropzone_string;

    @Column(nullable = true)
    private double dropzone_lat;

    @Column(nullable = true)
    private double dropzone_long;


    public Desire() {}

    public Desire(String title, String description, User creator, double price, double reward, Date creation_time, String dropzone_string, double dropzone_lat, double dropzone_long) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.price = price;
        this.reward = reward;
        this.creation_time = creation_time;
        this.dropzone_string = dropzone_string;
        this.dropzone_lat = dropzone_lat;
        this.dropzone_long = dropzone_long;
    }

    @JsonProperty
    public long getID() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public User getCreator() {
        return this.creator;
    }

    public void setCreator(User user) {
        this.creator = user;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty
    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    @JsonProperty
    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    @JsonProperty
    public String getDropzone_string() {
        return dropzone_string;
    }

    public void setDropzone_string(String dropzone_string) {
        this.dropzone_string = dropzone_string;
    }

    @JsonProperty
    public double getDropzone_lat() {
        return dropzone_lat;
    }

    public void setDropzone_lat(double dropzone_lat) {
        this.dropzone_lat = dropzone_lat;
    }

    @JsonProperty
    public double getDropzone_long() {
        return dropzone_long;
    }

    public void setDropzone_long(double dropzone_long) {
        this.dropzone_long = dropzone_long;
    }

}
