package de.fau.cs.mad.wanthavers.common;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;
import java.util.List;

@DatabaseTable
public class DesireFilter {

    @DatabaseField(id = true, generatedId = true)
    private Integer id;

    @DatabaseField
    private Long category;

    @DatabaseField
    private Double price_min;

    @DatabaseField
    private Double price_max;

    @DatabaseField
    private Double reward_min;

    @DatabaseField
    private Float rating_min;

    @DatabaseField
    private Double lat;

    @DatabaseField
    private Double lon;

    @DatabaseField
    private Double radius;

    private List<Integer> status;

    private Date lastCreationTime;

    private Integer limit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Double getPrice_min() {
        return price_min;
    }

    public void setPrice_min(Double price_min) {
        this.price_min = price_min;
    }

    public Double getPrice_max() {
        return price_max;
    }

    public void setPrice_max(Double price_max) {
        this.price_max = price_max;
    }

    public Double getReward_min() {
        return reward_min;
    }

    public void setReward_min(Double reward_min) {
        this.reward_min = reward_min;
    }

    public Float getRating_min() {
        return rating_min;
    }

    public void setRating_min(Float rating_min) {
        this.rating_min = rating_min;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }

    public Date getLastCreationTime() {
        return lastCreationTime;
    }

    public void setLastCreationTime(Date lastCreationTime) {
        this.lastCreationTime = lastCreationTime;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
