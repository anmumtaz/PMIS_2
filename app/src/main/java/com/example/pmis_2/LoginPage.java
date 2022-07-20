package com.example.pmis_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class LoginPage extends AppCompatActivity {
    private EditText user_name, pass_word;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private AppCompatButton btn_login;
    private User user;
    private Switch active;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user_name=findViewById(R.id.editusername);
        pass_word=findViewById(R.id.editpassword);
        btn_login = findViewById(R.id.btnlogin);
        active = findViewById(R.id.active);
        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        btn_login.setOnClickListener(v -> {
            String email= user_name.getText().toString().trim();
            String password= pass_word.getText().toString().trim();
            if(email.isEmpty())
            {
                user_name.setError("Email is empty");
                user_name.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                user_name.setError("Enter the valid email");
                user_name.requestFocus();
                return;
            }
            if(password.isEmpty())
            {
                pass_word.setError("Password is empty");
                pass_word.requestFocus();
                return;
            }
            if(password.length()<6)
            {
                pass_word.setError("Length of password is more than 6");
                pass_word.requestFocus();
                return;
            }


            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        String uid = task.getResult().getUser().getUid();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        firebaseDatabase.getReference().child("users").child(uid).child("usertype").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String usertype = snapshot.getValue(String.class);
                                if (active.isChecked()){
                                    if (usertype.equals("admin")){
                                        preferences.setDataLogin(LoginPage.this, true);
                                        preferences.setDataAs(LoginPage.this, "admin");
                                        Intent LoginAdmin = new Intent(LoginPage.this, DashboardAdmin.class);
                                        startActivity(LoginAdmin);
                                    }
                                    if (usertype.equals("pm")){
                                        preferences.setDataLogin(LoginPage.this, true);
                                        preferences.setDataAs(LoginPage.this, "pm");
                                        Intent LoginPM = new Intent(LoginPage.this, DashboardPM.class);
                                        startActivity(LoginPM);
                                    }
                                    else if (usertype.equals("staff")){
                                        preferences.setDataLogin(LoginPage.this, true);
                                        preferences.setDataAs(LoginPage.this, "staff");
                                        Intent LoginMembers = new Intent(LoginPage.this, DashboardMembers.class);
                                        startActivity(LoginMembers);
                                    }
                                } else {
                                    if (usertype.equals("admin")){
                                        preferences.setDataLogin(LoginPage.this, false);
                                        Intent LoginAdmin = new Intent(LoginPage.this, DashboardAdmin.class);
                                        startActivity(LoginAdmin);
                                    }
                                    if (usertype.equals("pm")){
                                        preferences.setDataLogin(LoginPage.this, false);
                                        Intent LoginPM = new Intent(LoginPage.this, DashboardPM.class);
                                        startActivity(LoginPM);
                                    }
                                    else if (usertype.equals("staff")){preferences.setDataLogin(LoginPage.this, false);
                                        preferences.setDataLogin(LoginPage.this, false);
                                        Intent LoginMembers = new Intent(LoginPage.this, DashboardMembers.class);
                                        startActivity(LoginMembers);
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    }
                }
            });


        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (preferences.getDataLogin(this)){
            if (preferences.getDataAs(this).equals("admin")){
                Intent LoginAdmin = new Intent(LoginPage.this, DashboardAdmin.class);
                startActivity(LoginAdmin);
                finish();
            } if (preferences.getDataAs(this).equals("pm")){
                Intent LoginPM = new Intent(LoginPage.this, DashboardPM.class);
                startActivity(LoginPM);
                finish();
            } else if (preferences.getDataAs(this).equals("staff")){
                Intent LoginMembers = new Intent(LoginPage.this, DashboardMembers.class);
                startActivity(LoginMembers);
                finish();
            }
        }
    }

}