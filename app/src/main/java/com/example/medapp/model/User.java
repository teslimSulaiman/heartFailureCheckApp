package com.example.medapp.model;

import com.example.medapp.R;

public class User {
    private boolean sinusCheckbox = false, arrhyCheckbox = false, conductionCheckbox = false, leftCheckbox = false;

    public User() {
    }

    public User(boolean sinusCheckbox, boolean arrhyCheckbox, boolean conductionCheckbox, boolean leftCheckbox) {
        this.sinusCheckbox = sinusCheckbox;
        this.arrhyCheckbox = arrhyCheckbox;
        this.conductionCheckbox = conductionCheckbox;
        this.leftCheckbox = leftCheckbox;
    }

    public boolean isSinusCheckbox() {
        return sinusCheckbox;
    }

    public void setSinusCheckbox(boolean sinusCheckbox) {
        this.sinusCheckbox = sinusCheckbox;
    }

    public boolean isArrhyCheckbox() {
        return arrhyCheckbox;
    }

    public void setArrhyCheckbox(boolean arrhyCheckbox) {
        this.arrhyCheckbox = arrhyCheckbox;
    }

    public boolean isConductionCheckbox() {
        return conductionCheckbox;
    }

    public void setConductionCheckbox(boolean conductionCheckbox) {
        this.conductionCheckbox = conductionCheckbox;
    }

    public boolean isLeftCheckbox() {
        return leftCheckbox;
    }

    public void setLeftCheckbox(boolean leftCheckbox) {
        this.leftCheckbox = leftCheckbox;
    }
    public String builderMessage() {
        int totalScore = 0;
        if(sinusCheckbox) {
            totalScore+=2;
        }
        if(arrhyCheckbox) {
            totalScore+=2;
        }
        if(conductionCheckbox) {
            totalScore+=1;
        }
        if(leftCheckbox) {
            totalScore+=1;
        }

        if(totalScore == 0) {
            return "Summary: The patient has a " + "16.7%" + " heart failure probability" + "\n" + "\n"
                    + "Advice: The patient is fine and does not have heart failure";
        }
        if(totalScore == 1) {
           return  "Summary: The patient has a " + "33.8%" + " heart failure probability" + "\n" + "\n"
                    + "Advice: The patient is fine and does not have heart failure";
        }
        if(totalScore == 2) {
          //  builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogStyleYellow);
           return  "Summary: The patient has a " + "59.1%" + " heart failure probability" + "\n" + "\n"
                    + "Advice: The patient is not fine and is advised to be refered to doctor";
        }
        if(totalScore == 3) {
            //builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogStyleYellow);
           return  "Summary: The patient has a " + "73.8%" + " heart failure probability" + "\n" + "\n"
                    + "Advice: The patient is not fine and is advised to be refered to doctor";
        }
        if(totalScore == 4) {
            //builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogStyleRed);
            return  "Summary: The patient has a " + "95.4%" + " heart failure probability" + "\n" + "\n"
                    + "Advice: The patient is not fine and has a very high percentage of heart failure";
        }
        if(totalScore == 5 || totalScore == 6) {
           // builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogStyleRed);
            return  "Summary: The patient has a " + "100%" + " heart failure probability" + "\n" + "\n"
                    + "Advice: The patient is not fine and has a very high percentage of heart failure";
        }
        return "";
    }
    public int dialogStyle() {
        int totalScore = 0;
        if(sinusCheckbox) {
            totalScore+=2;
        }
        if(arrhyCheckbox) {
            totalScore+=2;
        }
        if(conductionCheckbox) {
            totalScore+=1;
        }
        if(leftCheckbox) {
            totalScore+=1;
        }

        if(totalScore == 2) {
            return R.style.AlertDialogStyleYellow;
        }
        if(totalScore == 3) {
            return R.style.AlertDialogStyleYellow;
        }
        if(totalScore == 4) {
            return R.style.AlertDialogStyleRed;
        }
        if(totalScore == 5 || totalScore == 6) {
            return R.style.AlertDialogStyleRed;
        }
        return R.style.AlertDialogStyleGreen;
    }
}
