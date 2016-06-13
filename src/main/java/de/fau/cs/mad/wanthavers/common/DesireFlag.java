package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import de.fau.cs.mad.wanthavers.common.rest.api.FlagResource;

import javax.persistence.Column;
import javax.persistence.Entity;

@DatabaseTable
@Entity
public class DesireFlag extends AbstractModel {

    @DatabaseField
    @Column(name = Desire.DESIRE_ID, nullable = false)
    private long desireId;

    @DatabaseField
    @Column
    private FlagReason flagReason;

    @DatabaseField
    @Column
    private String comment;

    public DesireFlag() {}

    public DesireFlag(long desireId, FlagReason flagReason, String comment) {
        this.desireId = desireId;
        this.flagReason = flagReason;
        this.comment = comment;
    }

    @JsonProperty
    public long getDesireId() {
        return desireId;
    }

    public void setDesireId(long desireId) {
        this.desireId = desireId;
    }

    @JsonProperty
    public FlagReason getFlagReason() {
        return flagReason;
    }

    public void setFlagReason(FlagReason flagReason) {
        this.flagReason = flagReason;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
