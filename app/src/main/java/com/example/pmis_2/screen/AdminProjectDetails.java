package com.example.pmis_2.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmis_2.R;
import com.example.pmis_2.data.FirebaseDatabaseHelper;
import com.example.pmis_2.data.ProjectListData;

import java.util.ArrayList;

public class AdminProjectDetails extends AppCompatActivity {

    ImageView projectDetailsBackButton;
    TextView projectDetailsTitleNameTextView;
    Button projectDetailsUpdateButton, projectDetailsDeleteButton;
    EditText projectDetailsNameEditText, projectDetailsCustomerEditText, projectDetailsManagerEditText, projectDetailsStartEditText, projectDetailsFinishEditText, projectDetailsScopeEditText, projectDetailsScopeEditText2,projectDetailsDelivEditText, projectDetailsDelivEditText2, projectDetailsAccEditText, projectDetailsAccEditText2, projectDetailsTaskEditText, projectDetailsTaskEditText2, projectDetailsTaskEditText3, projectDetailsTaskEditText4, projectDetailsTaskEditText5, projectDetailsPICEditText, projectDetailsPICEditText2, projectDetailsPICEditText3, projectDetailsPICEditText4, projectDetailsPICEditText5, projectDetailsUrgentEditText, projectDetailsUrgentEditText2, projectDetailsUrgentEditText3, projectDetailsUrgentEditText4, projectDetailsUrgentEditText5, projectDetailsStatusEditText, projectDetailsStatusEditText2, projectDetailsStatusEditText3, projectDetailsStatusEditText4, projectDetailsStatusEditText5, projectDetailsTLEditText, projectDetailsTLEditText2, projectDetailsTLEditText3, projectDetailsTLEditText4, projectDetailsTLEditText5;
    String key;
    ProjectListData projectListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_project_details);

        projectDetailsTitleNameTextView = findViewById(R.id.projectDetailsTitleNameTextView);
        projectDetailsNameEditText = findViewById(R.id.projectDetailsNameEditText);
        projectDetailsCustomerEditText = findViewById(R.id.projectDetailsCustomerEditText);
        projectDetailsManagerEditText = findViewById(R.id.projectDetailsManagerEditText);
        projectDetailsBackButton = findViewById(R.id.projectDetailsBackButton);
        projectDetailsStartEditText = findViewById(R.id.projectDetailsStartEditText);
        projectDetailsFinishEditText = findViewById(R.id.projectDetailsFinishEditText);
        projectDetailsScopeEditText = findViewById(R.id.projectDetailsScopeEditText);
        projectDetailsScopeEditText2 = findViewById(R.id.projectDetailsScopeEditText2);
        projectDetailsDelivEditText = findViewById(R.id.projectDetailsDelivEditText);
        projectDetailsDelivEditText2 = findViewById(R.id.projectDetailsDelivEditText2);
        projectDetailsAccEditText = findViewById(R.id.projectDetailsAccEditText);
        projectDetailsAccEditText2 = findViewById(R.id.projectDetailsAccEditText2);
        projectDetailsTaskEditText = findViewById(R.id.projectDetailsTaskEditText);
        projectDetailsTaskEditText2 = findViewById(R.id.projectDetailsTaskEditText2);
        projectDetailsTaskEditText3 = findViewById(R.id.projectDetailsTaskEditText3);
        projectDetailsTaskEditText4 = findViewById(R.id.projectDetailsTaskEditText4);
        projectDetailsTaskEditText5 = findViewById(R.id.projectDetailsTaskEditText5);
        projectDetailsPICEditText = findViewById(R.id.projectDetailsPICEditText);
        projectDetailsPICEditText2 = findViewById(R.id.projectDetailsPICEditText2);
        projectDetailsPICEditText3 = findViewById(R.id.projectDetailsPICEditText3);
        projectDetailsPICEditText4 = findViewById(R.id.projectDetailsPICEditText4);
        projectDetailsPICEditText5 = findViewById(R.id.projectDetailsPICEditText5);
        projectDetailsUrgentEditText = findViewById(R.id.projectDetailsUrgencyEditText);
        projectDetailsUrgentEditText2 = findViewById(R.id.projectDetailsUrgencyEditText2);
        projectDetailsUrgentEditText3 = findViewById(R.id.projectDetailsUrgencyEditText3);
        projectDetailsUrgentEditText4 = findViewById(R.id.projectDetailsUrgencyEditText4);
        projectDetailsUrgentEditText5 = findViewById(R.id.projectDetailsUrgencyEditText5);
        projectDetailsStatusEditText = findViewById(R.id.projectDetailsStatusEditText);
        projectDetailsStatusEditText2 = findViewById(R.id.projectDetailsStatusEditText2);
        projectDetailsStatusEditText3 = findViewById(R.id.projectDetailsStatusEditText3);
        projectDetailsStatusEditText4 = findViewById(R.id.projectDetailsStatusEditText4);
        projectDetailsStatusEditText5 = findViewById(R.id.projectDetailsStatusEditText5);
        projectDetailsTLEditText = findViewById(R.id.projectDetailsTLEditText);
        projectDetailsTLEditText2 = findViewById(R.id.projectDetailsTLEditText2);
        projectDetailsTLEditText3 = findViewById(R.id.projectDetailsTLEditText3);
        projectDetailsTLEditText4 = findViewById(R.id.projectDetailsTLEditText4);
        projectDetailsTLEditText5 = findViewById(R.id.projectDetailsTLEditText5);
        projectDetailsUpdateButton = findViewById(R.id.projectDetailsUpdateButton);
        projectDetailsDeleteButton = findViewById(R.id.projectDetailsDeleteButton);

        key = getIntent().getStringExtra("key");
        projectListData = getIntent().getParcelableExtra("data");

        getIntentData();

        projectDetailsUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProjectListData projectListData = new ProjectListData();
                projectListData.setCustomer(projectDetailsCustomerEditText.getText().toString());
                projectListData.setProject_name(projectDetailsNameEditText.getText().toString());
                projectListData.setProject_manager(projectDetailsManagerEditText.getText().toString());
                projectListData.setStart_date(projectDetailsStartEditText.getText().toString());
                projectListData.setFinish_date(projectDetailsFinishEditText.getText().toString());
                projectListData.setProjectScope1(projectDetailsScopeEditText.getText().toString());
                projectListData.setProjectScope2(projectDetailsScopeEditText2.getText().toString());
                projectListData.setDeliv1(projectDetailsDelivEditText.getText().toString());
                projectListData.setDeliv2(projectDetailsDelivEditText2.getText().toString());
                projectListData.setDod1(projectDetailsAccEditText.getText().toString());
                projectListData.setDod2(projectDetailsAccEditText2.getText().toString());
                projectListData.setTask1(projectDetailsTaskEditText.getText().toString());
                projectListData.setTask2(projectDetailsTaskEditText2.getText().toString());
                projectListData.setTask3(projectDetailsTaskEditText3.getText().toString());
                projectListData.setTask4(projectDetailsTaskEditText4.getText().toString());
                projectListData.setTask5(projectDetailsTaskEditText5.getText().toString());
                projectListData.setPIC1(projectDetailsPICEditText.getText().toString());
                projectListData.setPIC2(projectDetailsPICEditText2.getText().toString());
                projectListData.setPIC3(projectDetailsPICEditText3.getText().toString());
                projectListData.setPIC4(projectDetailsPICEditText4.getText().toString());
                projectListData.setPIC5(projectDetailsPICEditText5.getText().toString());
                projectListData.setUrg1(projectDetailsUrgentEditText.getText().toString());
                projectListData.setUrg2(projectDetailsUrgentEditText2.getText().toString());
                projectListData.setUrg3(projectDetailsUrgentEditText3.getText().toString());
                projectListData.setUrg4(projectDetailsUrgentEditText4.getText().toString());
                projectListData.setUrg5(projectDetailsUrgentEditText5.getText().toString());
                projectListData.setStat1(projectDetailsStatusEditText.getText().toString());
                projectListData.setStat2(projectDetailsStatusEditText2.getText().toString());
                projectListData.setStat3(projectDetailsStatusEditText3.getText().toString());
                projectListData.setStat4(projectDetailsStatusEditText4.getText().toString());
                projectListData.setStat5(projectDetailsStatusEditText5.getText().toString());
                projectListData.setTL1(projectDetailsTLEditText.getText().toString());
                projectListData.setTL2(projectDetailsTLEditText2.getText().toString());
                projectListData.setTL3(projectDetailsTLEditText3.getText().toString());
                projectListData.setTL4(projectDetailsTLEditText4.getText().toString());
                projectListData.setTL5(projectDetailsTLEditText5.getText().toString());

                new FirebaseDatabaseHelper().updateProject(key, projectListData, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void dataIsLoad(ArrayList<ProjectListData> projectListDataArrayList, ArrayList<String> keys) {}

                    @Override
                    public void dataIsUpdate() { updatedData(); }

                    @Override
                    public void dataIsDelete() {}
                });
            }
        });

        projectDetailsDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FirebaseDatabaseHelper().deleteProject(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void dataIsLoad(ArrayList<ProjectListData> projectListDataArrayList, ArrayList<String> keys) { }

                    @Override
                    public void dataIsUpdate() { }

                    @Override
                    public void dataIsDelete() { deletedData(); }
                });
            }
        });
    }

    public void getIntentData() {
        projectDetailsTitleNameTextView.setText(projectListData.getProject_name());
        projectDetailsNameEditText.setText(projectListData.getProject_name());
        projectDetailsCustomerEditText.setText(projectListData.getCustomer());
        projectDetailsManagerEditText.setText(projectListData.getProject_manager());
        projectDetailsStartEditText.setText(projectListData.getStart_date());
        projectDetailsFinishEditText.setText(projectListData.getFinish_date());
        projectDetailsScopeEditText.setText(projectListData.getProjectScope1());
        projectDetailsScopeEditText2.setText(projectListData.getProjectScope2());
        projectDetailsDelivEditText.setText(projectListData.getDeliv1());
        projectDetailsDelivEditText2.setText(projectListData.getDeliv2());
        projectDetailsAccEditText.setText(projectListData.getDod1());
        projectDetailsAccEditText2.setText(projectListData.getDod2());
        projectDetailsTaskEditText.setText(projectListData.getTask1());
        projectDetailsTaskEditText2.setText(projectListData.getTask2());
        projectDetailsTaskEditText3.setText(projectListData.getTask3());
        projectDetailsTaskEditText4.setText(projectListData.getTask4());
        projectDetailsTaskEditText5.setText(projectListData.getTask5());
        projectDetailsPICEditText.setText(projectListData.getPIC1());
        projectDetailsPICEditText2.setText(projectListData.getPIC2());
        projectDetailsPICEditText3.setText(projectListData.getPIC3());
        projectDetailsPICEditText4.setText(projectListData.getPIC4());
        projectDetailsPICEditText5.setText(projectListData.getPIC5());
        projectDetailsUrgentEditText.setText(projectListData.getUrg1());
        projectDetailsUrgentEditText2.setText(projectListData.getUrg2());
        projectDetailsUrgentEditText3.setText(projectListData.getUrg3());
        projectDetailsUrgentEditText4.setText(projectListData.getUrg4());
        projectDetailsUrgentEditText5.setText(projectListData.getUrg5());
        projectDetailsStatusEditText.setText(projectListData.getStat1());
        projectDetailsStatusEditText2.setText(projectListData.getStat2());
        projectDetailsStatusEditText3.setText(projectListData.getStat3());
        projectDetailsStatusEditText4.setText(projectListData.getStat4());
        projectDetailsStatusEditText5.setText(projectListData.getStat5());
        projectDetailsTLEditText.setText(projectListData.getTL1());
        projectDetailsTLEditText2.setText(projectListData.getTL2());
        projectDetailsTLEditText3.setText(projectListData.getTL3());
        projectDetailsTLEditText4.setText(projectListData.getTL4());
        projectDetailsTLEditText5.setText(projectListData.getTL5());
    }

    private void updatedData() {
        Toast.makeText(AdminProjectDetails.this, "Data Updated", Toast.LENGTH_SHORT).show();

        projectDetailsTitleNameTextView.setText("");
        projectDetailsNameEditText.setText("");
        projectDetailsCustomerEditText.setText("");
        projectDetailsManagerEditText.setText("");
        projectDetailsStartEditText.setText("");
        projectDetailsFinishEditText.setText("");
        projectDetailsScopeEditText.setText("");
        projectDetailsScopeEditText2.setText("");
        projectDetailsDelivEditText.setText("");
        projectDetailsDelivEditText2.setText("");
        projectDetailsAccEditText.setText("");
        projectDetailsAccEditText2.setText("");
        projectDetailsTaskEditText.setText("");
        projectDetailsTaskEditText2.setText("");
        projectDetailsTaskEditText3.setText("");
        projectDetailsTaskEditText4.setText("");
        projectDetailsTaskEditText5.setText("");
        projectDetailsPICEditText.setText("");
        projectDetailsPICEditText2.setText("");
        projectDetailsPICEditText3.setText("");
        projectDetailsPICEditText4.setText("");
        projectDetailsPICEditText5.setText("");
        projectDetailsUrgentEditText.setText("");
        projectDetailsUrgentEditText2.setText("");
        projectDetailsUrgentEditText3.setText("");
        projectDetailsUrgentEditText4.setText("");
        projectDetailsUrgentEditText5.setText("");
        projectDetailsStatusEditText.setText("");
        projectDetailsStatusEditText2.setText("");
        projectDetailsStatusEditText3.setText("");
        projectDetailsStatusEditText4.setText("");
        projectDetailsStatusEditText5.setText("");
        projectDetailsTLEditText.setText("");
        projectDetailsTLEditText2.setText("");
        projectDetailsTLEditText3.setText("");
        projectDetailsTLEditText4.setText("");
        projectDetailsTLEditText5.setText("");

        Intent a = new Intent(AdminProjectDetails.this, AdminProjectList.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
        finish();
    }

    private void deletedData() {
        Toast.makeText(AdminProjectDetails.this, "Data Deleted", Toast.LENGTH_SHORT).show();

        Intent a = new Intent(AdminProjectDetails.this, AdminProjectList.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
        finish();
    }
}