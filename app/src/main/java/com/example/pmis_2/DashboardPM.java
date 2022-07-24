package com.example.pmis_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardPM extends AppCompatActivity {
    private ImageButton btn_logout;
    //private FirebaseAuth mAuth;

    RecyclerView recyclerView;
    ProjectInfoAdapter projectInfoAdapter;
    FirebaseDatabase database;
    DatabaseReference reference;
    Button navTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_p_m);
        //mAuth = FirebaseAuth.getInstance();
        navTo = findViewById(R.id.nav);
        navTo = findViewById(R.id.nav);
        navTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(DashboardPM.this, ProjectInfoPM.class));
            }
        });

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



        recyclerView = findViewById(R.id.recycleviewproject);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ProjectListData> options =
                new FirebaseRecyclerOptions.Builder<ProjectListData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("projects"), ProjectListData.class)
                        .build();
        projectInfoAdapter = new ProjectInfoAdapter(options);
        recyclerView.setAdapter(projectInfoAdapter);

        //btn_logout = findViewById(R.id.btnlogout);

        //btn_logout.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //mAuth.signOut();
                //startActivity(new Intent(DashboardPM.this, LoginPage.class));
                //preferences.clearData(this);
                //finish();
            //}
        //});
        Toolbar toolbar = findViewById(R.id.layoutToolBar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    public void logout(MenuItem item) {
        startActivity(new Intent(DashboardPM.this, LoginPage.class));
        preferences.clearData(this);
        finish();
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