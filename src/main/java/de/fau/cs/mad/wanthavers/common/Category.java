package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import javax.persistence.*;

@DatabaseTable
@Entity
public class Category extends AbstractModel implements Serializable {


    @DatabaseField(id = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DatabaseField
    @Column
    private String name;

    @DatabaseField
    @Column
    private long parentId;

    @DatabaseField(foreign = true, dataType = DataType.SERIALIZABLE)
    @ManyToOne(targetEntity = Media.class, cascade=CascadeType.ALL)
    private Media image;


    public Category() {}

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public long getParent() {
        return parentId;
    }

    public void setParent(long parent) {
        this.parentId = parent;
    }

    @JsonProperty
    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }
}