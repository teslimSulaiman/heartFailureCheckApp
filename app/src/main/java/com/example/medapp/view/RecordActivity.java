package com.example.medapp.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medapp.R;
import com.example.medapp.adapter.MedAdapter;
import com.example.medapp.model.User;
import com.example.medapp.viewmodel.MedViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordActivity extends AppCompatActivity {
    private MedViewModel medViewModel;
    private MedAdapter medAdapter;
    List<User> userList;
    RecyclerView.LayoutManager layoutManager;


    @BindView(R.id.record_empty)
    TextView emptyView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setLogo(R.drawable.icons8_medical_doctor_48);
        setSupportActionBar(toolbar);

        userList = new ArrayList<>();
        medViewModel = ViewModelProviders.of(this).get(MedViewModel.class);
        //userList = medViewModel.getAllRecords().getValue();
        userList = medViewModel.getAllRecords();
        medAdapter = new MedAdapter(RecordActivity.this, userList);
        if(medAdapter.getItemCount() != 0) {
            emptyView.setVisibility(View.GONE);
        }
            //Toast.makeText(this, String.valueOf(medAdapter.getItemCount()), Toast.LENGTH_SHORT).show();

            //Toast.makeText(this, "List NULL", Toast.LENGTH_SHORT).show();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(medAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        /*medViewModel = ViewModelProviders.of(this).get(MedViewModel.class);
        medViewModel.getAllRecords().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                medAdapter = new MedAdapter(RecordActivity.this, users);
                recyclerView.setAdapter(medAdapter);
                if(medAdapter.getItemCount() != 0) {
                    emptyView.setVisibility(View.GONE);
                }

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_online:
                //TODO: addSomething();
                return true;
            case R.id.delete_all:
                //TODO: addSomething();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}