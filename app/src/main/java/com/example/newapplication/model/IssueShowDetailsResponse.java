package com.example.newapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IssueShowDetailsResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status_Message")
    @Expose
    private String statusMessage;
    @SerializedName("status_Code")
    @Expose
    private Integer statusCode;
    @SerializedName("data")
    @Expose
    private List<IssueDetailsData> data;
    @SerializedName("paginated")
    @Expose
    private Boolean paginated;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<IssueDetailsData> getData() {
        return data;
    }

    public void setData(List<IssueDetailsData> data) {
        this.data = data;
    }

    public Boolean getPaginated() {
        return paginated;
    }

    public void setPaginated(Boolean paginated) {
        this.paginated = paginated;
    }
}
