package com.example.newapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionCheckResponse {


    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("status_Message")
    @Expose
    private String statusMessage;

    @SerializedName("status_Code")
    @Expose
    private int statusCode;

    @SerializedName("data")
    @Expose
    private VersionData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public VersionData getData() {
        return data;
    }

    public void setData(VersionData data) {
        this.data = data;
    }


}
