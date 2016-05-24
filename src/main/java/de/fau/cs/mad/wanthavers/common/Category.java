package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.*;

@DatabaseTable
@Entity
public class Category extends AbstractModel {


    @DatabaseField(id = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DatabaseField
    @Column
    private String name;

    @DatabaseField
    @ManyToOne(targetEntity = Category.class, cascade=CascadeType.ALL)
    private Category parent;

    @DatabaseField
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
    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
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
