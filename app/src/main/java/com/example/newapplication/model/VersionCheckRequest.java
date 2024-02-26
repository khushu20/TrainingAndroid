package com.example.newapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionCheckRequest {



    @SerializedName("webServiceName")
    @Expose
    private String webServiceName;

    @SerializedName("appName")
    @Expose
    private String appName;

    @SerializedName("mobileType")
    @Expose
    private String mobileType;

    public String getWebServiceName() {
        return webServiceName;
    }

    public void setWebServiceName(String webServiceName) {
        this.webServiceName = webServiceName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }
}
