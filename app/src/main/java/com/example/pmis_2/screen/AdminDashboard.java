package com.example.pmis_2.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.pmis_2.LoginPage;
import com.example.pmis_2.R;
import com.example.pmis_2.UsersAdmin;
import com.example.pmis_2.preferences;
import com.google.firebase.auth.FirebaseAuth;


public class AdminDashboard extends AppCompatActivity {
    private ImageButton btn_users, btn_projects, btn_logout;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        mAuth = FirebaseAuth.getInstance();
        btn_users = findViewById(R.id.adminDashboardUsersButton);
        btn_projects = findViewById(R.id.adminDashboardProjectButton);
        //btn_logout = findViewById(R.id.btnlogout);
        btn_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, UsersAdmin.class));
            }
        });
        btn_projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, AdminAddProject.class));
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
        startActivity(new Intent(AdminDashboard.this, LoginPage.class));
        preferences.clearData(this);
        finish();
    }


}