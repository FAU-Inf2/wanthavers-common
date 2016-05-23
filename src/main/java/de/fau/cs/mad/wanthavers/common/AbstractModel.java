package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;


public abstract class AbstractModel {

    protected Timestamp lastModified;

    public AbstractModel() {
        // No super() call necessary in sub classes, see http://docs.oracle.com/javase/tutorial/java/IandI/super.html
        lastModified = new Timestamp(System.currentTimeMillis());
    }

    @JsonProperty
    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
}
