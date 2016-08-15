package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "haverseq")
public class Haver extends AbstractModel {

    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = User.class)
    private User user;

    @DatabaseField
    @Column
    private Date creationDate;

    @DatabaseField
    @Column(nullable = false)
    private int status;

    @DatabaseField
    @Column(name = Desire.DESIRE_ID, nullable = false)
    private long desireId;

    @DatabaseField
    @Column
    private double requestedPrice;

    public Haver() {}

    public Haver(User user, Date creationDate, long desireId) {
        this.user = user;
        this.creationDate = creationDate;
        this.desireId = desireId;
    }


    @JsonProperty
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @JsonProperty
    public long getDesireId() {
        return desireId;
    }

    public void setDesireId(long desireId) {
        this.desireId = desireId;
    }

    @JsonProperty
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonIgnore
    public double getRequestedPrice() {
        return requestedPrice;
    }

    public void setRequestedPrice(double requestedPrice) {
        this.requestedPrice = requestedPrice;
    }
}
