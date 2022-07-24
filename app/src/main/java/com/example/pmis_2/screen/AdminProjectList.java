package com.example.pmis_2.screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmis_2.FirebaseDatabaseHelper;
import com.example.pmis_2.ProjectListConfig;
import com.example.pmis_2.ProjectListData;
import com.example.pmis_2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdminProjectList extends AppCompatActivity {

    RecyclerView projectListRecyclerView;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_project_list);

        btnback = findViewById(R.id.projectListBackButton);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminProjectList.this, AdminAddProject.class));
            }
        });

        projectListRecyclerView = findViewById(R.id.projectListRecyclerView);

        new FirebaseDatabaseHelper().readProjectList(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void dataIsLoad(ArrayList<ProjectListData> projectListDataArrayList, ArrayList<String> keys) {
                new ProjectListConfig().setConfig(projectListRecyclerView, AdminProjectList.this, projectListDataArrayList, keys);
            }

            @Override
            public void dataIsUpdate() {
            }

            @Override
            public void dataIsDelete() {
            }
        });
    }
}