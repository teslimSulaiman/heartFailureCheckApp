package com.example.medapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.medapp.model.User;

import java.util.List;


@Dao
public interface MedDao {
    @Insert
    public void insert(User... users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void update(User... users);

    @Delete
    public void delete(User user);

    @Query("DELETE FROM user")
    void deleteAllRecords();

    @Query("SELECT * FROM user")
    //public LiveData<List<User>> getRecord();
    public List<User> getRecord();

    @Query("SELECT * FROM user WHERE id = :recordId")
    //public LiveData<User> getRecordWithId(int recordId);
    public User getRecordWithId(int recordId);

}
