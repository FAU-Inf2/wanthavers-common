package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static de.fau.cs.mad.wanthavers.common.User.USER_ID;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "locationseq")
public class Location extends AbstractModel {

    @DatabaseField
    @Column(name = USER_ID, nullable = false)
    private long userId;

    @DatabaseField
    @Column
    private String description;

    @DatabaseField
    @Column
    private double lat;

    @DatabaseField
    @Column
    private double lon;

    @DatabaseField
    @Column
    private String fullAddress;

    public Location() {}


    @JsonProperty
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @JsonProperty
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @JsonProperty
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
