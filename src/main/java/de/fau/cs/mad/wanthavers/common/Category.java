package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import javax.persistence.*;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "catseq")
public class Category extends AbstractModel {

    @DatabaseField
    @Column
    private String name;

    @DatabaseField
    @Column
    private long parent;

    @DatabaseField(foreign = true, dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = Media.class)
    private Media image;

    public Category() {}


    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    @JsonProperty
    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }
}
