package com.example.pmis_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pmis_2.screen.AdminDashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UsersAdmin extends AppCompatActivity {
    private ImageButton return_dash;
    private AppCompatButton btn_regist, btn_seeusers;
    private EditText new_name, new_email, new_password, new_usertype;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private static final  String USER = "users";
    private static final String TAG = "UsersAdmin";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_admin);
        new_name = findViewById(R.id.newname);
        new_email = findViewById(R.id.newemail);
        new_password = findViewById(R.id.newpass);
        new_usertype = findViewById(R.id.newusertype);
        return_dash = findViewById(R.id.btnback1);
        btn_regist = findViewById(R.id.btnregist);
        btn_seeusers = findViewById(R.id.btnseeusers);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
        mAuth = FirebaseAuth.getInstance();

        btn_regist.setOnClickListener(v -> {
            String name = new_name.getText().toString();
            String email = new_email.getText().toString();
            String password = new_password.getText().toString();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter email and password",
                        Toast.LENGTH_LONG).show();
                return;
            }
            String usertype = new_usertype.getText().toString();


            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        String uid = task.getResult().getUser().getUid();

                        user = new User(name, email, password, usertype, uid);

                        database.getReference().child("users").child(uid).setValue(user);


                        Toast.makeText(UsersAdmin.this, "User Registered Successfully.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UsersAdmin.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                    }
                }
            });
            clearAll();


        });
        btn_seeusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersAdmin.this, RegisteredAdmin.class));
            }
        });
        return_dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsersAdmin.this, AdminDashboard.class));
            }
        });
    }

    private void clearAll()
    {
        new_name.setText("");
        new_email.setText("");
        new_password.setText("");
        new_usertype.setText("");
    }



}