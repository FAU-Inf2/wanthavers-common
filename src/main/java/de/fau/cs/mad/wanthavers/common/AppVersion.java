package de.fau.cs.mad.wanthavers.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.table.DatabaseTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@DatabaseTable
@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "appversionseq")
public class AppVersion extends AbstractModel {

    public final static class TYPE {
        public static int FEATURE = 0;
        public static int BREAKING_CHANGE = 1;
        public static int NEW_APP = 2;
    }

    public final static class OS {
        public static int ANDROID = 0;
        public static int IOS = 1;
    }

    @Column
    private int versionCode;

    @Column
    private int type;

    @Column
    private int os;

    @Column
    private String storeLink;

    @Column
    private String appId;

    private boolean forceUpdate;

    @JsonProperty
    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    @JsonProperty
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JsonProperty
    public int getOS() {
        return os;
    }

    public void setOS(int os) {
        this.os = os;
    }

    @JsonProperty
    public String getStoreLink() {
        return storeLink;
    }

    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink;
    }


    @JsonProperty
    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    @JsonProperty
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


}
