package de.fau.cs.mad.wanthavers.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "userflagseq")
public class UserFlag extends AbstractModel {

    @DatabaseField
    @Column(nullable = false)
    private long issuerId;

    @DatabaseField
    @Column(nullable = false)
    private long userId;


    public UserFlag() {}

    public UserFlag(long issuerId, long userId) {
        this.issuerId = issuerId;
        this.userId = userId;
    }

    @JsonProperty
    public long getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(long issuerId) {
        this.issuerId = issuerId;
    }

    @JsonProperty
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
