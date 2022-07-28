package com.example.pmis_2.screen;

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

import com.example.pmis_2.R;
import com.example.pmis_2.data.ProjectListData;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class AdminAddProject extends AppCompatActivity {
    ImageButton addProjectBackButton;
    EditText addProjectNameEditText, addProjectCustomerEditText, addProjectManagerEditText, addProjectStartEditText, addProjectFinishEditText, addProjectScopeEditText, addProjectScopeEditText2,addProjectDelivEditText, addProjectDelivEditText2, addProjectAccEditText, addProjectAccEditText2, addProjectTaskEditText, addProjectTaskEditText2, addProjectTaskEditText3, addProjectTaskEditText4, addProjectTaskEditText5, addProjectPICEditText, addProjectPICEditText2, addProjectPICEditText3, addProjectPICEditText4, addProjectPICEditText5, addProjectUrgentEditText, addProjectUrgentEditText2, addProjectUrgentEditText3, addProjectUrgentEditText4, addProjectUrgentEditText5, addProjectStatusEditText, addProjectStatusEditText2, addProjectStatusEditText3, addProjectStatusEditText4, addProjectStatusEditText5, addProjectTLEditText, addProjectTLEditText2, addProjectTLEditText3, addProjectTLEditText4, addProjectTLEditText5;
    AppCompatButton savepro, seepro;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ProjectListData projectListData;
    private  DatePickerDialog picker;
    String keyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_project);

        addProjectBackButton = findViewById(R.id.addProjectBackButton);
        addProjectNameEditText = findViewById(R.id.addProjectNameEditText);
        addProjectCustomerEditText = findViewById(R.id.addProjectCustomerEditText);
        addProjectManagerEditText = findViewById(R.id.addProjectManagerEditText);
        addProjectStartEditText = findViewById(R.id.addProjectStartEditText);
        addProjectFinishEditText = findViewById(R.id.addProjectFinishEditText);
        addProjectScopeEditText = findViewById(R.id.addProjectScopeEditText);
        addProjectScopeEditText2 = findViewById(R.id.addProjectScopeEditText2);
        addProjectDelivEditText = findViewById(R.id.addProjectDelivEditText);
        addProjectDelivEditText2 = findViewById(R.id.addProjectDelivEditText2);
        addProjectAccEditText = findViewById(R.id.addProjectAccEditText);
        addProjectAccEditText2 = findViewById(R.id.addProjectAccEditText2);
        addProjectTaskEditText = findViewById(R.id.addProjectTaskEditText);
        addProjectTaskEditText2 = findViewById(R.id.addProjectTaskEditText2);
        addProjectTaskEditText3 = findViewById(R.id.addProjectTaskEditText3);
        addProjectTaskEditText4 = findViewById(R.id.addProjectTaskEditText4);
        addProjectTaskEditText5 = findViewById(R.id.addProjectTaskEditText5);
        addProjectPICEditText = findViewById(R.id.addProjectPICEditText);
        addProjectPICEditText2 = findViewById(R.id.addProjectPICEditText2);
        addProjectPICEditText3 = findViewById(R.id.addProjectPICEditText3);
        addProjectPICEditText4 = findViewById(R.id.addProjectPICEditText4);
        addProjectPICEditText5 = findViewById(R.id.addProjectPICEditText5);
        addProjectUrgentEditText = findViewById(R.id.addProjectUrgencyEditText);
        addProjectUrgentEditText2 = findViewById(R.id.addProjectUrgencyEditText2);
        addProjectUrgentEditText3 = findViewById(R.id.addProjectUrgencyEditText3);
        addProjectUrgentEditText4 = findViewById(R.id.addProjectUrgencyEditText4);
        addProjectUrgentEditText5 = findViewById(R.id.addProjectUrgencyEditText5);
        addProjectStatusEditText = findViewById(R.id.addProjectStatusEditText);
        addProjectStatusEditText2 = findViewById(R.id.addProjectStatusEditText2);
        addProjectStatusEditText3 = findViewById(R.id.addProjectStatusEditText3);
        addProjectStatusEditText4 = findViewById(R.id.addProjectStatusEditText4);
        addProjectStatusEditText5 = findViewById(R.id.addProjectStatusEditText5);
        addProjectTLEditText = findViewById(R.id.addProjectTLEditText);
        addProjectTLEditText2 = findViewById(R.id.addProjectTLEditText2);
        addProjectTLEditText3 = findViewById(R.id.addProjectTLEditText3);
        addProjectTLEditText4 = findViewById(R.id.addProjectTLEditText4);
        addProjectTLEditText5 = findViewById(R.id.addProjectTLEditText5);

        savepro = findViewById(R.id.addProjectSaveProjectButton);
        seepro = findViewById(R.id.addProjectSeeProjectButton);

        addProjectStartEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(AdminAddProject.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        addProjectStartEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });
        addProjectFinishEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(AdminAddProject.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        addProjectFinishEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        MaterialDatePicker materialDatePicker1 = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(androidx.core.util.Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();

        addProjectTLEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker1.show(getSupportFragmentManager(), "Tag_picker");
                materialDatePicker1.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        addProjectTLEditText.setText(materialDatePicker1.getHeaderText());
                    }
                });
            }
        });

        MaterialDatePicker materialDatePicker2 = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(androidx.core.util.Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        addProjectTLEditText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker2.show(getSupportFragmentManager(), "Tag_picker");
                materialDatePicker2.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        addProjectTLEditText2.setText(materialDatePicker2.getHeaderText());
                    }
                });
            }
        });

        MaterialDatePicker materialDatePicker3 = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(androidx.core.util.Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        addProjectTLEditText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker3.show(getSupportFragmentManager(), "Tag_picker");
                materialDatePicker3.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        addProjectTLEditText3.setText(materialDatePicker3.getHeaderText());
                    }
                });
            }
        });

        MaterialDatePicker materialDatePicker4 = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(androidx.core.util.Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        addProjectTLEditText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker4.show(getSupportFragmentManager(), "Tag_picker");
                materialDatePicker4.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        addProjectTLEditText4.setText(materialDatePicker4.getHeaderText());
                    }
                });
            }
        });
        MaterialDatePicker materialDatePicker5 = MaterialDatePicker.Builder.dateRangePicker()
                .setSelection(androidx.core.util.Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds())).build();
        addProjectTLEditText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker5.show(getSupportFragmentManager(), "Tag_picker");
                materialDatePicker5.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        addProjectTLEditText5.setText(materialDatePicker5.getHeaderText());
                    }
                });
            }
        });

        addProjectBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminAddProject.this, AdminDashboard.class));
            }
        });

        seepro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminAddProject.this, AdminProjectList.class));
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("projects");

        projectListData = new ProjectListData();

        savepro.setOnClickListener(v -> {
            String proName = addProjectNameEditText.getText().toString();
            String cust = addProjectCustomerEditText.getText().toString();
            String pmName = addProjectManagerEditText.getText().toString();
            String start = addProjectStartEditText.getText().toString();
            String finish = addProjectFinishEditText.getText().toString();

            String scope1 = addProjectScopeEditText.getText().toString();
            String scope2 = addProjectScopeEditText2.getText().toString();
            String deliv1 = addProjectDelivEditText.getText().toString();
            String deliv2 = addProjectDelivEditText2.getText().toString();
            String dod1 = addProjectAccEditText.getText().toString();
            String dod2 = addProjectAccEditText2.getText().toString();

            String task1 = addProjectTaskEditText.getText().toString();
            String task2 = addProjectTaskEditText2.getText().toString();
            String task3 = addProjectTaskEditText3.getText().toString();
            String task4 = addProjectTaskEditText4.getText().toString();
            String task5 = addProjectTaskEditText5.getText().toString();
            String pic1 = addProjectPICEditText.getText().toString();
            String pic2 = addProjectPICEditText2.getText().toString();
            String pic3 = addProjectPICEditText3.getText().toString();
            String pic4 = addProjectPICEditText4.getText().toString();
            String pic5 = addProjectPICEditText5.getText().toString();
            String urg1 = addProjectUrgentEditText.getText().toString();
            String urg2 = addProjectUrgentEditText2.getText().toString();
            String urg3 = addProjectUrgentEditText3.getText().toString();
            String urg4 = addProjectUrgentEditText4.getText().toString();
            String urg5 = addProjectUrgentEditText5.getText().toString();
            String stat1 = addProjectStatusEditText.getText().toString();
            String stat2 = addProjectStatusEditText2.getText().toString();
            String stat3 = addProjectStatusEditText3.getText().toString();
            String stat4 = addProjectStatusEditText4.getText().toString();
            String stat5 = addProjectStatusEditText5.getText().toString();
            String tl1 = addProjectTLEditText.getText().toString();
            String tl2 = addProjectTLEditText2.getText().toString();
            String tl3 = addProjectTLEditText3.getText().toString();
            String tl4 = addProjectTLEditText4.getText().toString();
            String tl5 = addProjectTLEditText5.getText().toString();


            if (TextUtils.isEmpty(proName) || TextUtils.isEmpty(cust) || TextUtils.isEmpty(pmName) || TextUtils.isEmpty(start) || TextUtils.isEmpty(finish) || TextUtils.isEmpty(scope1) || TextUtils.isEmpty(scope2) || TextUtils.isEmpty(deliv1) || TextUtils.isEmpty(deliv2) || TextUtils.isEmpty(dod1) || TextUtils.isEmpty(dod2)){
                Toast.makeText(AdminAddProject.this, "Please add some data", Toast.LENGTH_SHORT).show();

            } else {
                addProjectInfo(keyId, proName, cust, pmName, start, finish, scope1, scope2, deliv1, deliv2, dod1, dod2, task1, task2, task3, task4, task5, pic1, pic2, pic3, pic4, pic5, urg1,urg2, urg3, urg4, urg5, stat1, stat2, stat3, stat4, stat5, tl1, tl2, tl3, tl4, tl5);

            }
            clearAll();

        });

    }
    private void clearAll()
    {
        addProjectNameEditText.setText("");
        addProjectCustomerEditText.setText("");
        addProjectManagerEditText.setText("");
        addProjectStartEditText.setText("");
        addProjectFinishEditText.setText("");
        addProjectScopeEditText.setText("");
        addProjectScopeEditText2.setText("");
        addProjectDelivEditText.setText("");
        addProjectDelivEditText2.setText("");
        addProjectAccEditText.setText("");
        addProjectAccEditText2.setText("");
        addProjectTaskEditText.setText("");
        addProjectTaskEditText2.setText("");
        addProjectTaskEditText3.setText("");
        addProjectTaskEditText4.setText("");
        addProjectTaskEditText5.setText("");
        addProjectPICEditText.setText("");
        addProjectPICEditText2.setText("");
        addProjectPICEditText3.setText("");
        addProjectPICEditText4.setText("");
        addProjectPICEditText5.setText("");
        addProjectUrgentEditText.setText("");
        addProjectUrgentEditText2.setText("");
        addProjectUrgentEditText3.setText("");
        addProjectUrgentEditText4.setText("");
        addProjectUrgentEditText5.setText("");
        addProjectStatusEditText.setText("");
        addProjectStatusEditText2.setText("");
        addProjectStatusEditText3.setText("");
        addProjectStatusEditText4.setText("");
        addProjectStatusEditText5.setText("");
        addProjectTLEditText.setText("");
        addProjectTLEditText2.setText("");
        addProjectTLEditText3.setText("");
        addProjectTLEditText4.setText("");
        addProjectTLEditText5.setText("");
    }


    private void addProjectInfo(String key, String proName, String cust, String pmName, String start, String finish, String scope1, String scope2, String deliv1, String deliv2, String dod1, String dod2, String task1, String task2, String task3, String task4, String task5, String PIC1, String PIC2, String PIC3, String PIC4, String PIC5, String urg1, String urg2, String urg3, String urg4, String urg5, String stat1, String stat2, String stat3, String stat4, String stat5, String tl1, String tl2, String tl3, String tl4, String tl5 ) {
        projectListData.setId(key);
        projectListData.setProject_name(proName);
        projectListData.setCustomer(cust);
        projectListData.setProject_manager(pmName);
        projectListData.setStart_date(start);
        projectListData.setFinish_date(finish);

        projectListData.setProjectScope1(scope1);
        projectListData.setProjectScope2(scope2);
        projectListData.setDeliv1(deliv1);
        projectListData.setDeliv2(deliv2);
        projectListData.setDod1(dod1);
        projectListData.setDod2(dod2);

        projectListData.setTask1(task1);
        projectListData.setTask2(task2);
        projectListData.setTask3(task3);
        projectListData.setTask4(task4);
        projectListData.setTask5(task5);
        projectListData.setPIC1(PIC1);
        projectListData.setPIC2(PIC2);
        projectListData.setPIC3(PIC3);
        projectListData.setPIC4(PIC4);
        projectListData.setPIC5(PIC5);
        projectListData.setUrg1(urg1);
        projectListData.setUrg2(urg2);
        projectListData.setUrg3(urg3);
        projectListData.setUrg4(urg4);
        projectListData.setUrg5(urg5);
        projectListData.setStat1(stat1);
        projectListData.setStat2(stat2);
        projectListData.setStat3(stat3);
        projectListData.setStat4(stat4);
        projectListData.setStat5(stat5);
        projectListData.setTL1(tl1);
        projectListData.setTL2(tl2);
        projectListData.setTL3(tl3);
        projectListData.setTL4(tl4);
        projectListData.setTL5(tl5);


        keyId = databaseReference.push().getKey();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(keyId).setValue(projectListData);
                Toast.makeText(AdminAddProject.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AdminAddProject.this, "Fail to add data", Toast.LENGTH_SHORT).show();
            }
        });

    }

}