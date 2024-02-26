package com.example.newapplication.rerofit;


import com.example.newapplication.model.VersionCheckRequest;
import com.example.newapplication.model.VersionCheckResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("versionCheck")
    Call<VersionCheckResponse> getVersionNum(@Body VersionCheckRequest versionCheckRequest);

}
