package com.example.newapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssueDetailsMainRequest {
    @SerializedName("appName")
    @Expose
    private String appName;
    @SerializedName("sessionToken")
    @Expose
    private String sessionToken;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("issueTrackerModel")
    @Expose
    private IssueDetailsReq issueTrackerModel;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public IssueDetailsReq getIssueTrackerModel() {
        return issueTrackerModel;
    }

    public void setIssueTrackerModel(IssueDetailsReq issueTrackerModel) {
        this.issueTrackerModel = issueTrackerModel;
    }

}
