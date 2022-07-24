package com.example.pmis_2.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmis_2.FirebaseDatabaseHelper;
import com.example.pmis_2.ProjectListData;
import com.example.pmis_2.R;

import java.util.ArrayList;

public class AdminProjectDetails extends AppCompatActivity {

    ImageView projectDetailsBackButton;
    TextView projectDetailsTitleNameTextView;
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

        key = getIntent().getStringExtra("key");
        projectListData = getIntent().getParcelableExtra("data");

        getIntentData();
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
}