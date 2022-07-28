package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmis_2.data.ProjectListData;


public class ProjectInfoFragment extends Fragment {

    TextView MembersTitleNameTextView;
    EditText MemProjectNameEditText, MemCustomerEditText, MemManagerEditText, MemStartEditText, MemFinishEditText;
    String key;
    ProjectListData projectListData;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_project_info, container, false);
        MembersTitleNameTextView = view.findViewById(R.id.MemTitleNameTextView);
        MemProjectNameEditText = view.findViewById(R.id.MemProjectNameEditText);
        MemCustomerEditText = view.findViewById(R.id.MemCustomerEditText);
        MemManagerEditText = view.findViewById(R.id.MemManagerEditText);
        MemStartEditText = view.findViewById(R.id.MemStartEditText);
        MemFinishEditText = view.findViewById(R.id.MemFinishEditText);

        key = getActivity().getIntent().getStringExtra("key");
        projectListData = getActivity().getIntent().getParcelableExtra("data");

        MembersTitleNameTextView.setText(projectListData.getProject_name());
        MemProjectNameEditText.setText(projectListData.getProject_name());
        MemCustomerEditText.setText(projectListData.getCustomer());
        MemManagerEditText.setText(projectListData.getProject_manager());
        MemStartEditText.setText(projectListData.getStart_date());
        MemFinishEditText.setText(projectListData.getFinish_date());

        return view;

    }


}