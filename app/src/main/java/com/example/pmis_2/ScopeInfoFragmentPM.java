package com.example.pmis_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ScopeInfoFragmentPM extends Fragment {

    TextView PMScope1, PMScope2, PMDeliv1, PMDeliv2, PMAcc1, PMAcc2;
    String key;
    ProjectListData projectListData;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_scope_info_p_m, container, false);
        PMScope1 = view.findViewById(R.id.PMtvScope1);
        PMScope2 = view.findViewById(R.id.PMtvScope2);
        PMDeliv1 = view.findViewById(R.id.PMtvDeliv1);
        PMDeliv2 = view.findViewById(R.id.PMtvDeliv2);
        PMAcc1 = view.findViewById(R.id.PMtvAcc1);
        PMAcc2 = view.findViewById(R.id.PMtvAcc2);

        key = getActivity().getIntent().getStringExtra("key");
        projectListData = getActivity().getIntent().getParcelableExtra("data");

        PMScope1.setText(projectListData.getProjectScope1());
        PMScope2.setText(projectListData.getProjectScope2());
        PMDeliv1.setText(projectListData.getDeliv1());
        PMDeliv2.setText(projectListData.getDeliv2());
        PMAcc1.setText(projectListData.getDod1());
        PMAcc2.setText(projectListData.getDod2());

        return view;
    }
}