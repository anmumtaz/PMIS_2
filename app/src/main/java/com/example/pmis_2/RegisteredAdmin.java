package com.example.pmis_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RegisteredAdmin extends AppCompatActivity {

    UserAdapter userAdapter;
    RecyclerView recyclerView;

    FirebaseDatabase database;
    DatabaseReference reference;

    private ImageButton return_dash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_admin);

        return_dash = findViewById(R.id.btnback1);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(RegisteredAdmin.this));

        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), User.class)
                        .build();
        userAdapter = new UserAdapter(options);
        recyclerView.setAdapter(userAdapter);

        return_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisteredAdmin.this, UsersAdmin.class));
            }
        });
    }
    protected void onStart() {
        super.onStart();
        userAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        userAdapter.stopListening();
    }
}