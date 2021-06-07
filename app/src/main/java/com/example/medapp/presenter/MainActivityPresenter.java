package com.example.medapp.presenter;
//TODO: Try making this a singleton class
import android.content.Intent;
import android.os.AsyncTask;

import androidx.lifecycle.ViewModelProviders;

import com.example.medapp.database.MedDataBase;
import com.example.medapp.model.User;
import com.example.medapp.view.MainActivity;
import com.example.medapp.viewmodel.MedViewModel;

import java.lang.ref.WeakReference;

public class MainActivityPresenter {
    private User user;
    private View view;


    public MainActivityPresenter(View view) {
        this.user = new User();
        this.view = view;
    }

    public void UpdateDialog(String patientName, boolean sinusCheckbox, boolean arrhyCheckbox, boolean conductionCheckbox, boolean leftCheckbox, String patientAge, String patientSex) {
        user.setName(patientName);
        user.setArrhyCheckbox(arrhyCheckbox);
        user.setConductionCheckbox(conductionCheckbox);
        user.setLeftCheckbox(leftCheckbox);
        user.setSinusCheckbox(sinusCheckbox);
        user.setAge(patientAge);
        user.setSex(patientSex);
        view.setDialogStyle(user.dialogStyle());
        view.displayMessageOnDialog(user.builderMessage());

    }

    public void UpdateDialog(String name) {
        user.setName(name);
    }

    public void AddToDatabase() {
        view.saveToDatabase(user);
    }

    public interface View{
        void setDialogStyle(int style);
        void displayMessageOnDialog(String message);
        void saveToDatabase(User user);
    }
}
