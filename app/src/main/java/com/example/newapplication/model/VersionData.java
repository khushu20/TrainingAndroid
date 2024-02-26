package com.example.newapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionData {

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

    @SerializedName("maxTimeChk")
    @Expose
    private int maxTimeChk;

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