package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
public class Media extends AbstractModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String fullRes;

    @Column
    private String mediumRes;

    @Column
    private String lowRes;


    public Media() {}

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getFullRes() {
        return fullRes;
    }

    public void setFullRes(String fullRes) {
        this.fullRes = fullRes;
    }

    @JsonProperty
    public String getMediumRes() {
        return mediumRes;
    }

    public void setMediumRes(String mediumRes) {
        this.mediumRes = mediumRes;
    }

    @JsonProperty
    public String getLowRes() {
        return lowRes;
    }

    public void setLowRes(String lowRes) {
        this.lowRes = lowRes;
    }
}
