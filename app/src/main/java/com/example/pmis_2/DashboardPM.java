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

import java.util.ArrayList;

public class DashboardPM extends AppCompatActivity {
    private ImageButton btn_logout;
    //private FirebaseAuth mAuth;

    RecyclerView pmprojectrecyclerView;
    ProjectInfoAdapter projectInfoAdapter;
    FirebaseDatabase database;
    DatabaseReference reference;

    private ProjectItemListener listener = new ProjectItemListener() {
        @Override
        public void onItemClicked(ProjectListData projectListData) {
            Intent intent = new Intent(DashboardPM.this, ProjectInfoPM.class);
            intent.putExtra("data", projectListData);
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_p_m);
        //mAuth = FirebaseAuth.getInstance();


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



        pmprojectrecyclerView = findViewById(R.id.pmrecycleviewproject);
        //recyclerView.setHasFixedSize(true);

        new FirebaseDatabaseHelper().readProjectList(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void dataIsLoad(ArrayList<ProjectListData> projectListDataArrayList, ArrayList<String> keys) {
                new ProjectListConfig().setConfig(pmprojectrecyclerView, DashboardPM.this, projectListDataArrayList, keys, listener);
            }

            @Override
            public void dataIsUpdate() {
            }

            @Override
            public void dataIsDelete() {
            }
        });
//        pmprojectrecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        FirebaseRecyclerOptions<ProjectListData> options =
//                new FirebaseRecyclerOptions.Builder<ProjectListData>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("projects"), ProjectListData.class)
//                        .build();
//        projectInfoAdapter = new ProjectInfoAdapter(options);
//        pmprojectrecyclerView.setAdapter(projectInfoAdapter);

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

}