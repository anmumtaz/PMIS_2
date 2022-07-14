package com.example.pmis_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class AddProjects extends AppCompatActivity {
    ImageButton btnback;
    EditText edtProName, edtCust, edtPM, edtStart, edtFinish, edtScope1, edtScope2,edtDeliv1, edtDeliv2, edtDoD1, edtDoD2, edtTask1, edtTask2, edtTask3, edtTask4, edtTask5, edtPIC1, edtPIC2, edtPIC3, edtPIC4, edtPIC5, edtUrg1, edtUrg2, edtUrg3, edtUrg4, edtUrg5, edtStat1, edtStat2, edtStat3, edtStat4, edtStat5;
    AppCompatButton savepro, seepro;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ProjectInfo projectInfo;
    ScopeInfo scopeInfo;
    ResourceInfo resourceInfo;
    private  DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_projects);

        btnback = findViewById(R.id.btnback1);
        edtProName = findViewById(R.id.edtPName);
        edtCust = findViewById(R.id.edtCust);
        edtPM = findViewById(R.id.edtPM);
        edtStart = findViewById(R.id.edtStart);
        edtFinish = findViewById(R.id.edtFinish);
        edtScope1 = findViewById(R.id.edtScope1);
        edtScope2 = findViewById(R.id.edtScope2);
        edtDeliv1 = findViewById(R.id.edtDeliv1);
        edtDeliv2 = findViewById(R.id.edtDeliv2);
        edtDoD1 = findViewById(R.id.edtDoD1);
        edtDoD2 = findViewById(R.id.edtDoD2);
        edtTask1 = findViewById(R.id.edtTask1);
        edtTask2 = findViewById(R.id.edtTask2);
        edtTask3 = findViewById(R.id.edtTask3);
        edtTask4 = findViewById(R.id.edtTask4);
        edtTask5 = findViewById(R.id.edtTask5);
        edtPIC1 = findViewById(R.id.edtPIC1);
        edtPIC2 = findViewById(R.id.edtPIC2);
        edtPIC3 = findViewById(R.id.edtPIC3);
        edtPIC4 = findViewById(R.id.edtPIC4);
        edtPIC5 = findViewById(R.id.edtPIC5);
        edtUrg1 = findViewById(R.id.edtUr1);
        edtUrg2 = findViewById(R.id.edtUr2);
        edtUrg3 = findViewById(R.id.edtUr3);
        edtUrg4 = findViewById(R.id.edtUr4);
        edtUrg5 = findViewById(R.id.edtUr5);
        edtStat1 = findViewById(R.id.edtStat1);
        edtStat2 = findViewById(R.id.edtStat2);
        edtStat3 = findViewById(R.id.edtStat3);
        edtStat4 = findViewById(R.id.edtStat4);
        edtStat5 = findViewById(R.id.edtStat5);


        savepro = findViewById(R.id.btnSaveProj);
        seepro = findViewById(R.id.btnSeeProj);

        edtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(AddProjects.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        edtStart.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });
        edtFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(AddProjects.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        edtFinish.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddProjects.this, DashboardAdmin.class));
            }
        });

        seepro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddProjects.this, ProjectsAdmin.class));
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("projects");



        projectInfo = new ProjectInfo();


        savepro.setOnClickListener(v -> {
            String proName = edtProName.getText().toString();
            String cust = edtCust.getText().toString();
            String pmName = edtPM.getText().toString();
            String start = edtStart.getText().toString();
            String finish = edtFinish.getText().toString();

            String scope1 = edtScope1.getText().toString();
            String scope2 = edtScope2.getText().toString();
            String deliv1 = edtDeliv1.getText().toString();
            String deliv2 = edtDeliv2.getText().toString();
            String dod1 = edtDoD1.getText().toString();
            String dod2 = edtDoD2.getText().toString();

            String task1 = edtTask1.getText().toString();
            String task2 = edtTask2.getText().toString();
            String task3 = edtTask3.getText().toString();
            String task4 = edtTask4.getText().toString();
            String task5 = edtTask5.getText().toString();
            String pic1 = edtPIC1.getText().toString();
            String pic2 = edtPIC2.getText().toString();
            String pic3 = edtPIC3.getText().toString();
            String pic4 = edtPIC4.getText().toString();
            String pic5 = edtPIC5.getText().toString();
            String urg1 = edtUrg1.getText().toString();
            String urg2 = edtUrg2.getText().toString();
            String urg3 = edtUrg3.getText().toString();
            String urg4 = edtUrg4.getText().toString();
            String urg5 = edtUrg5.getText().toString();
            String stat1 = edtStat1.getText().toString();
            String stat2 = edtStat2.getText().toString();
            String stat3 = edtStat3.getText().toString();
            String stat4 = edtStat4.getText().toString();
            String stat5 = edtStat5.getText().toString();




            if (TextUtils.isEmpty(proName) || TextUtils.isEmpty(cust) || TextUtils.isEmpty(pmName) || TextUtils.isEmpty(start) || TextUtils.isEmpty(finish) || TextUtils.isEmpty(scope1) || TextUtils.isEmpty(scope2) || TextUtils.isEmpty(deliv1) || TextUtils.isEmpty(deliv2) || TextUtils.isEmpty(dod1) || TextUtils.isEmpty(dod2)){
                Toast.makeText(AddProjects.this, "Please add some data", Toast.LENGTH_SHORT).show();

            } else {
                addProjectInfo(proName, cust, pmName, start, finish, scope1, scope2, deliv1, deliv2, dod1, dod2, task1, task2, task3, task4, task5, pic1, pic2, pic3, pic4, pic5, urg1,urg2, urg3, urg4, urg5, stat1, stat2, stat3, stat4, stat5);

            }
            clearAll();

        });

    }
    private void clearAll()
    {
        edtProName.setText("");
        edtCust.setText("");
        edtPM.setText("");
        edtStart.setText("");
        edtFinish.setText("");
        edtScope1.setText("");
        edtScope2.setText("");
        edtDeliv1.setText("");
        edtDeliv2.setText("");
        edtDoD1.setText("");
        edtDoD2.setText("");
        edtTask1.setText("");
        edtTask2.setText("");
        edtTask3.setText("");
        edtTask4.setText("");
        edtTask5.setText("");
        edtPIC1.setText("");
        edtPIC2.setText("");
        edtPIC3.setText("");
        edtPIC4.setText("");
        edtPIC5.setText("");
        edtUrg1.setText("");
        edtUrg2.setText("");
        edtUrg3.setText("");
        edtUrg4.setText("");
        edtUrg5.setText("");
        edtStat1.setText("");
        edtStat2.setText("");
        edtStat3.setText("");
        edtStat4.setText("");
        edtStat5.setText("");

    }



    private void addProjectInfo(String proName, String cust, String pmName, String start, String finish, String scope1, String scope2, String deliv1, String deliv2, String dod1, String dod2, String task1, String task2, String task3, String task4, String task5, String PIC1, String PIC2, String PIC3, String PIC4, String PIC5, String urg1, String urg2, String urg3, String urg4, String urg5, String stat1, String stat2, String stat3, String stat4, String stat5) {
        projectInfo.setProject_name(proName);
        projectInfo.setCustomer(cust);
        projectInfo.setProject_manager(pmName);
        projectInfo.setStart_date(start);
        projectInfo.setFinish_date(finish);

        projectInfo.setProjectScope1(scope1);
        projectInfo.setProjectScope2(scope2);
        projectInfo.setDeliv1(deliv1);
        projectInfo.setDeliv2(deliv2);
        projectInfo.setDod1(dod1);
        projectInfo.setDod2(dod2);

        projectInfo.setTask1(task1);
        projectInfo.setTask2(task2);
        projectInfo.setTask3(task3);
        projectInfo.setTask4(task4);
        projectInfo.setTask5(task5);
        projectInfo.setPIC1(PIC1);
        projectInfo.setPIC2(PIC2);
        projectInfo.setPIC3(PIC3);
        projectInfo.setPIC4(PIC4);
        projectInfo.setPIC5(PIC5);
        projectInfo.setUrg1(urg1);
        projectInfo.setUrg2(urg2);
        projectInfo.setUrg3(urg3);
        projectInfo.setUrg4(urg4);
        projectInfo.setUrg5(urg5);
        projectInfo.setStat1(stat1);
        projectInfo.setStat2(stat2);
        projectInfo.setStat3(stat3);
        projectInfo.setStat4(stat4);
        projectInfo.setStat5(stat5);


        String keyId = databaseReference.push().getKey();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(keyId).setValue(projectInfo);
                Toast.makeText(AddProjects.this, "data added", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AddProjects.this, "Fail to add data", Toast.LENGTH_SHORT).show();
            }
        });

    }

}