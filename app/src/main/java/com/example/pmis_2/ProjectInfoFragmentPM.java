package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ProjectInfoFragmentPM extends Fragment {

    TextView PMTittleName, PMProName, PMCust, PMManager, PMStart, PMFinish;
    String key;
    ProjectListData projectListData;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_project_info_p_m, container, false);
        PMTittleName = view.findViewById(R.id.PMTitleNameTextView);
        PMProName = view.findViewById(R.id.PMtvPName);
        PMCust = view.findViewById(R.id.PMtvCust);
        PMManager = view.findViewById(R.id.PMtvPM);
        PMStart = view.findViewById(R.id.PMtvStart);
        PMFinish = view.findViewById(R.id.PMtvFinish);

        key = getActivity().getIntent().getStringExtra("key");
        projectListData = getActivity().getIntent().getParcelableExtra("data");

        PMTittleName.setText(projectListData.getProject_name());
        PMProName.setText(projectListData.getProject_name());
        PMCust.setText(projectListData.getCustomer());
        PMManager.setText(projectListData.getProject_manager());
        PMStart.setText(projectListData.getStart_date());
        PMFinish.setText(projectListData.getFinish_date());

        return view;
    }
}