package com.example.newapplication.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newapplication.model.IssueDetailsMainRequest;
import com.example.newapplication.model.IssueShowDetailsResponse;
import com.example.newapplication.model.VersionCheckRequest;
import com.example.newapplication.model.VersionCheckResponse;
import com.example.newapplication.rerofit.ApiClient;
import com.example.newapplication.rerofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashViewModel extends AndroidViewModel {
    private final MutableLiveData<VersionCheckResponse> checkResponseMutableLiveData=new MutableLiveData<>();
    private final MutableLiveData<IssueShowDetailsResponse> issuedetailsMutableLiveData=new MutableLiveData<>();;

    public SplashViewModel(@NonNull Application application) {
        super(application);
       // checkResponseMutableLiveData=new MutableLiveData<>();
    }
    public LiveData<VersionCheckResponse> getVersionResponse(){
        return checkResponseMutableLiveData;
    }
    public LiveData<IssueShowDetailsResponse> getIssueDetailsResponse(){
        return issuedetailsMutableLiveData;
    }
    public void callVersioncheckApi(VersionCheckRequest versionCheckRequest){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<VersionCheckResponse> call = apiInterface.getVersionNum(versionCheckRequest);
        call.enqueue(new Callback<VersionCheckResponse>() {
            @Override
            public void onResponse(@NonNull Call<VersionCheckResponse> call, @NonNull Response<VersionCheckResponse> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        checkResponseMutableLiveData.setValue(response.body());

                    }
                } catch (Exception e) {
                    e.printStackTrace();

                    Toast.makeText(getApplication(), "Server not responding.Please try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<VersionCheckResponse> call, @NonNull Throwable t) {
                try {
                    //errorHandlerInterface.handleError("Server not responding.Please try again", getApplication());
                    Toast.makeText(getApplication(), "Server not responding.Please try again", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();

                    Toast.makeText(getApplication(), "Server not responding.Please try again", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void callIssueDetasilsApi(String Auth,IssueDetailsMainRequest issueDetailsMainRequest){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<IssueShowDetailsResponse> call = apiInterface.issueShowDetailsResponse(Auth,issueDetailsMainRequest);
        call.enqueue(new Callback<IssueShowDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<IssueShowDetailsResponse> call, @NonNull Response<IssueShowDetailsResponse> response) {
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        issuedetailsMutableLiveData.setValue(response.body());

                    }
                } catch (Exception e) {
                    e.printStackTrace();

                    Toast.makeText(getApplication(), "Server not responding.Please try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<IssueShowDetailsResponse> call, @NonNull Throwable t) {
                try {
                    //errorHandlerInterface.handleError("Server not responding.Please try again", getApplication());
                    Toast.makeText(getApplication(), "Server not responding.Please try again", Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    e.printStackTrace();

                    Toast.makeText(getApplication(), "Server not responding.Please try again", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    }

