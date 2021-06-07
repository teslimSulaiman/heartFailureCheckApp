package com.example.medapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.medapp.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class MedDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "med_database";
    private static MedDataBase instance;
    public abstract MedDao getMedDao();

    public static synchronized MedDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MedDataBase.class, MedDataBase.DATABASE_NAME).allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

}
