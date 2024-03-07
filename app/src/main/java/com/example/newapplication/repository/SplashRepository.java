package com.example.newapplication.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newapplication.database.NewDao;
import com.example.newapplication.database.NewDatabase;
import com.example.newapplication.model.VersionData;

import java.util.List;

public class SplashRepository {
    private NewDao newDao;
    NewDatabase dbInstance;
    private MutableLiveData<Integer> responseMutablenewData = new MutableLiveData<>();
    public SplashRepository(Application application) {

        dbInstance = NewDatabase.getDatabase(application);
        newDao = dbInstance.NewDao();


    }
    public void insertVersionData(final VersionData versiondata) {
        new InsertVersionDataAsyncTaskOne(versiondata).execute();
    }
    public LiveData<List<VersionData>> getVersionData() {
        return newDao.getAllVersiondata();
    }

    private class InsertVersionDataAsyncTaskOne extends AsyncTask<Void, Void, Integer> {
        VersionData versionData1;




        public InsertVersionDataAsyncTaskOne(VersionData versiondata) {
            this.versionData1=versiondata;

        }

        @Override
        protected Integer doInBackground(Void... voids) {
            newDao.insertVersionDataDetails(versionData1);
            return newDao.versionCount() ;
        }
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            responseMutablenewData.setValue(integer);
        }
    }
}
