package com.example.newapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.newapplication.model.VersionData;

import java.util.List;


@Dao
public interface NewDao {

    @Insert()
    void insertVersionDataDetails(VersionData data);
    @Query("SELECT COUNT(webServiceName) FROM versiontable")
    int versionCount();
    @Query("SELECT * FROM versiontable")
    LiveData<List<VersionData>> getAllVersiondata();

}
