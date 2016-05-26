package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import javax.persistence.*;

@DatabaseTable
@Entity
public class Media extends AbstractModel implements Serializable {

    /**
     * Resolutions for resizing
     */
    public static final int HIGH_RES   = 1200;
    public static final int MEDIUM_RES = 600;
    public static final int LOW_RES    = 200;
    public static final int[] RESOLUTIONS = new int[]{HIGH_RES, MEDIUM_RES, LOW_RES};

    /**
     * Members
     */
    @DatabaseField(id = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DatabaseField
    @Column
    private String fullRes;

    @DatabaseField
    @Column
    private String mediumRes;

    @DatabaseField
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

    /**
     * Generic Setter
     * @param url
     * @param resolution
     */
    public void setImage(String url, int resolution){
        switch (resolution){
            case LOW_RES:    this.setLowRes(url); break;
            case MEDIUM_RES: this.setMediumRes(url);break;
            case HIGH_RES:   this.setFullRes(url);break;
            default: break;
        }
    }
}
