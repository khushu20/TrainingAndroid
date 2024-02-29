package com.example.newapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssueDetailsData {
    @SerializedName("feedbackOrComplaintTypeId")
    @Expose
    private String feedbackOrComplaintTypeId;
    @SerializedName("feedbackOrComplaintTypeName")
    @Expose
    private String feedbackOrComplaintTypeName;
    @SerializedName("feedbackOrComplaintId")
    @Expose
    private String feedbackOrComplaintId;
    @SerializedName("subTypeId")
    @Expose
    private String subTypeId;
    @SerializedName("subTypeName")
    @Expose
    private String subTypeName;
    @SerializedName("resolutionName")
    @Expose
    private String resolutionName;
    @SerializedName("assigneeName")
    @Expose
    private String assigneeName;
    @SerializedName("ticketNo")
    @Expose
    private String ticketNo;
    @SerializedName("issueSubject")
    @Expose
    private String issueSubject;
    @SerializedName("issueDescription")
    @Expose
    private String issueDescription;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("uploadedFilePath")
    @Expose
    private String uploadedFilePath;
    @SerializedName("employeeId")
    @Expose
    private String employeeId;
 @SerializedName("issueUploadedFile")
    @Expose
    private String issueUploadedFile;

    public String getIssueUploadedFile() {
        return issueUploadedFile;
    }

    public void setIssueUploadedFile(String issueUploadedFile) {
        this.issueUploadedFile = issueUploadedFile;
    }

    public String getFeedbackOrComplaintTypeId() {
        return feedbackOrComplaintTypeId;
    }

    public void setFeedbackOrComplaintTypeId(String feedbackOrComplaintTypeId) {
        this.feedbackOrComplaintTypeId = feedbackOrComplaintTypeId;
    }

    public String getFeedbackOrComplaintTypeName() {
        return feedbackOrComplaintTypeName;
    }

    public void setFeedbackOrComplaintTypeName(String feedbackOrComplaintTypeName) {
        this.feedbackOrComplaintTypeName = feedbackOrComplaintTypeName;
    }

    public String getFeedbackOrComplaintId() {
        return feedbackOrComplaintId;
    }

    public void setFeedbackOrComplaintId(String feedbackOrComplaintId) {
        this.feedbackOrComplaintId = feedbackOrComplaintId;
    }

    public String getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(String subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public String getResolutionName() {
        return resolutionName;
    }

    public void setResolutionName(String resolutionName) {
        this.resolutionName = resolutionName;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getIssueSubject() {
        return issueSubject;
    }

    public void setIssueSubject(String issueSubject) {
        this.issueSubject = issueSubject;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUploadedFilePath() {
        return uploadedFilePath;
    }

    public void setUploadedFilePath(String uploadedFilePath) {
        this.uploadedFilePath = uploadedFilePath;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
