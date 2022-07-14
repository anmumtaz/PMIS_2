package com.example.pmis_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProjectsAdmin extends AppCompatActivity {

    RecyclerView recyclerView;
    ProjectInfoAdapter projectInfoAdapter;

    FirebaseDatabase database;
    DatabaseReference reference;

    ImageButton btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_admin);

        btnback = findViewById(R.id.btnback1);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



        recyclerView = findViewById(R.id.recycleviewproject);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //String keyId = reference.push().getKey();

        FirebaseRecyclerOptions<ProjectInfo> options =
                new FirebaseRecyclerOptions.Builder<ProjectInfo>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("projects"), ProjectInfo.class)
                        .build();
        projectInfoAdapter = new ProjectInfoAdapter(options);
        recyclerView.setAdapter(projectInfoAdapter);



        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProjectsAdmin.this, AddProjects.class));
            }
        });


    }

    protected void onStart() {
        super.onStart();
        projectInfoAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        projectInfoAdapter.stopListening();
    }
}