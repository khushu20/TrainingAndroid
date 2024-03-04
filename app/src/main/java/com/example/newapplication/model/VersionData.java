package com.example.newapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "VersionTable")
public class VersionData {
    @SerializedName("maxTimeChk")
    @Expose
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int maxTimeChk;

    @SerializedName("appName")
    @Expose
    private String appName;

    @SerializedName("webServiceName")
    @Expose
    private String webServiceName;

    @SerializedName("versionNo")
    @Expose
    private String versionNo;

    @SerializedName("lastUpdatedDate")
    @Expose
    private String lastUpdatedDate;



    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getWebServiceName() {
        return webServiceName;
    }

    public void setWebServiceName(String webServiceName) {
        this.webServiceName = webServiceName;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public int getMaxTimeChk() {
        return maxTimeChk;
    }

    public void setMaxTimeChk(int maxTimeChk) {
        this.maxTimeChk = maxTimeChk;
    }
}