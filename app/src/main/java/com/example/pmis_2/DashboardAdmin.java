package com.example.pmis_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;


public class DashboardAdmin extends AppCompatActivity {
    private ImageButton btn_users, btn_projects, btn_logout;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        mAuth = FirebaseAuth.getInstance();
        btn_users = findViewById(R.id.btnusers);
        btn_projects = findViewById(R.id.btnprojects);
        //btn_logout = findViewById(R.id.btnlogout);
        btn_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardAdmin.this, UsersAdmin.class));
            }
        });
        btn_projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardAdmin.this, AddProjects.class));
            }
        });
        ///btn_logout.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //mAuth.signOut();
                //startActivity(new Intent(DashboardAdmin.this, LoginPage.class));
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
        startActivity(new Intent(DashboardAdmin.this, LoginPage.class));
        preferences.clearData(this);
        finish();
    }


}