package com.example.pmis_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardPM extends AppCompatActivity {
    private ImageButton btn_logout;
    //private FirebaseAuth mAuth;

    RecyclerView recyclerView;
    ProjectInfoAdapter projectInfoAdapter;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_p_m);
        //mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



        recyclerView = findViewById(R.id.recycleviewproject);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ProjectInfo> options =
                new FirebaseRecyclerOptions.Builder<ProjectInfo>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("projects"), ProjectInfo.class)
                        .build();
        projectInfoAdapter = new ProjectInfoAdapter(options);
        recyclerView.setAdapter(projectInfoAdapter);

        btn_logout = findViewById(R.id.btnlogout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mAuth.signOut();
                startActivity(new Intent(DashboardPM.this, LoginPage.class));
                preferences.clearData(this);
                finish();
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