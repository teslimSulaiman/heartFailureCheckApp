package com.example.medapp.presenter;

import com.example.medapp.model.User;

public class MainActivityPresenter {
    private User user;
    private View view;

    public MainActivityPresenter(View view) {
        this.user = new User();
        this.view = view;
    }

    public void UpdateDialog(boolean sinusCheckbox, boolean arrhyCheckbox, boolean conductionCheckbox, boolean leftCheckbox) {
        user.setArrhyCheckbox(arrhyCheckbox);
        user.setConductionCheckbox(conductionCheckbox);
        user.setLeftCheckbox(leftCheckbox);
        user.setSinusCheckbox(sinusCheckbox);
        view.setDialogStyle(user.dialogStyle());
        view.displayMessageOnDialog(user.builderMessage());
    }
    public interface View{
        void setDialogStyle(int style);
        void displayMessageOnDialog(String message);
    }
}
