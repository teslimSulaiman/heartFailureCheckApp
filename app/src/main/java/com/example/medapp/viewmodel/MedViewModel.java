package com.example.medapp.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.medapp.database.MedDao;
import com.example.medapp.database.MedDataBase;
import com.example.medapp.model.User;

import java.util.List;

public class MedViewModel extends AndroidViewModel {
    private MedDao medDAO;
    /*private LiveData<List<User>> allRecords;
    private LiveData<User> recordWithId;*/

    private List<User> allRecords;
    private User recordWithId;

    public MedViewModel(@NonNull Application application) {
        super(application);
        MedDataBase database = MedDataBase.getInstance(application);
        medDAO = database.getMedDao();
        allRecords = medDAO.getRecord();
    }

    public void insert(User user) {
        // repository.insert(note);
        new InsertRecordAsyncTask(medDAO).execute(user);
    }

    public void delete(User user) {
        // repository.delete(note);
        new DeleteRecordAsyncTask(medDAO).execute(user);
    }

    public void deleteAllRecords() {
        new DeleteAllRecordsAsyncTask(medDAO).execute();
    }

    /*public LiveData<List<User>> getAllRecords() {
        return allRecords;
    }

    public LiveData<User> getRecordWithId(int id) {
        recordWithId = medDAO.getRecordWithId(id);
        return recordWithId;
    }*/

    public List<User> getAllRecords() {
        return allRecords;
    }

    public User getRecordWithId(int id) {
        recordWithId = medDAO.getRecordWithId(id);
        return recordWithId;
    }

    private static class InsertRecordAsyncTask extends AsyncTask<User, Void, Void> {
        private MedDao medDao;

        private InsertRecordAsyncTask(MedDao medDao) {
            this.medDao = medDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            medDao.insert(users[0]);
            return null;
        }
    }

    private static class DeleteRecordAsyncTask extends AsyncTask<User, Void, Void> {
        private MedDao medDao;

        private DeleteRecordAsyncTask(MedDao medDao) {
            this.medDao = medDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            medDao.delete(users[0]);
            return null;
        }
    }

    private static class DeleteAllRecordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedDao medDao;

        private DeleteAllRecordsAsyncTask(MedDao medDao) {
            this.medDao = medDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            medDao.deleteAllRecords();
            return null;
        }
    }

}
