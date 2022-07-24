package com.example.pmis_2.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.pmis_2.FirebaseDatabaseHelper;
import com.example.pmis_2.ProjectListData;
import com.example.pmis_2.R;

import java.util.ArrayList;

public class AdminProjectDetails extends AppCompatActivity {

    EditText projectDetailsNameEditText, projectDetailsCustomerEditText, projectDetailsManagerEditText;
    String key;
    ProjectListData projectListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_project_details);

        projectDetailsNameEditText = findViewById(R.id.projectDetailsNameEditText);
        projectDetailsCustomerEditText = findViewById(R.id.projectDetailsCustomerEditText);
        projectDetailsManagerEditText = findViewById(R.id.projectDetailsManagerEditText);

        key = getIntent().getStringExtra("key");
        projectListData = getIntent().getParcelableExtra("data");

        getIntentData();
    }

    public void getIntentData() {
        projectDetailsCustomerEditText.setText(projectListData.getCustomer());
    }
}