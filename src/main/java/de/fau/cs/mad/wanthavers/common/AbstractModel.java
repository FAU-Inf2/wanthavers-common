package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;


@MappedSuperclass
public abstract class AbstractModel implements Serializable {

    @DatabaseField(id = true)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    protected long id;

    protected Timestamp lastModified;

    public AbstractModel() {
        // No super() call necessary in sub classes, see http://docs.oracle.com/javase/tutorial/java/IandI/super.html
        lastModified = new Timestamp(System.currentTimeMillis());
    }


    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

}
