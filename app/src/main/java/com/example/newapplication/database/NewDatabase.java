package com.example.newapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.newapplication.model.VersionData;


@Database(entities = {VersionData.class}, version = 2, exportSchema = false)
public abstract class NewDatabase extends  RoomDatabase {

    private static NewDatabase INSTANCE;
    public abstract NewDao NewDao();

    public static NewDatabase getDatabase(final Context context) {


        if (INSTANCE == null) {

            synchronized (NewDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                                    context, NewDatabase.class, "NEW_DATABASE")
                            .fallbackToDestructiveMigration()
                            .build();

                }

            }


        }

        return INSTANCE;

    }
}