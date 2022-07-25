package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ScopeInfoFragment extends Fragment {

    TextView MemScope1, MemScope2, MemDeliv1, MemDeliv2, MemAcc1, MemAcc2;
    String key;
    ProjectListData projectListData;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_scope_info, container, false);
        MemScope1 = view.findViewById(R.id.MemtvScope1);
        MemScope2 = view.findViewById(R.id.MemtvScope2);
        MemDeliv1 = view.findViewById(R.id.MemtvDeliv1);
        MemDeliv2 = view.findViewById(R.id.MemtvDeliv2);
        MemAcc1 = view.findViewById(R.id.MemtvAcc1);
        MemAcc2 =view.findViewById(R.id.MemtvAcc2);

        key = getActivity().getIntent().getStringExtra("key");
        projectListData = getActivity().getIntent().getParcelableExtra("data");

        MemScope1.setText(projectListData.getProjectScope1());
        MemScope2.setText(projectListData.getProjectScope2());
        MemDeliv1.setText(projectListData.getDeliv1());
        MemDeliv2.setText(projectListData.getDeliv2());
        MemAcc1.setText(projectListData.getDod1());
        MemAcc2.setText(projectListData.getDod2());

        return view;

    }
}