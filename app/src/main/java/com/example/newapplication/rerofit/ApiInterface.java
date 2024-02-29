package com.example.newapplication.rerofit;


import com.example.newapplication.model.IssueDetailsMainRequest;
import com.example.newapplication.model.IssueShowDetailsResponse;
import com.example.newapplication.model.VersionCheckRequest;
import com.example.newapplication.model.VersionCheckResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("versionCheck")
    Call<VersionCheckResponse> getVersionNum(@Body VersionCheckRequest versionCheckRequest);
    @POST("showIssueDetails")
    Call<IssueShowDetailsResponse> issueShowDetailsResponse(@Header("Authorization") String Auth_Token, @Body IssueDetailsMainRequest issueDetailsMainRequest);

}
