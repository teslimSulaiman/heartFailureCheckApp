package com.example.medapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medapp.R;
import com.example.medapp.model.User;
import com.example.medapp.presenter.MainActivityPresenter;
import com.example.medapp.viewmodel.MedViewModel;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    @BindView(R.id.patient_name)
    TextView patientName;
    @BindView(R.id.sex_spinner) Spinner sexSpinner;
    @BindView(R.id.calculate)
    Button calculateButton;
    @BindView(R.id.sinus_checkbox)
    CheckBox sinusCheckbox;
    @BindView(R.id.arrhy_checkbox)
    CheckBox arrhyCheckbox;
    @BindView(R.id.conduction_checkbox)
    CheckBox conductionCheckbox;
    @BindView(R.id.left_checkbox)
    CheckBox leftCheckbox;
    @BindView(R.id.patient_age)
    TextView patientAge;
    private MainActivityPresenter presenter;
    private MedViewModel medViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        medViewModel = ViewModelProviders.of(this).get(MedViewModel.class);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("MedApp");
        toolbar.setLogo(R.drawable.icons8_medical_doctor_48);

        setSupportActionBar(toolbar);
        presenter = new MainActivityPresenter(this);

        String[] items = new String[]{"Male", "Female", "Binary"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        sexSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sinusCheckbox.isChecked() && !arrhyCheckbox.isChecked() && !conductionCheckbox.isChecked() && !leftCheckbox.isChecked()) {
                   //TODO Replace with a snackbar
                    Toast.makeText(MainActivity.this, "All fields can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                presenter.UpdateDialog(patientName.getText().toString(), sinusCheckbox.isChecked(), arrhyCheckbox.isChecked(), conductionCheckbox.isChecked(), leftCheckbox.isChecked(), patientAge.getText().toString(), sexSpinner.getSelectedItem().toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_online:
                //TODO: addSomething();
                return true;
            case R.id.records:
                //TODO: addSomething();
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
                return true;
            case R.id.about_us:
                //TODO: addSomething();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    AlertDialog.Builder builder;

    @Override
    public void setDialogStyle(int style) {
        builder = new AlertDialog.Builder(MainActivity.this, style);
    }

    @Override
    public void displayMessageOnDialog(String message) {

        builder.setTitle("Heart Failure Diagnostic");
        builder.setMessage(message);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.AddToDatabase();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    @Override
    public void saveToDatabase(User user) {
        medViewModel.insert(user);
        Toast.makeText(this, "Record Saved Successfully", Toast.LENGTH_SHORT).show();
    }

}