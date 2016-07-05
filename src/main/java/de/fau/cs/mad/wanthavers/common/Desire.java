package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


import javax.persistence.*;
import javax.persistence.Entity;

import java.util.Date;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "desireseq")
public class Desire extends AbstractModel {
    public static final String DESIRE_ID = "desireId";

    @DatabaseField
    @Column(nullable = false)
    private String title;

    @DatabaseField
    @Column(nullable = false)
    private String description;

    @DatabaseField(foreign = true, dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = User.class)
    private User creator;

    @DatabaseField
    @Column(nullable = false)
    private double price;

    @DatabaseField
    @Column(nullable = true)
    private double reward;

    @DatabaseField
    @Column
    private String currency;

    @DatabaseField
    @Column(nullable = true)
    private Date creation_time;

    @DatabaseField
    @Column(nullable = true)
    private String dropzone_string;

    @DatabaseField
    @Column(nullable = true)
    private double dropzone_lat;

    @DatabaseField
    @Column(nullable = true)
    private double dropzone_long;

    @DatabaseField
    @Column(nullable = false)
    private int colorIndex;

    @DatabaseField(foreign = true, dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = Media.class)
    private Media image;

    @DatabaseField
    @Column
    private int status = DesireStatus.STATUS_OPEN;

    @DatabaseField
    @Column
    private long categoryId;

    @DatabaseField
    @Column
    private int flagCounter;

    @DatabaseField
    @Column
    private boolean creatorHasRated;

    @DatabaseField
    @Column
    private boolean haverHasRated;

    @DatabaseField
    @Column
    private Date expireDate;

    private long distanceToUserPosition;

    public Desire() {}

    public Desire(String title, String description, User creator, double price, double reward, String currency, Date creation_time, String dropzone_string, double dropzone_lat, double dropzone_long, int colorIndex) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.price = price;
        this.reward = reward;
        this.currency = currency;
        this.creation_time = creation_time;
        this.dropzone_string = dropzone_string;
        this.dropzone_lat = dropzone_lat;
        this.dropzone_long = dropzone_long;
        this.colorIndex = colorIndex;
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
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    @JsonProperty
    public int getColorIndex() {
        return colorIndex;
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    @JsonProperty
    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }

    @JsonProperty
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
    
    public int getFlagCounter() {
        return flagCounter;
    }

    public void setFlagCounter(int flagCounter) {
        this.flagCounter = flagCounter;
    }

    @JsonProperty
    public boolean getCreatorHasRated() {
        return creatorHasRated;
    }

    public void setCreatorHasRated(boolean creatorHasRated) {
        this.creatorHasRated = creatorHasRated;
    }

    @JsonProperty
    public boolean getHaverHasRated() {
        return haverHasRated;
    }

    public void setHaverHasRated(boolean haverHasRated) {
        this.haverHasRated = haverHasRated;
    }

    @JsonProperty
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @JsonProperty
    public long getDistanceToUserPosition() {
        return distanceToUserPosition;
    }

    public void setDistanceToUserPosition(long distanceToUserPosition) {
        this.distanceToUserPosition = distanceToUserPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desire desire = (Desire) o;
        return id == desire.id;
    }
}
